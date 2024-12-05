package com.iugu.services.withdraw;

import com.iugu.model.withdraw.RequestWithdraw;
import com.iugu.model.withdraw.response.WithdrawResponse;
import com.iugu.model.withdraw.WithdrawFilter;
import com.iugu.model.withdraw.response.WithdrawsResponse;

public interface WithdrawService {

    WithdrawsResponse listWithdraws(WithdrawFilter withdrawFilter);

    WithdrawResponse detailWithdraw(String id);

    WithdrawResponse withdrawRequest(String accountId, RequestWithdraw withdraw);

    WithdrawResponse withdrawRequest(String accountId, String requestTime, String signature, String body);


}
