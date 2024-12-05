package com.iugu.services.customer;

import com.iugu.Mocks;
import com.iugu.TestConstants;
import com.iugu.model.card.CardData;
import com.iugu.model.customer.*;
import com.iugu.model.customer.response.CustomerPaymentMethodResponse;
import com.iugu.model.customer.response.CustomerResponse;
import com.iugu.model.customer.response.CustomersResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class CustomerCreateServiceImplTest {

    CustomerService service = new CustomerServiceImpl(Mocks.mockConfiguration());

    @Test
    @DisplayName("CustomerService: should list customers")
    void testListCustomers() {
        CustomersResponse response = service.listCustomers(null);
        Assertions.assertNull(response.getAny());
        Assertions.assertNotNull(response.getTotalItems());
        Assertions.assertTrue(response.getTotalItems() > 0);
        for (CustomerResponse item : response.getItems()) {
            Assertions.assertNull(item.getAny());
        }

        Assertions.assertNotNull(response.first());
        Assertions.assertNotNull(response.findById("9C2964F52DE747C384261DC7D236B1EC"));
        Assertions.assertNotNull(response.findByEmail("artur@tartigrado.com"));
        Assertions.assertNotNull(response.findByCpfCnpj("11.520.224/0001-40"));

    }

    @Test
    @DisplayName("CustomerService: should get customer")
    void testGetCustomer() {
        CustomerResponse customer = service.getCustomer("9C2964F52DE747C384261DC7D236B1EC");

        Assertions.assertNotNull(customer);
        Assertions.assertNull(customer.getAny());
    }

    @Test
    @DisplayName("CustomerService: should create customer, edit and delete the customer")
    void testCreateCustomer() {
        CustomerResponse customer = service.createCustomer(CustomerCreate
                .builder()
                .name("Teste")
                .email("teste@teste.com")
                .notes("Teste")
                .cpfCnpj("02382814349")
                .street("Avenida Higino Cunha")
                .district("Ilhotas")
                .city("Teresina")
                .state("Piauí")
                .number("692")
                .customVariables(List.of(
                        CustomerCreate.CustomVariable
                                .builder()
                                .name("test_1")
                                .value("value_1")
                                .build(),
                        CustomerCreate.CustomVariable
                                .builder()
                                .name("test_2")
                                .value("value_2")
                                .build()))
                .build());
        Assertions.assertNotNull(customer);
        Assertions.assertNotNull(customer.getCustomVariables());
        Assertions.assertEquals(2, customer.getCustomVariables().size());
        Assertions.assertNull(customer.getAny());

        CustomerResponse customerUpdated = service.updateCustomer(customer.getId(), CustomerUpdate
                .builder()
                .customVariables(List.of(
                        CustomerUpdate.CustomVariable
                                .builder()
                                .name("test_1")
                                .value("value_1")
                                .destroy(true)
                                .build(),
                        CustomerUpdate.CustomVariable
                                .builder()
                                .name("test_2")
                                .value("value_2")
                                .destroy(true)
                                .build(),
                        CustomerUpdate.CustomVariable
                                .builder()
                                .name("test_3")
                                .value("value_3")
                                .build()))
                .build());

        Assertions.assertNotNull(customerUpdated);
        Assertions.assertNotNull(customerUpdated.getCustomVariables());
        Assertions.assertEquals(1, customerUpdated.getCustomVariables().size());
        Assertions.assertNull(customerUpdated.getAny());

        CustomerResponse customerDeleted = service.deleteCustomer(customer.getId());
        Assertions.assertNotNull(customerDeleted);
    }

    @Test
    @DisplayName("CustomerService: should list payment methods")
    void testListPaymentMethods() {
        List<CustomerPaymentMethodResponse> paymentMethods = service.listPaymentMethods("9C2964F52DE747C384261DC7D236B1EC");
        Assertions.assertNotNull(paymentMethods);
        Assertions.assertFalse(paymentMethods.isEmpty());
    }

    @Test
    @DisplayName("CustomerService: should create, update and delete a payment method")
    void testCreatePaymentMethod() {
        CustomersResponse response = service.listCustomers(null);
        String customerId = response.first().getId();
        CustomerPaymentMethodResponse paymentMethod = service.createPaymentMethod(customerId, CustomerPaymentMethodCardCreate.builder()
                .description("Cartão de teste")
                .asDefault(true)
                .test(true)
                .cardData(CardData
                        .builder()
                        .number("5555555555554444")
                        .verificationValue("123")
                        .firstName("TESTE")
                        .lastName("TESTE")
                        .month("12")
                        .year("2035")
                        .build())
                .build());
        Assertions.assertNotNull(paymentMethod);
        Assertions.assertEquals("Cartão de teste", paymentMethod.getDescription());
        Assertions.assertTrue(paymentMethod.getTest());
        Assertions.assertNull(paymentMethod.getAny());
        Assertions.assertNotNull(paymentMethod.getData());
        Assertions.assertNull(paymentMethod.getData().getAny());

        CustomerPaymentMethodResponse paymentMethodUpdated = service.updatePaymentMethod(customerId, paymentMethod.getId(), CustomerPaymentMethodUpdate
                .builder()
                .description("Cartão de teste editado")
                .build());

        Assertions.assertNotNull(paymentMethodUpdated);
        Assertions.assertEquals("Cartão de teste editado", paymentMethodUpdated.getDescription());

        CustomerPaymentMethodResponse paymentMethodDeleted = service.deletePaymentMethod(customerId, paymentMethod.getId());
        Assertions.assertNotNull(paymentMethodDeleted);
    }

    @Test
    @DisplayName("CustomerService: should add credit card")
    void testAddCreditCard() {
        CustomersResponse response = service.listCustomers(null);
        String customerId = response.first().getId();
        CustomerPaymentMethodResponse paymentMethod = service.addCreditCard(AddCreditCard.builder()
                .description("Cartão de teste")
                .asDefault(true)
                .asTest(true)
                .accountId(TestConstants.ACCOUNT_ID)

                .customerId(customerId)
                .cardData(CardData
                        .builder()
                        .number("5555555555554444")
                        .verificationValue("123")
                        .firstName("TESTE")
                        .lastName("TESTE")
                        .month("12")
                        .year("2035")
                        .build())
                .build());
        Assertions.assertNotNull(paymentMethod);
        Assertions.assertEquals("Cartão de teste", paymentMethod.getDescription());
        Assertions.assertNull(paymentMethod.getAny());
        Assertions.assertNotNull(paymentMethod.getData());
        Assertions.assertNull(paymentMethod.getData().getAny());
    }

}