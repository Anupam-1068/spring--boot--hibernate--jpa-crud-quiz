package com.example.crudemo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "questions")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;


    @Column(name = "topic_id")
    private Integer topic_id;

    @Column(name = "difficulty_rank")
    private Integer difficulty_rank;

    @Column(name = "content")
    private String content;

    public Question(){

    }

    public Question(Integer topic_id, Integer difficulty_rank, String content) {
        this.topic_id = topic_id;
        this.difficulty_rank = difficulty_rank;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getTopic_id() {
        return topic_id;
    }

    public void setTopic_id(Integer topic_id) {
        this.topic_id = topic_id;
    }

    public Integer getDifficulty_rank() {
        return difficulty_rank;
    }

    public void setDifficulty_rank(Integer difficulty_rank) {
        this.difficulty_rank = difficulty_rank;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", topic_id=" + topic_id +
                ", difficulty_rank=" + difficulty_rank +
                ", content='" + content + '\'' +
                '}';
    }
}
