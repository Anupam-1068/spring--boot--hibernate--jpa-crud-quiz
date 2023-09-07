package com.example.crudemo.dao;

import com.example.crudemo.entity.Question;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class QuestionDAOImpl implements QuestionDAO {

    private EntityManager entityManager;

    @Autowired
    public QuestionDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    @Transactional
    public void save(Question theQuestion) {
        entityManager.persist(theQuestion);
    }

    @Override
    public Question findById(Integer id) {
        return entityManager.find(Question.class,id);
    }

    @Override
    public List<Question> findAll() {

        TypedQuery<Question> theQuery = entityManager.createQuery(
                "FROM Question", Question.class);
        return theQuery.getResultList();
    }

    @Override
    public List<Question> findByTopic(Integer topic_id) {
        // create query
        TypedQuery<Question> theQuery = entityManager.createQuery(
                "FROM Question WHERE topic_id=:theData", Question.class);

        // set query parameters
        theQuery.setParameter("theData", topic_id);

        // return query results
        return theQuery.getResultList();
    }
    @Override
    @Transactional
    public void update(Question theQuestion) {
        entityManager.merge(theQuestion);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        // retrieve the student
        Question theQuestion = entityManager.find(Question.class, id);

        // delete the student
        entityManager.remove(theQuestion);

    }

    @Override
    @Transactional
    public int deleteAll() {

        int numRowsDeleted = entityManager.createQuery("DELETE FROM Question").executeUpdate();

        return numRowsDeleted;
    }
}
