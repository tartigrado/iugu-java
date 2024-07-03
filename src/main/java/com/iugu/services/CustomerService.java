package com.iugu.services;

import com.iugu.IuguConfiguration;
import com.iugu.components.ClientWrapper;
import com.iugu.enums.PayableWith;
import com.iugu.exceptions.IuguException;
import com.iugu.model.Customer;
import com.iugu.model.customer.AddCreditCard;
import com.iugu.model.customer.PaymentMethodCreate;
import com.iugu.model.customer.PaymentMethodEdit;
import com.iugu.model.payment_token.CreatePaymentToken;
import com.iugu.responses.CustomerResponse;
import com.iugu.responses.CustomersResponse;
import com.iugu.responses.customer.PaymentMethodListResponse;
import com.iugu.responses.customer.PaymentMethodResponse;
import com.iugu.responses.payment_token.PaymentTokenResponse;
import com.iugu.services.generic.GenericService;
import com.iugu.utils.UriUtils;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

public class CustomerService extends GenericService {

    private final String FIND_ALL_URL = IuguConfiguration.url("/customers");
    private final String CREATE_URL = IuguConfiguration.url("/customers");
    private final String FIND_URL = IuguConfiguration.url("/customers/%s");
    private final String FIND_PARAMS_URL = IuguConfiguration.url("/customers?%s");
    private final String CHANGE_URL = IuguConfiguration.url("/customers/%s");
    private final String REMOVE_URL = IuguConfiguration.url("/customers/%s");
    private final String FIND_OR_CREATE_PAYMENT_METHODS = IuguConfiguration.url("/customers/%s/payment_methods");
    private final String DETAIL_EDIT_DELETE_PAYMENT_METHODS = IuguConfiguration.url("/customers/%s/payment_methods/%s");

    public CustomerService(IuguConfiguration iuguConfiguration) {
        super(iuguConfiguration);
    }

    public CustomerResponse create(Customer customer) throws IuguException {
        try (ClientWrapper client = getIugu().getNewClient()) {
            Response response = client.target(CREATE_URL).request().post(Entity.entity(customer, MediaType.APPLICATION_JSON));

            int ResponseStatus = response.getStatus();
            String ResponseText = null;

            if (ResponseStatus == 200)
                return response.readEntity(CustomerResponse.class);

            // Error Happened
            if (response.hasEntity())
                ResponseText = response.readEntity(String.class);

            response.close();

            throw new IuguException("Error creating customer!", ResponseStatus, ResponseText);
        }
    }

    public CustomerResponse find(String id) throws IuguException {
        try (ClientWrapper client = getIugu().getNewClient()) {
            Response response = client.target(String.format(FIND_URL, id)).request().get();

            int ResponseStatus = response.getStatus();
            String ResponseText = null;

            if (ResponseStatus == 200)
                return response.readEntity(CustomerResponse.class);

            // Error Happened
            if (response.hasEntity())
                ResponseText = response.readEntity(String.class);

            response.close();

            throw new IuguException("Error finding customer!", ResponseStatus, ResponseText);
        }
    }

    public CustomerResponse change(String id, Customer customer) throws IuguException {
        try (ClientWrapper client = getIugu().getNewClient()) {
            Response response = client.target(String.format(CHANGE_URL, id)).request().put(Entity.entity(customer, MediaType.APPLICATION_JSON));

            int ResponseStatus = response.getStatus();
            String ResponseText = null;

            if (ResponseStatus == 200)
                return response.readEntity(CustomerResponse.class);

            // Error Happened
            if (response.hasEntity())
                ResponseText = response.readEntity(String.class);

            response.close();

            throw new IuguException("Error changing customer!", ResponseStatus, ResponseText);
        }
    }

    public CustomerResponse remove(String id) throws IuguException {
        try (ClientWrapper client = getIugu().getNewClient()) {
            Response response = client.target(String.format(REMOVE_URL, id)).request().delete();

            int ResponseStatus = response.getStatus();
            String ResponseText = null;

            if (ResponseStatus == 200)
                return response.readEntity(CustomerResponse.class);

            // Error Happened
            if (response.hasEntity())
                ResponseText = response.readEntity(String.class);

            response.close();

            throw new IuguException("Error removing customer!", ResponseStatus, ResponseText);
        }
    }

    public CustomersResponse findByParams(String params) throws IuguException {
        try (ClientWrapper client = getIugu().getNewClient()) {
            Response response = client.target(String.format(FIND_PARAMS_URL, params)).request().get();
            int ResponseStatus = response.getStatus();
            String ResponseText = null;

            if (ResponseStatus == 200)
                return response.readEntity(CustomersResponse.class);

            // Error Happened
            if (response.hasEntity())
                ResponseText = response.readEntity(String.class);

            response.close();

            throw new IuguException("Error finding customers!", ResponseStatus, ResponseText);
        }
    }

    public PaymentMethodListResponse listPaymentMethods(String customerId) throws IuguException {
        return new PaymentMethodListResponse(get(UriUtils.createURI(String.format(FIND_OR_CREATE_PAYMENT_METHODS, customerId)), new GenericType<List<PaymentMethodResponse>>() {
        }));
    }

    public PaymentMethodResponse addCreditCard(AddCreditCard addCreditCard) throws IuguException {
        PaymentTokenResponse token = new PaymentTokenService(getIugu()).token(CreatePaymentToken
                .builder()
                .accountId(addCreditCard.getAccountId())
                .cardData(addCreditCard.getCardData())
                .payableWith(PayableWith.CREDIT_CARD)
                .test(addCreditCard.getAsTest())
                .build());
        return addPaymentMethod(addCreditCard.getCustomerId(), PaymentMethodCreate
                .builder()
                .paymentAsDefault(addCreditCard.getAsDefault())
                .token(token.getId())
                .description(addCreditCard.getDescription())
                .build());
    }

    public PaymentMethodResponse addPaymentMethod(String customerId, PaymentMethodCreate paymentMethodCreate) throws IuguException {
        return post(UriUtils.createURI(String.format(FIND_OR_CREATE_PAYMENT_METHODS, customerId)), paymentMethodCreate, PaymentMethodResponse.class);
    }

    public PaymentMethodResponse editPaymentMethod(String customerId, String paymentMethodId, PaymentMethodEdit paymentMethodEdit) throws IuguException {
        return put(UriUtils.createURI(String.format(DETAIL_EDIT_DELETE_PAYMENT_METHODS, customerId, paymentMethodId)), paymentMethodEdit, PaymentMethodResponse.class);
    }

    public PaymentMethodResponse detailPaymentMethod(String customerId, String paymentMethodId) throws IuguException {
        return get(UriUtils.createURI(String.format(DETAIL_EDIT_DELETE_PAYMENT_METHODS, customerId, paymentMethodId)), PaymentMethodResponse.class);
    }

    public PaymentMethodResponse removePaymentMethod(String customerId, String paymentMethodId) throws IuguException {
        return delete(UriUtils.createURI(String.format(DETAIL_EDIT_DELETE_PAYMENT_METHODS, customerId, paymentMethodId)), PaymentMethodResponse.class);
    }

}