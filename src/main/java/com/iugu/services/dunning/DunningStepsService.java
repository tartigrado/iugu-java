package com.iugu.services.dunning;

import com.iugu.model.dunning.ChangeDunningStep;
import com.iugu.model.dunning.DunningStep;

import java.util.List;

public interface DunningStepsService {

    List<DunningStep> getDunningSteps();

    List<DunningStep> changeDunningSteps(ChangeDunningStep change);

}
