package com.example.quiz.service;


import com.example.quiz.model.Quiz;
import com.example.quiz.repository.QuizRepository;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;


@Service
public class QuizService {
private final QuizRepository quizRepository;


public QuizService(QuizRepository quizRepository) {
this.quizRepository = quizRepository;
}


public List<Quiz> findAll() { return quizRepository.findAll(); }
public Optional<Quiz> findById(Long id) { return quizRepository.findById(id); }
public Quiz save(Quiz q) { return quizRepository.save(q); }
}