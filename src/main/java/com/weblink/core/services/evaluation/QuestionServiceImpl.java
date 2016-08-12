package com.weblink.core.services.evaluation;

import com.weblink.core.dao.evaluation.EvaluationManagementDao;
import com.weblink.core.dao.evaluation.QuestionManagementDao;
import com.weblink.core.models.Evaluation;
import com.weblink.core.models.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Random;

@Transactional
@Service("questionService")
public class QuestionServiceImpl implements QuestionService{

    @Autowired QuestionManagementDao questionManagementDao;

    @Override
    public void addQuestion(Question question) {
        questionManagementDao.addQuestion(question);
    }

    @Override
    public void removeQuestion(Question question) {
        questionManagementDao.removeQuestion(question);
    }

    @Override
    public Question getQuestion(int id) {
        List<Question> list = questionManagementDao.getQuestion(id);
        if(list==null || list.size() <= 0) return null;
        return list.get(0);
    }

    @Override
    public List<Question> getQuestions(Evaluation evaluation) {
        List<Question> list = questionManagementDao.getQuestions(evaluation);
        if(list==null || list.size() <= 0) return null;
        return list;
    }

    @Override
    public List<Question> getShuffledQuestions(Evaluation eval) {
        List<Question> list = questionManagementDao.getQuestions(eval);
        if(list==null || list.size() <= 0) return null;
        Collections.shuffle(list, new Random());
        return list;
    }
}
