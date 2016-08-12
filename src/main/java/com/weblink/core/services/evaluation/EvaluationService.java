package com.weblink.core.services.evaluation;


import com.weblink.core.models.Evaluation;
import com.weblink.core.models.ModulePerAction;

import java.util.Date;
import java.util.List;

public interface EvaluationService {
    void addEvaluation(Evaluation evaluation);
    void removeEvaluation(Evaluation evaluation);
    Evaluation getEvaluation(int id);
    List<Evaluation> getEvaluations(ModulePerAction  modulePerAction);
    Date getNextClass();
}
