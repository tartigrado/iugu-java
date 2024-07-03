package com.iugu.services;

import com.iugu.Mocks;
import com.iugu.TestConstants;
import com.iugu.model.Transfer;
import com.iugu.responses.TransferResponse;
import org.junit.Assert;
import org.junit.Test;

import java.util.Objects;

import static org.junit.Assert.*;

public class TransferServiceTest {

    @Test
    public void testTransfer() {
        TransferService transferService = new TransferService(Mocks.mockConfiguration());

        try {
            transferService.transfer(Transfer.builder().amountCents(1).receiverId(TestConstants.ACCOUNT_ID).build());
        } catch (Exception ex) {
            Assert.assertTrue(
                    Objects.equals("{\"message\":{\"amount_cents\":[\"Saldo insuficiente\"],\"receiver_account\":[\"Não é possível transferir para si mesmo\"]}}", ex.getMessage()) ||
                    Objects.equals("{\"message\":{\"amount_cents\":[\"Insufficient Balance\"],\"receiver_account\":[\"Can't transfer to yourself\"]}}", ex.getMessage())
            );
        }
    }
}