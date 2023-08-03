package com.iugu.services;

import com.iugu.IuguConfiguration;
import com.iugu.exceptions.IuguException;
import com.iugu.model.*;
import com.iugu.model.account.EarlyPaymentConfig;
import com.iugu.responses.*;
import com.iugu.utils.StringUtils;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Objects;

public class AccountService extends GenericService {

    private final String FIND_URL = IuguConfiguration.url("/accounts/%s");
    private final String FIND_TRANSACTIONS_URL = IuguConfiguration.url("/accounts/financial");
    private final String FIND_INVOICES_URL = IuguConfiguration.url("/accounts/invoices");
    private final String REQUEST_VERIFICATION_URL = IuguConfiguration.url("/accounts/%s/request_verification");
    private final String ACCOUNT_CONFIGURATION_URL = IuguConfiguration.url("/accounts/configuration");
    private final String REQUEST_WITHDRAW_URL = IuguConfiguration.url("/accounts/%s/request_withdraw");
    private final String CHANGE_URL = IuguConfiguration.url("/accounts/%s");
    private final String PAYMENT_CONFIGURATION_URL = IuguConfiguration.url("/payments/pix");

    public AccountService(IuguConfiguration iugu) {
        super(iugu);
    }

    public AccountResponse find(String id) throws IuguException {
        Response response = getTarget(String.format(FIND_URL, id)).request().get();
        return readResponse(response, AccountResponse.class, "Error finding account with id: " + id);
    }

    public TransactionsResponse findTransactions(String year, String month, String day, Integer limit, Integer start) throws IuguException {
        WebTarget target = getTarget(FIND_TRANSACTIONS_URL);

        if (!StringUtils.isNullOrEmpty(year)) target = target.queryParam("year", year);
        if (!StringUtils.isNullOrEmpty(month)) target = target.queryParam("month", month);
        if (!StringUtils.isNullOrEmpty(day)) target = target.queryParam("day", day);
        if (!Objects.isNull(limit)) target = target.queryParam("limit", limit);
        if (!Objects.isNull(start)) target = target.queryParam("start", start);

        return readResponse(target.request().get(), TransactionsResponse.class, "Error finding transactions!");
    }

    public List<ExtractInvoiceResponse> findInvoices(String year, String month, String status, Integer limit) throws IuguException {
        WebTarget target = getTarget(FIND_INVOICES_URL);

        if (!StringUtils.isNullOrEmpty(year)) target = target.queryParam("year", year);
        if (!StringUtils.isNullOrEmpty(month)) target = target.queryParam("month", month);
        if (!StringUtils.isNullOrEmpty(status)) target = target.queryParam("day", status);
        if (!Objects.isNull(limit)) target = target.queryParam("limit", limit);

        return readResponse(target.request().get(), new GenericType<List<ExtractInvoiceResponse>>() {
        }, "Error finding invoices!");
    }

    public AccountVerificationResponse requestVerification(RequestVerification requestVerification) throws IuguException {
        Response response = getTarget(String.format(REQUEST_VERIFICATION_URL, requestVerification.getAccountId())).request().post(Entity.entity(requestVerification, MediaType.APPLICATION_JSON));
        return readResponse(response, AccountVerificationResponse.class, "Error on request verification!");
    }

    public AccountConfigurationResponse configuration(Account account) throws IuguException {
        Response response = getTarget(ACCOUNT_CONFIGURATION_URL).request().post(Entity.entity(account, MediaType.APPLICATION_JSON));
        return readResponse(response, AccountConfigurationResponse.class, "Error configuring account!");
    }


    public AccountConfigurationResponse configuration(EarlyPaymentConfig earlyPaymentConfig) throws IuguException {
        Response response = getTarget(ACCOUNT_CONFIGURATION_URL).request().post(Entity.entity(earlyPaymentConfig, MediaType.APPLICATION_JSON));
        return readResponse(response, AccountConfigurationResponse.class, "Error configuring account!");
    }

    public RequestWithdrawResponse requestWithdraw(RequestWithdraw requestWithdraw, String id) throws IuguException {
        Response response = getTarget(String.format(REQUEST_WITHDRAW_URL, id)).request().post(Entity.entity(requestWithdraw, MediaType.APPLICATION_JSON));
        return readResponse(response, RequestWithdrawResponse.class, "Error on request withdraw!");
    }

    public AccountResponse change(AccountUpdate account) throws IuguException {
        Response response = getTarget(String.format(CHANGE_URL, account.getId())).request().put(Entity.entity(account, MediaType.APPLICATION_JSON));
        return readResponse(response, AccountResponse.class, "Error changing account with id: " + account.getId());
    }

    public Object paymentConfiguration(PaymentConfiguration paymentConfiguration) throws IuguException {
        Response response = getTarget(PAYMENT_CONFIGURATION_URL).request().put(Entity.entity(paymentConfiguration, MediaType.APPLICATION_JSON));
        return readResponse(response, String.class, "Error configuring payment!");
    }

}