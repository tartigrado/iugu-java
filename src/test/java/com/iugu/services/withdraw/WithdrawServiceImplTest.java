package com.iugu.services.withdraw;

import com.iugu.Mocks;
import com.iugu.TestConstants;
import com.iugu.exceptions.IuguException;
import com.iugu.model.withdraw.RequestWithdraw;
import com.iugu.model.withdraw.response.WithdrawResponse;
import com.iugu.model.withdraw.response.WithdrawsResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

class WithdrawServiceImplTest {

    WithdrawService service = new WithdrawServiceImpl(Mocks.mockProdConfiguration());

    @Test
    @DisplayName("WithdrawService: Should list withdraws")
    void testListWithdraws() {
        WithdrawsResponse listResponse = service.listWithdraws(null);
        Assertions.assertNotNull(listResponse);
        Assertions.assertNotNull(listResponse.getItems());
        Assertions.assertFalse(listResponse.getItems().isEmpty());

        listResponse.getItems().forEach(it -> Assertions.assertNull(it.getAny()));
    }

    @Test
    @DisplayName("WithdrawService: Should detail withdraw")
    void testDetailWithdraw() {
        WithdrawResponse detailWithdraw = service.detailWithdraw("FE84A98F0F154939985ED6E733749247");
        Assertions.assertNotNull(detailWithdraw);
        Assertions.assertNull(detailWithdraw.getAny());
    }

    @Test
    @DisplayName("WithdrawService: Should request withdraw")
    void testWithdrawRequest() {
        IuguException ex = Assertions.assertThrows(IuguException.class, () -> service.withdrawRequest(TestConstants.ACCOUNT_ID, RequestWithdraw
                .builder()
                .amount(BigDecimal.ZERO)
                .build()));
        List<String> possibleMessages = List.of(
                "Valor [deve ser maior ou igual a 5]",
                "Valor [deve ser maior que ou igual a 5]"
        );
        Assertions.assertTrue(possibleMessages.stream().anyMatch(it -> ex.getMessage().contains(it)));
    }

}