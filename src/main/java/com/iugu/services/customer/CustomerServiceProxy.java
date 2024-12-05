package com.iugu.services.customer;

import com.iugu.model.customer.*;
import com.iugu.model.customer.response.CustomerPaymentMethodResponse;
import com.iugu.model.customer.response.CustomerResponse;
import com.iugu.model.customer.response.CustomersResponse;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("")
public interface CustomerServiceProxy extends CustomerService {

    @Override
    @GET
    @Path("/customers")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    CustomersResponse listCustomers(@BeanParam CustomerFilter filter);

    @Override
    @GET
    @Path("/customers/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    CustomerResponse getCustomer(@PathParam("id") String id);

    @Override
    @POST
    @Path("/customers")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    CustomerResponse createCustomer(CustomerCreate customer);

    @Override
    @PUT
    @Path("/customers/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    CustomerResponse updateCustomer(@PathParam("id") String id, CustomerUpdate customer);


    @Override
    @DELETE
    @Path("/customers/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    CustomerResponse deleteCustomer(@PathParam("id") String id);

    @Override
    @GET
    @Path("/customers/{customerId}/payment_methods")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    List<CustomerPaymentMethodResponse> listPaymentMethods(@PathParam("customerId") String customerId);

    @Override
    @GET
    @Path("/customers/{customerId}/payment_methods/{paymentMethodId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    CustomerPaymentMethodResponse getPaymentMethod(@PathParam("customerId") String customerId, @PathParam("paymentMethodId") String paymentMethodId);

    @Override
    @POST
    @Path("/customers/{customerId}/payment_methods")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    CustomerPaymentMethodResponse createPaymentMethod(@PathParam("customerId") String customerId, CustomerPaymentMethodTokenCreate paymentMethod);

    @Override
    @POST
    @Path("/customers/{customerId}/payment_methods")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    CustomerPaymentMethodResponse createPaymentMethod(@PathParam("customerId") String customerId, CustomerPaymentMethodCardCreate paymentMethod);

    @Override
    @PUT
    @Path("/customers/{customerId}/payment_methods/{paymentMethodId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    CustomerPaymentMethodResponse updatePaymentMethod(@PathParam("customerId") String customerId, @PathParam("paymentMethodId") String paymentMethodId, CustomerPaymentMethodUpdate paymentMethod);

    @Override
    @DELETE
    @Path("/customers/{customerId}/payment_methods/{paymentMethodId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    CustomerPaymentMethodResponse deletePaymentMethod(@PathParam("customerId") String customerId, @PathParam("paymentMethodId") String paymentMethodId);
}
