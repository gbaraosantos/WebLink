package com.weblink.core.dao.evaluation;

import com.weblink.core.dao.AbstractDao;
import com.weblink.core.models.Evaluation;
import com.weblink.core.models.Question;
import com.weblink.core.services.evaluation.QuestionService;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository("questionManagementDao")
public class QuestionManagementDaoImpl extends AbstractDao<Integer, Question> implements QuestionManagementDao{
    @Override
    public void addQuestion(Question question) {
        persist(question);
    }

    @Override
    public void removeQuestion(Question question) {
        delete(question);
    }

    @Override
    public List<Question> getQuestion(int id) {
        Query query = getSession().createQuery("FROM Question AS e WHERE  e.id = :id");
        query.setParameter("id", id);
        return (List<Question>)query.list();
    }

    @Override
    public List<Question> getQuestions(Evaluation evaluation) {
        Query query = getSession().createQuery("FROM Question AS e WHERE  e.evaluation = :eval");
        query.setParameter("eval", evaluation);
        return (List<Question>)query.list();
    }
}
