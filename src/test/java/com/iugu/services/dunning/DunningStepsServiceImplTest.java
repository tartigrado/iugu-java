package com.iugu.services.dunning;

import com.iugu.Mocks;
import com.iugu.exceptions.IuguException;
import com.iugu.model.dunning.ChangeDunningStep;
import com.iugu.model.dunning.DunningStep;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class DunningStepsServiceImplTest {
    DunningStepsService service = new DunningStepsServiceImpl(Mocks.mockProdConfiguration());

    @Test
    @DisplayName("DunningStepsService: Should list dunning steps")
    void testGetDunningSteps() {
        List<DunningStep> stepList = service.getDunningSteps();
        assertNotNull(stepList);
        Assertions.assertFalse(stepList.isEmpty());
    }

    @Test
    @DisplayName("DunningStepsService: Should throws exception dunning steps")
    void testChangeDunningStepsThrowingException() {
        IuguException ex = Assertions.assertThrows(IuguException.class, () -> service.changeDunningSteps(null));
        Assertions.assertEquals("Passos são obrigatórios", ex.getMessage());
    }

    @Test
    @DisplayName("DunningStepsService: Should change dunning steps")
    void testChangeDunningSteps() {
        List<DunningStep> stepList = service.changeDunningSteps(ChangeDunningStep.builder().steps(List.of(DunningStep
                .builder()
                .action("expire")
                .day(10)
                .build())).build());
        Assertions.assertNotNull(stepList);
        Assertions.assertEquals(1, stepList.size());
    }

}