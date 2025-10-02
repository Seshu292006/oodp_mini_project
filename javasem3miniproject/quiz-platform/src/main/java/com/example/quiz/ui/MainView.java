package com.example.quiz.ui;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("")
public class MainView extends VerticalLayout {

    public MainView() {
        setAlignItems(Alignment.CENTER);
        setPadding(true);
        setSpacing(true);

        add(new Label("Welcome to the Quiz Platform"));

        Button start = new Button("Take Quiz", e -> UI.getCurrent().navigate(QuizView.class));
        start.getStyle().set("background-color", "#4CAF50")
                .set("color", "white")
                .set("padding", "10px 20px")
                .set("border-radius", "5px");

        add(start);
    }
}
