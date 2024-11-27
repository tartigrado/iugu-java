package com.iugu.services.receivables;

import com.iugu.Mocks;
import com.iugu.exceptions.IuguException;
import com.iugu.model.receivables.ReceivablesFilter;
import com.iugu.model.receivables.TransactionAdvance;
import com.iugu.model.receivables.response.ReceivablesResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class ReceivablesServiceImplTest {

    ReceivablesService service = new ReceivablesServiceImpl(Mocks.mockProdConfiguration());

    @Test
    @DisplayName("ReceivablesService: Should return empty list response")
    void testListReceivables() {
        ReceivablesResponse response = Assertions.assertDoesNotThrow(() -> service.listReceivables(ReceivablesFilter
                .builder()
                .limit(10)
                .start(0)
                .sinceYear(2020)
                .build()));
        Assertions.assertEquals(0, response.getTotalItems());
        Assertions.assertNotNull(response.getItems());
    }

    @Test
    @DisplayName("ReceivablesService: Should throws exception when advancing transactions")
    void testCreateAnticipationSimulation() {
        IuguException ex = Assertions.assertThrows(IuguException.class, () -> service.transactionAdvance(TransactionAdvance
                .builder()
                .transactions(List.of("UNIT_TEST_TRANSACTION_ID"))
                .build()));
        Assertions.assertEquals("Transações Não existem parcelas disponíveis para antecipação", ex.getMessage());
    }

    @Test
    @DisplayName("ReceivablesService: Should throws exception when checking and it doesnt have a current simulation")
    void testCheckAnticipationSimulation() {
        IuguException ex = Assertions.assertThrows(IuguException.class, () -> service.checkAnticipationSimulation());
        Assertions.assertEquals("Não encontrado", ex.getMessage());
    }

    @Test
    @DisplayName("ReceivablesService: Should throws exception when approving advance and it does not have an simulation")
    void testApproveAdvance() {
        IuguException ex = Assertions.assertThrows(IuguException.class, () -> service.approveAdvance());
        Assertions.assertEquals("Não foi possível executar a antecipação. Por favor, faça a simulação novamente.", ex.getMessage());
    }

    @Test
    @DisplayName("ReceivablesService: Should throws exception when checking advance response and it does not have an simulation")
    void testCheckAdvanceResponse() {
        IuguException ex = Assertions.assertThrows(IuguException.class, () -> service.checkAdvanceResponse());
        Assertions.assertEquals("Não encontrado", ex.getMessage());
    }
}