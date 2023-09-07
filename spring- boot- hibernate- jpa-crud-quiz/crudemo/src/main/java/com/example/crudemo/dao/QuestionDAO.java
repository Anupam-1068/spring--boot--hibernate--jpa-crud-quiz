package com.example.crudemo.dao;

import com.example.crudemo.entity.Question;

import java.util.List;

public interface QuestionDAO {

    void save(Question theQuestion);

    Question findById(Integer id);

    List<Question> findAll();

    List<Question> findByTopic(Integer Topic_id);
    void update(Question theQuestion);

    void delete(Integer id);

    int deleteAll();

}
