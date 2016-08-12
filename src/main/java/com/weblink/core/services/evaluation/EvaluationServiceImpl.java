package com.weblink.core.services.evaluation;

import com.weblink.core.dao.evaluation.EvaluationManagementDao;
import com.weblink.core.models.Action;
import com.weblink.core.models.Evaluation;
import com.weblink.core.models.ModulePerAction;
import com.weblink.core.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Transactional
@Service("evaluationService")
public class EvaluationServiceImpl implements EvaluationService{
    @Autowired EvaluationManagementDao evaluationManagementDao;

    @Override
    public void addEvaluation(Evaluation evaluation) {
        evaluationManagementDao.addEvaluation(evaluation);
    }

    @Override
    public void removeEvaluation(Evaluation evaluation) {
        evaluationManagementDao.removeEvaluation(evaluation);
    }

    @Override
    public Evaluation getEvaluation(int id) {
        List<Evaluation> list = evaluationManagementDao.getEvaluation(id);
        if(list==null || list.size() <= 0) return null;
        return list.get(0);
    }

    @Override
    public List<Evaluation> getEvaluations(ModulePerAction modulePerAction) {
        List<Evaluation> list = evaluationManagementDao.getEvaluations(modulePerAction);
        if(list==null || list.size() <= 0) return null;
        return list;
    }

    @Override
    public Date getNextClass() {
        List<Evaluation> list = evaluationManagementDao.getNextClass();
        if(list==null || list.size() <= 0) return null;
        return list.get(0).getDueDate();
    }
}
