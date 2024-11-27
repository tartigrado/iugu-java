package com.iugu.services;

import com.iugu.Mocks;
import com.iugu.TestConstants;
import com.iugu.exceptions.IuguException;
import com.iugu.model.Transfer;
import com.iugu.responses.TransferResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

public class TransferServiceTest {

    @Test
    public void testTransfer() {
        TransferService transferService = new TransferService(Mocks.mockProdConfiguration());

        try {
            transferService.transfer(Transfer.builder().amountCents(1).receiverId(TestConstants.ACCOUNT_ID).build());
        } catch (IuguException ex) {
            Assertions.assertEquals("{\"message\":{\"amount_cents\":[\"Saldo insuficiente\"],\"receiver_account\":[\"Não é possível transferir para si mesmo\"]}}", ex.getMessage());
        }
    }
}