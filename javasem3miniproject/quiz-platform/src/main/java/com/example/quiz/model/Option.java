package com.example.quiz.model;


import jakarta.persistence.*;


@Entity
@Table(name = "quiz_option")
public class Option {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;


private String text;
private boolean correct;


@ManyToOne
private Question question;


public Option() {}
public Option(String text, boolean correct) {
this.text = text;
this.correct = correct;
}


public Long getId() { return id; }
public String getText() { return text; }
public void setText(String text) { this.text = text; }
public boolean isCorrect() { return correct; }
public void setCorrect(boolean correct) { this.correct = correct; }
public Question getQuestion() { return question; }
public void setQuestion(Question question) { this.question = question; }
}
