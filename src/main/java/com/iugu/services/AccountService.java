package com.iugu.services;

import com.iugu.IuguConfiguration;
import com.iugu.exceptions.IuguException;
import com.iugu.model.*;
import com.iugu.responses.*;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class AccountService {

    private IuguConfiguration iugu;
    private final String FIND_URL = IuguConfiguration.url("/accounts/%s");
    private final String FIND_TRANSACTIONS_URL = IuguConfiguration.url("/accounts/financial");
    private final String FIND_INVOICES_URL = IuguConfiguration.url("/accounts/invoices");
    private final String REQUEST_VERIFICATION_URL = IuguConfiguration.url("/accounts/%s/request_verification");
    private final String ACCOUNT_CONFIGURATION_URL = IuguConfiguration.url("/accounts/configuration");
    private final String REQUEST_WITHDRAW_URL = IuguConfiguration.url("/accounts/%s/request_withdraw");
    private final String CHANGE_URL = IuguConfiguration.url("/accounts/%s");
    private final String PAYMENT_CONFIGURATION_URL = IuguConfiguration.url("/payments/pix");

    public AccountService(IuguConfiguration iuguConfiguration) {
        this.iugu = iuguConfiguration;
    }

    public AccountResponse find(String id) throws IuguException {
        Response response = this.iugu.getNewClient().target(String.format(FIND_URL, id)).request().get();
        int ResponseStatus = response.getStatus();
        String ResponseText = null;
        if (ResponseStatus == 200) {
            return response.readEntity(AccountResponse.class);
        }
        // Error Happened
        if (response.hasEntity()) {
            ResponseText = response.readEntity(String.class);
        }
        response.close();
        throw new IuguException("Error finding account with id: " + id, ResponseStatus, ResponseText);
    }

    public TransactionsResponse findTransactions(String year, String month, String day, Integer limit, Integer start) throws IuguException {
        String end_point = "";
        if(year != null && !Objects.equals(year, "")){
            end_point += "?year="+year;
            if(month != null && !Objects.equals(month, "")){
                end_point += "&month="+month;
                if(day != null && !Objects.equals(day, "")){
                    end_point += "&day="+day;
                }
            }
        }
        if(limit != null){
            if(Objects.equals(end_point, "")){
                end_point += "?limit="+limit;
            }else{
                end_point += "&limit="+limit;
            }
        }
        if(start != null){
            if(Objects.equals(end_point, "")){
                end_point += "?start="+start;
            }else{
                end_point += "&start="+start;
            }
        }
        end_point = FIND_TRANSACTIONS_URL + end_point;
        Response response = this.iugu.getNewClient().target(end_point).request().get();

        int ResponseStatus = response.getStatus();
        String ResponseText = null;

        if (ResponseStatus == 200)
            return response.readEntity(TransactionsResponse.class);

        // Error Happened
        if (response.hasEntity())
            ResponseText = response.readEntity(String.class);

        response.close();

        throw new IuguException("Error finding transactions! ", ResponseStatus, ResponseText);
    }

    public List<ExtractInvoiceResponse> findInvoices(String year, String month, String status, Integer limit) throws IuguException {
        String end_point = "";
        if(year != null && !Objects.equals(year, "")){
            end_point += "?year="+year;
            if(month != null && !Objects.equals(month, "")){
                end_point += "&month="+month;
            }
        }
        if(status != null && !Objects.equals(status, "")){
            if(Objects.equals(end_point, "")){
                end_point += "?status="+status;
            }else{
                end_point += "&status="+status;
            }
        }
        if(limit != null){
            if(Objects.equals(end_point, "")){
                end_point += "?limit="+limit;
            }else{
                end_point += "&limit="+limit;
            }
        }
        end_point = FIND_INVOICES_URL + end_point;
        Response response = this.iugu.getNewClient().target(end_point).request().get();

        int ResponseStatus = response.getStatus();
        String ResponseText = null;

        if (ResponseStatus == 200)
            return response.readEntity(new GenericType<List<ExtractInvoiceResponse>>(){});

        // Error Happened
        if (response.hasEntity())
            ResponseText = response.readEntity(String.class);

        response.close();

        throw new IuguException("Error finding invoices! ", ResponseStatus, ResponseText);
    }

    public AccountVerificationResponse requestVerification(RequestVerification requestVerification) throws IuguException {
        Response response = this.iugu.getNewClient().target(String.format(REQUEST_VERIFICATION_URL, requestVerification.getAccountId())).request().post(Entity.entity(requestVerification, MediaType.APPLICATION_JSON));
        int ResponseStatus = response.getStatus();
        String ResponseText = null;

        if (ResponseStatus == 200)
            return response.readEntity(AccountVerificationResponse.class);

        // Error Happened
        if (response.hasEntity())
            ResponseText = response.readEntity(String.class);

        response.close();

        throw new IuguException("Error on request verification!", ResponseStatus, ResponseText);
    }

    public AccountConfigurationResponse configuration(Account account) throws IuguException {
        Response response = this.iugu.getNewClient().target(ACCOUNT_CONFIGURATION_URL).request().post(Entity.entity(account, MediaType.APPLICATION_JSON));
        int ResponseStatus = response.getStatus();
        String ResponseText = null;

        if (ResponseStatus == 200)
            return response.readEntity(AccountConfigurationResponse.class);

        // Error Happened
        if (response.hasEntity())
            ResponseText = response.readEntity(String.class);

        response.close();

        throw new IuguException("Error configuring account!", ResponseStatus, ResponseText);
    }

    public RequestWithdrawResponse requestWithdraw(RequestWithdraw requestWithdraw, String id) throws IuguException {
        Response response = this.iugu.getNewClient().target(String.format(REQUEST_WITHDRAW_URL, id)).request().post(Entity.entity(requestWithdraw, MediaType.APPLICATION_JSON));
        int ResponseStatus = response.getStatus();
        String ResponseText = null;

        if (ResponseStatus == 200)
            return response.readEntity(RequestWithdrawResponse.class);

        // Error Happened
        if (response.hasEntity())
            ResponseText = response.readEntity(String.class);

        response.close();

        throw new IuguException("Error on request withdraw!", ResponseStatus, ResponseText);
    }

    public AccountResponse change(AccountUpdate account) throws IuguException {
        Response response = this.iugu.getNewClient().target(String.format(CHANGE_URL, account.getId())).request().put(Entity.entity(account, MediaType.APPLICATION_JSON));

        int ResponseStatus = response.getStatus();
        String ResponseText = null;

        if (ResponseStatus == 200)
            return response.readEntity(AccountResponse.class);

        // Error Happened
        if (response.hasEntity())
            ResponseText = response.readEntity(String.class);

        response.close();

        throw new IuguException("Error changing account with id: " + account.getId(), ResponseStatus, ResponseText);
    }

    public Object paymentConfiguration(PaymentConfiguration paymentConfiguration) throws IuguException {
        Response response = this.iugu.getNewClient().target(PAYMENT_CONFIGURATION_URL).request().put(Entity.entity(paymentConfiguration, MediaType.APPLICATION_JSON));

        int ResponseStatus = response.getStatus();
        String ResponseText = null;

        if (ResponseStatus == 200)
            return null;

        // Error Happened
        if (response.hasEntity())
            ResponseText = response.readEntity(String.class);

        response.close();
        throw new IuguException("Error configuring payment!", ResponseStatus, ResponseText);
    }

}