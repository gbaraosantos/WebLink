package com.weblink.core.dao.evaluation;

import com.weblink.core.models.Evaluation;
import com.weblink.core.models.ModulePerAction;
import com.weblink.core.models.Question;

import java.util.List;

/**
 * Created by guilherme on 11-08-2016.
 */
public interface QuestionManagementDao {
    void addQuestion(Question question);
    void removeQuestion(Question question);
    List<Question> getQuestion(int id);
    List<Question> getQuestions(Evaluation evaluation);
}
