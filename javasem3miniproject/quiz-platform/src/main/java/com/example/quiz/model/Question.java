package com.example.quiz.model;


import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Question {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;


@Column(length = 1000)
private String text;


@ManyToOne
private Quiz quiz;


@OneToMany(mappedBy = "question", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
private List<Option> options = new ArrayList<>();


public Question() {}
public Question(String text) { this.text = text; }


public Long getId() { return id; }
public String getText() { return text; }
public void setText(String text) { this.text = text; }
public Quiz getQuiz() { return quiz; }
public void setQuiz(Quiz quiz) { this.quiz = quiz; }
public List<Option> getOptions() { return options; }


public void addOption(Option opt) {
options.add(opt);
opt.setQuestion(this);
}
}