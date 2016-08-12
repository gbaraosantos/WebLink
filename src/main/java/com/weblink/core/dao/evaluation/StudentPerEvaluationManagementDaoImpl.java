package com.weblink.core.dao.evaluation;

import com.weblink.core.dao.AbstractDao;
import com.weblink.core.models.*;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("studentPerEvaluationManagementDao")
public class StudentPerEvaluationManagementDaoImpl extends AbstractDao<Integer, StudentPerEvaluation> implements StudentPerEvaluationManagementDao{
    @Override
    public void addStudentPerEvaluation(StudentPerEvaluation studentPerEvaluation) {
        persist(studentPerEvaluation);
    }

    @Override
    public void removeStudentPerEvaluation(StudentPerEvaluation studentPerEvaluation) {
        delete(studentPerEvaluation);
    }

    @Override
    public List<StudentPerEvaluation> getStudentPerEvaluation(int id) {
        Query query = getSession().createQuery("FROM StudentPerEvaluation AS e WHERE  e.id = :id");
        query.setParameter("id", id);
        return (List<StudentPerEvaluation>)query.list();
    }

    @Override
    public List<StudentPerEvaluation> getStudentPerEvaluation(StudentMPA studentMPA) {
        Query query = getSession().createQuery("FROM StudentPerEvaluation AS e WHERE  e.StudentMPA = :smpa");
        query.setParameter("smpa", studentMPA);
        return (List<StudentPerEvaluation>)query.list();
    }

    @Override
    public List<StudentPerEvaluation> getStudentPerEvaluation(StudentMPA smpa, Evaluation evaluation) {
        Query query = getSession().createQuery("FROM StudentPerEvaluation AS e WHERE  e.studentMPA = :smpa AND e.evaluation = :evaluation");
        query.setParameter("smpa", smpa);
        query.setParameter("evaluation", evaluation);
        return (List<StudentPerEvaluation>)query.list();
    }
}
