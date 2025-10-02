package com.example.quiz.data;

import com.example.quiz.model.Option;
import com.example.quiz.model.Question;
import com.example.quiz.model.Quiz;
import com.example.quiz.service.QuizService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final QuizService quizService;

    public DataLoader(QuizService quizService) {
        this.quizService = quizService;
    }

    @Override
    public void run(String... args) throws Exception {
        Quiz quiz = new Quiz("Java Basics Quiz");

        // Question 1
        Question q1 = new Question("1) What does JVM stand for?");
        q1.addOption(new Option("\nJava Virtual Machine", true));
        q1.addOption(new Option("Java Very Much", false));
        q1.addOption(new Option("Just Verify Method", false));
        quiz.addQuestion(q1);

        // Question 2
        Question q2 = new Question("Which keyword is used to inherit a class in Java?");
        q2.addOption(new Option("extends", true));
        q2.addOption(new Option("implements", false));
        q2.addOption(new Option("inherits", false));
        quiz.addQuestion(q2);

        // Question 3
        Question q3 = new Question("What is the default value of an int variable?");
        q3.addOption(new Option("0", true));
        q3.addOption(new Option("null", false));
        q3.addOption(new Option("undefined", false));
        quiz.addQuestion(q3);

        // Question 4
        Question q4 = new Question("Which method is the entry point of a Java program?");
        q4.addOption(new Option("main", true));
        q4.addOption(new Option("start", false));
        q4.addOption(new Option("run", false));
        quiz.addQuestion(q4);

        // Question 5
        Question q5 = new Question("Which of these is a primitive data type in Java?");
        q5.addOption(new Option("String", false));
        q5.addOption(new Option("int", true));
        q5.addOption(new Option("ArrayList", false));
        quiz.addQuestion(q5);

        // Question 6
        Question q6 = new Question("Which operator is used for logical AND in Java?");
        q6.addOption(new Option("&&", true));
        q6.addOption(new Option("&", false));
        q6.addOption(new Option("||", false));
        quiz.addQuestion(q6);

        // Question 7
        Question q7 = new Question("Which keyword is used to define an interface?");
        q7.addOption(new Option("interface", true));
        q7.addOption(new Option("class", false));
        q7.addOption(new Option("implements", false));
        quiz.addQuestion(q7);

        // Question 8
        Question q8 = new Question("Which of these is NOT a loop in Java?");
        q8.addOption(new Option("for", false));
        q8.addOption(new Option("while", false));
        q8.addOption(new Option("repeat", true));
        quiz.addQuestion(q8);

        // Question 9
        Question q9 = new Question("Which exception is thrown when dividing by zero?");
        q9.addOption(new Option("ArithmeticException", true));
        q9.addOption(new Option("NullPointerException", false));
        q9.addOption(new Option("IOException", false));
        quiz.addQuestion(q9);

        // Question 10
        Question q10 = new Question("Which package contains the Scanner class?");
        q10.addOption(new Option("java.util", true));
        q10.addOption(new Option("java.io", false));
        q10.addOption(new Option("java.lang", false));
        quiz.addQuestion(q10);

        // Save the quiz with all 10 questions
        quizService.save(quiz);
    }
}
