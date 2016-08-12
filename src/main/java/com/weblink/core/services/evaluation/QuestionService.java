package com.weblink.core.services.evaluation;


import com.weblink.core.models.Evaluation;
import com.weblink.core.models.ModulePerAction;
import com.weblink.core.models.Question;

import java.util.List;

public interface QuestionService {
    void addQuestion(Question question);
    void removeQuestion(Question question);
    Question getQuestion(int id);
    List<Question> getQuestions(Evaluation evaluation);
    List<Question> getShuffledQuestions(Evaluation eval);
}
