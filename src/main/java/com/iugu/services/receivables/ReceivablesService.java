package com.iugu.services.receivables;

import com.iugu.model.receivables.AnticipationSimulation;
import com.iugu.model.receivables.ReceivablesFilter;
import com.iugu.model.receivables.TransactionAdvance;
import com.iugu.model.receivables.response.AnticipationSimulationResponse;
import com.iugu.model.receivables.response.CheckAdvanceResponse;
import com.iugu.model.receivables.response.ReceivablesResponse;
import com.iugu.model.receivables.response.TransactionAdvanceResponse;

public interface ReceivablesService {

    ReceivablesResponse listReceivables(ReceivablesFilter filter);

    void createAnticipationSimulation(AnticipationSimulation simulation);

    AnticipationSimulationResponse checkAnticipationSimulation();

    TransactionAdvanceResponse transactionAdvance(TransactionAdvance advance);

    void approveAdvance();

    CheckAdvanceResponse checkAdvanceResponse();

}
