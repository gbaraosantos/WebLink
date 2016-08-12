package com.weblink.core.dao.evaluation;

import com.weblink.core.models.Evaluation;
import com.weblink.core.models.ModulePerAction;

import java.util.List;


public interface EvaluationManagementDao {
    void addEvaluation(Evaluation evaluation);
    void removeEvaluation(Evaluation evaluation);
    List<Evaluation> getEvaluation(int id);
    List<Evaluation> getEvaluations(ModulePerAction modulePerAction);
    List<Evaluation> getNextClass();
}
