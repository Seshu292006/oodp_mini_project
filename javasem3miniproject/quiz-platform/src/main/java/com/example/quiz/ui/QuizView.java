package com.example.quiz.ui;

import com.example.quiz.model.Option;
import com.example.quiz.model.Question;
import com.example.quiz.model.Quiz;
import com.example.quiz.repository.QuizRepository;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

@Route("quiz")
public class QuizView extends VerticalLayout {

    private final QuizRepository quizRepository;

    @Autowired
    public QuizView(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;

        // Set full-page background image
        getStyle().set("background-image", "url('images/background.jpg')");
        getStyle().set("background-size", "cover");
        getStyle().set("background-position", "center");
        getStyle().set("height", "100vh");
        getStyle().set("padding", "30px");

        setAlignItems(Alignment.CENTER);
        setSpacing(true);

        // Load first quiz
        Quiz quiz = quizRepository.findAll().stream().findFirst().orElse(null);
        if (quiz == null) {
            add(new Label("No quizzes found."));
            return;
        }

        add(new Label("Quiz: " + quiz.getTitle()));

        Map<Question, RadioButtonGroup<String>> answerMap = new HashMap<>();

        for (int i = 0; i < quiz.getQuestions().size(); i++) {
            Question q = quiz.getQuestions().get(i);

            // Card for each question
            Div card = new Div();
            card.getStyle().set("background", "rgba(214, 93, 93, 0.85)"); // semi-transparent
            card.getStyle().set("border-radius", "10px");
            card.getStyle().set("padding", "15px");
            card.getStyle().set("margin-bottom", "20px");
            card.getStyle().set("width", "500px");

            // Question number + text
            Label questionLabel = new Label((i + 1) + ". " + q.getText());
            questionLabel.getStyle().set("font-weight", "bold").set("font-size", "16px");
            card.add(questionLabel);

            // Options as radio buttons
            RadioButtonGroup<String> optionsGroup = new RadioButtonGroup<>();
            optionsGroup.setItems(q.getOptions().stream().map(Option::getText).toList());
            card.add(optionsGroup);

            add(card);
            answerMap.put(q, optionsGroup);
        }

        // Submit button
        Button submit = new Button("Submit", e -> {
            int score = 0;
            for (Map.Entry<Question, RadioButtonGroup<String>> entry : answerMap.entrySet()) {
                Question question = entry.getKey();
                String selected = entry.getValue().getValue();
                if (selected != null && question.getOptions().stream()
                        .anyMatch(opt -> opt.getText().equals(selected) && opt.isCorrect())) {
                    score++;
                }
            }
            Notification.show("You scored " + score + " out of " + quiz.getQuestions().size());
        });

        // Green styling
        submit.getStyle().set("background-color", "#4CAF50")
                .set("color", "white")
                .set("padding", "10px 20px")
                .set("border-radius", "5px")
                .set("margin-top", "10px");

        add(submit);
    }
}
