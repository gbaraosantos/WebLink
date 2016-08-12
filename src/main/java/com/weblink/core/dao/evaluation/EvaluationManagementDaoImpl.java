package com.weblink.core.dao.evaluation;

import com.weblink.core.dao.AbstractDao;
import com.weblink.core.dao.user_management_dao.UserManagementDao;
import com.weblink.core.models.Evaluation;
import com.weblink.core.models.ModulePerAction;
import com.weblink.core.models.User;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Repository("evaluationManagementDao")
public class EvaluationManagementDaoImpl  extends AbstractDao<Integer, Evaluation> implements EvaluationManagementDao {
    @Override
    public void addEvaluation(Evaluation evaluation) {
        persist(evaluation);
    }

    @Override
    public void removeEvaluation(Evaluation evaluation) {
        delete(evaluation);
    }

    @Override
    public List<Evaluation> getEvaluation(int id) {
        Query query = getSession().createQuery("FROM Evaluation AS e WHERE e.id = :id");
        query.setParameter("id", id);
        return (List<Evaluation>)query.list();
    }

    @Override
    public List<Evaluation> getEvaluations(ModulePerAction modulePerAction) {
        Query query = getSession().createQuery("FROM Evaluation AS e WHERE e.dueDate >= :now AND e.modulePerAction = :modulePerAction");

        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.DATE, -1);
        Date dateBefore1Days = cal.getTime();

        query.setParameter("now", dateBefore1Days);
        query.setParameter("modulePerAction", modulePerAction);
        return (List<Evaluation>)query.list();
    }

    @Override
    public List<Evaluation> getNextClass() {
        Query query = getSession().createQuery("FROM Evaluation AS e WHERE e.evaluated = false order by e.dueDate DESC");
        return (List<Evaluation>)query.list();
    }
}
