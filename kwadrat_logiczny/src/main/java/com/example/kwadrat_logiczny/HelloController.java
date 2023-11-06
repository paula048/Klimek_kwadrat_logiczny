package com.example.kwadrat_logiczny;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

public class HelloController {

    @FXML
    private Pane drawingPane; // Add this line


    @FXML
    private Label welcomeText;

    private int countClick = 0;

    @FXML
    protected void onHelloButtonClick() {

        int yOffset = 100 * countClick;
        // Draw a square
        Rectangle square = new Rectangle(200, 100+yOffset, 100, 100);
        drawingPane.getChildren().add(square);

        // Draw diagonals
        Line diagonal1 = new Line(200, 100+yOffset, 300, 200+yOffset);
        diagonal1.setStroke(Color.RED);
        Line diagonal2 = new Line(200, 200+yOffset, 300, 100+yOffset);
        diagonal2.setStroke(Color.BLUE);
        drawingPane.getChildren().addAll(diagonal1, diagonal2);


        // Add label in the upper right corner
        Label rightUp = new Label("Hello Lady");
        rightUp.setLayoutX(350); // Adjust these values as needed
        rightUp.setLayoutY(50+yOffset);  // Adjust these values as needed
        drawingPane.getChildren().add(rightUp);

        Label leftUp = new Label("Hello Lady");
        leftUp.setLayoutX(100); // Adjust these values as needed
        leftUp.setLayoutY(50+yOffset);  // Adjust these values as needed
        drawingPane.getChildren().add(leftUp);

        Label leftDown = new Label("Hello Lady");
        leftDown.setLayoutX(100); // Adjust these values as needed
        leftDown.setLayoutY(250+yOffset);  // Adjust these values as needed
        drawingPane.getChildren().add(leftDown);

        Label rightDown = new Label("Hello Lady");
        rightDown.setLayoutX(350); // Adjust these values as needed
        rightDown.setLayoutY(250+yOffset);  // Adjust these values as needed
        drawingPane.getChildren().add(rightDown);

        countClick++;

    }


}