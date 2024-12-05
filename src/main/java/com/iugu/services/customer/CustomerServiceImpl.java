package com.iugu.services.customer;

import com.iugu.IuguConfiguration;
import com.iugu.components.HttpClientManager;
import com.iugu.enums.PayableWith;
import com.iugu.exceptions.IuguExceptionHandler;
import com.iugu.model.customer.*;
import com.iugu.model.customer.response.CustomerPaymentMethodResponse;
import com.iugu.model.customer.response.CustomerResponse;
import com.iugu.model.customer.response.CustomersResponse;
import com.iugu.model.token.PaymentTokenCreate;
import com.iugu.model.token.response.PaymentTokenResponse;
import com.iugu.services.token.PaymentTokenService;
import com.iugu.services.token.PaymentTokenServiceImpl;
import jakarta.ws.rs.WebApplicationException;

import java.util.List;

public final class CustomerServiceImpl implements CustomerService {
    private final CustomerService proxy;
    private final PaymentTokenService paymentTokenService = new PaymentTokenServiceImpl();

    public CustomerServiceImpl(IuguConfiguration configuration) {
        this.proxy = HttpClientManager.proxy(CustomerServiceProxy.class, configuration.authenticator());
    }

    @Override
    public CustomersResponse listCustomers(CustomerFilter filter) {
        try {
            return proxy.listCustomers(filter);
        } catch (WebApplicationException e) {
            throw IuguExceptionHandler.getException(e);
        }
    }

    @Override
    public CustomerResponse getCustomer(String id) {
        try {
            return proxy.getCustomer(id);
        } catch (WebApplicationException e) {
            throw IuguExceptionHandler.getException(e);
        }
    }

    @Override
    public CustomerResponse createCustomer(CustomerCreate customer) {
        try {
            return proxy.createCustomer(customer);
        } catch (WebApplicationException e) {
            throw IuguExceptionHandler.getException(e);
        }
    }

    @Override
    public CustomerResponse updateCustomer(String id, CustomerUpdate customer) {
        try {
            return proxy.updateCustomer(id, customer);
        } catch (WebApplicationException e) {
            throw IuguExceptionHandler.getException(e);
        }
    }

    @Override
    public CustomerResponse deleteCustomer(String id) {
        try {
            return proxy.deleteCustomer(id);
        } catch (WebApplicationException e) {
            throw IuguExceptionHandler.getException(e);
        }
    }

    @Override
    public List<CustomerPaymentMethodResponse> listPaymentMethods(String customerId) {
        try {
            return proxy.listPaymentMethods(customerId);
        } catch (WebApplicationException e) {
            throw IuguExceptionHandler.getException(e);
        }
    }

    @Override
    public CustomerPaymentMethodResponse getPaymentMethod(String customerId, String paymentMethodId) {
        try {
            return proxy.getPaymentMethod(customerId, paymentMethodId);
        } catch (WebApplicationException e) {
            throw IuguExceptionHandler.getException(e);
        }
    }

    @Override
    public CustomerPaymentMethodResponse addCreditCard(AddCreditCard addCreditCard) {
        try {
            PaymentTokenResponse token = this.paymentTokenService.createToken(PaymentTokenCreate
                    .builder()
                    .accountId(addCreditCard.getAccountId())
                    .cardData(addCreditCard.getCardData())
                    .payableWith(PayableWith.CREDIT_CARD)
                    .test(addCreditCard.getAsTest())
                    .build());
            return createPaymentMethod(addCreditCard.getCustomerId(), CustomerPaymentMethodTokenCreate
                    .builder()
                    .paymentAsDefault(addCreditCard.getAsDefault())
                    .token(token.getId())
                    .description(addCreditCard.getDescription())
                    .build());
        } catch (WebApplicationException ex) {
            throw IuguExceptionHandler.getException(ex);
        }
    }

    @Override
    public CustomerPaymentMethodResponse createPaymentMethod(String customerId, CustomerPaymentMethodTokenCreate paymentMethod) {
        try {
            return proxy.createPaymentMethod(customerId, paymentMethod);
        } catch (WebApplicationException e) {
            throw IuguExceptionHandler.getException(e);
        }
    }

    @Override
    public CustomerPaymentMethodResponse createPaymentMethod(String customerId, CustomerPaymentMethodCardCreate customerPaymentMethodCardCreate) {
        try {
            return proxy.createPaymentMethod(customerId, customerPaymentMethodCardCreate);
        } catch (WebApplicationException e) {
            throw IuguExceptionHandler.getException(e);
        }
    }

    @Override
    public CustomerPaymentMethodResponse updatePaymentMethod(String customerId, String paymentMethodId, CustomerPaymentMethodUpdate paymentMethod) {
        try {
            return proxy.updatePaymentMethod(customerId, paymentMethodId, paymentMethod);
        } catch (WebApplicationException e) {
            throw IuguExceptionHandler.getException(e);
        }
    }

    @Override
    public CustomerPaymentMethodResponse deletePaymentMethod(String customerId, String paymentMethodId) {
        try {
            return proxy.deletePaymentMethod(customerId, paymentMethodId);
        } catch (WebApplicationException e) {
            throw IuguExceptionHandler.getException(e);
        }
    }
}
