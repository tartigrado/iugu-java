package com.iugu.services.customer;

import com.iugu.model.customer.*;
import com.iugu.model.customer.response.CustomerPaymentMethodResponse;
import com.iugu.model.customer.response.CustomerResponse;
import com.iugu.model.customer.response.CustomersResponse;

import java.util.List;

public interface CustomerService {

    CustomersResponse listCustomers(CustomerFilter filter);

    CustomerResponse getCustomer(String id);

    CustomerResponse createCustomer(CustomerCreate customer);

    CustomerResponse updateCustomer(String id, CustomerUpdate customer);

    CustomerResponse deleteCustomer(String id);

    List<CustomerPaymentMethodResponse> listPaymentMethods(String customerId);

    CustomerPaymentMethodResponse getPaymentMethod(String customerId, String paymentMethodId);

    CustomerPaymentMethodResponse addCreditCard(AddCreditCard addCreditCard);

    CustomerPaymentMethodResponse createPaymentMethod(String customerId, CustomerPaymentMethodTokenCreate addCreditCard);

    CustomerPaymentMethodResponse createPaymentMethod(String customerId, CustomerPaymentMethodCardCreate customerPaymentMethodCardCreate);

    CustomerPaymentMethodResponse updatePaymentMethod(String customerId, String paymentMethodId, CustomerPaymentMethodUpdate paymentMethod);

    CustomerPaymentMethodResponse deletePaymentMethod(String customerId, String paymentMethodId);
}
