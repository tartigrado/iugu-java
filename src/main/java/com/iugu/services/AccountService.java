package com.iugu.services;

import com.iugu.IuguConfiguration;
import jakarta.ws.rs.client.Client;
import com.iugu.exceptions.IuguException;
import com.iugu.model.*;
import com.iugu.model.account.EarlyPaymentConfig;
import com.iugu.responses.*;
import com.iugu.services.generic.GenericRsaService;
import com.iugu.utils.StringUtils;

import jakarta.ws.rs.HttpMethod;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;
import java.util.Objects;

public class AccountService extends GenericRsaService {

    private final String FIND_URL = IuguConfiguration.url("/accounts/%s");
    private final String FIND_TRANSACTIONS_URL = IuguConfiguration.url("/accounts/financial");
    private final String FIND_INVOICES_URL = IuguConfiguration.url("/accounts/invoices");
    private final String REQUEST_VERIFICATION_URL = IuguConfiguration.url("/accounts/%s/request_verification");
    private final static String ACCOUNT_CONFIGURATION_URL = "/accounts/configuration";
    private final static String REQUEST_WITHDRAW_URL = "/accounts/%s/request_withdraw";
    private final String CHANGE_URL = IuguConfiguration.url("/accounts/%s");
    private final String PAYMENT_CONFIGURATION_URL = IuguConfiguration.url("/payments/pix");

    public AccountService(IuguConfiguration iugu) {
        super(iugu, new ValidateSignatureService(iugu));
    }

    public AccountResponse find(String id) throws IuguException {
        try (Client client = getIugu().getNewClient()) {
            Response response = client.target(String.format(FIND_URL, id)).request().get();
            return readResponse(response, AccountResponse.class, "Error finding account with id: " + id);
        }
    }

    public TransactionsResponse findTransactions(String year, String month, String day, Integer limit, Integer start) throws IuguException {
        try (Client client = getIugu().getNewClient()) {
            WebTarget target = client.target(FIND_TRANSACTIONS_URL);

            if (!StringUtils.isNullOrEmpty(year)) target = target.queryParam("year", year);
            if (!StringUtils.isNullOrEmpty(month)) target = target.queryParam("month", month);
            if (!StringUtils.isNullOrEmpty(day)) target = target.queryParam("day", day);
            if (!Objects.isNull(limit)) target = target.queryParam("limit", limit);
            if (!Objects.isNull(start)) target = target.queryParam("start", start);

            return readResponse(target.request().get(), TransactionsResponse.class, "Error finding transactions!");
        }
    }

    public List<ExtractInvoiceResponse> findInvoices(String year, String month, String status, Integer limit) throws IuguException {
        try (Client client = getIugu().getNewClient()) {
            WebTarget target = client.target(FIND_INVOICES_URL);

            if (!StringUtils.isNullOrEmpty(year)) target = target.queryParam("year", year);
            if (!StringUtils.isNullOrEmpty(month)) target = target.queryParam("month", month);
            if (!StringUtils.isNullOrEmpty(status)) target = target.queryParam("day", status);
            if (!Objects.isNull(limit)) target = target.queryParam("limit", limit);

            return readResponse(target.request().get(), new GenericType<List<ExtractInvoiceResponse>>() {
            }, "Error finding invoices!");
        }
    }

    public AccountVerificationResponse requestVerification(RequestVerification requestVerification) throws IuguException {
        try (Client client = getIugu().getNewClient()) {
            Response response = client.target(String.format(REQUEST_VERIFICATION_URL, requestVerification.getAccountId())).request().post(Entity.entity(requestVerification, MediaType.APPLICATION_JSON));
            return readResponse(response, AccountVerificationResponse.class, "Error on request verification!");
        }
    }

    public AccountConfigurationResponse configuration(Account account) throws IuguException {
        account = getIugu().withToken(account);
        return requestWithSignature(HttpMethod.POST, ACCOUNT_CONFIGURATION_URL, account, AccountConfigurationResponse.class);
    }


    public AccountConfigurationResponse configuration(EarlyPaymentConfig earlyPaymentConfig) throws IuguException {
        earlyPaymentConfig = getIugu().withToken(earlyPaymentConfig);
        return requestWithSignature(HttpMethod.POST, ACCOUNT_CONFIGURATION_URL, earlyPaymentConfig, AccountConfigurationResponse.class);
    }

    public RequestWithdrawResponse requestWithdraw(RequestWithdraw requestWithdraw, String accountId) throws IuguException {
        requestWithdraw = getIugu().withToken(requestWithdraw);
        String urlWithId = String.format(REQUEST_WITHDRAW_URL, accountId);
        return requestWithSignature(HttpMethod.POST, urlWithId, requestWithdraw, RequestWithdrawResponse.class);
    }

    public AccountResponse change(AccountUpdate account) throws IuguException {
        try (Client client = getIugu().getNewClient()) {
            Response response = client.target(String.format(CHANGE_URL, account.getId())).request().put(Entity.entity(account, MediaType.APPLICATION_JSON));
            return readResponse(response, AccountResponse.class, "Error changing account with id: " + account.getId());
        }
    }

    public Object paymentConfiguration(PaymentConfiguration paymentConfiguration) throws IuguException {
        try (Client client = getIugu().getNewClient()) {
            Response response = client.target(PAYMENT_CONFIGURATION_URL).request().put(Entity.entity(paymentConfiguration, MediaType.APPLICATION_JSON));
            return readResponse(response, String.class, "Error configuring payment!");
        }
    }
}