package com.example.kwadrat_logiczny;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.List;

public class HelloController {

    @FXML
    private Pane drawingPane; // Add this line

    @FXML
    private Pane transitionPane; // Add this line




    @FXML
    private ScrollPane scrollPane; // Add this line for the ScrollPane
    @FXML
    private Label welcomeText;
    @FXML
    private Button buttonGenerate;



    private int squareDrawn = 0;



    // stworzenie przykladowych kwadratów
    Square square1 = new Square("¬ Immobilising","Taxiing","Open","Stop");
    Square square2 = new Square("Steps","Engine on","Open","Engine of");
    Square square3 = new Square("Cleaned","Unloading","Locked","Empty");


    // stworzenie przykladowych grafów
    SpanningTree spanningTree = new SpanningTree(square1);
    SpanningTree spanningTree2 = new SpanningTree(square2);
    SpanningTree spanningTree3 = new SpanningTree(square3);


    @FXML
    private VBox vbox2;



    public void initialize() {

        //vbox2
        Label selectedLeaf = new Label("set leaf A");
        vbox2.getChildren().add(selectedLeaf);


        ChoiceBox<Integer> choiceBox = new ChoiceBox<>();
        choiceBox.getItems().add(0);
        choiceBox.getItems().add(1);

        vbox2.getChildren().add(choiceBox);
        System.out.println("second");

        Pane transition2Pane = new Pane();
        vbox2.getChildren().add(transition2Pane);

        Rectangle square2 = new Rectangle(200, 300, 100, 100);
        square2.setFill(Color.CADETBLUE);
        transition2Pane.getChildren().add(square2);
        //label_selectState.setText("select A:");




        TabPane tabPane = new TabPane();

        Tab tab1 = new Tab();
        tab1.setText("Square 1");
        tabPane.getTabs().add(tab1);

        Tab tab2 = new Tab();
        tab2.setText("Square 2");
        tabPane.getTabs().add(tab2);

        Tab tab3 = new Tab();
        tab3.setText("Square 3");
        tabPane.getTabs().add(tab3);

        VBox vbox = new VBox(tabPane);

        vbox2.getChildren().add(vbox);


    }


    @FXML
    protected void onHelloButtonClick() {


        List<Square> createdSquare = new ArrayList<>();
        createdSquare.add(square1);
        createdSquare.add(square2);
        createdSquare.add(square3);

        if(squareDrawn <3){

            int yOffset = 250 * squareDrawn;
            // Draw a square
            Rectangle square = new Rectangle(200, 100+yOffset, 100, 100);
            drawingPane.getChildren().add(square);

            // Draw diagonals
            Line diagonal1 = new Line(200, 100+yOffset, 300, 200+yOffset);
            diagonal1.setStroke(Color.RED);
            Line diagonal2 = new Line(200, 200+yOffset, 300, 100+yOffset);
            diagonal2.setStroke(Color.BLUE);
            drawingPane.getChildren().addAll(diagonal1, diagonal2);


            Label rightUp = new Label(createdSquare.get(squareDrawn).getRu());
            rightUp.setLayoutX(350);
            rightUp.setLayoutY(50+yOffset);
            drawingPane.getChildren().add(rightUp);

            Label leftUp = new Label(createdSquare.get(squareDrawn).getLu());
            leftUp.setLayoutX(100);
            leftUp.setLayoutY(50+yOffset);
            drawingPane.getChildren().add(leftUp);

            Label leftDown = new Label(createdSquare.get(squareDrawn).getLd());
            leftDown.setLayoutX(100); // Adjust these values as needed
            leftDown.setLayoutY(250+yOffset);  // Adjust these values as needed
            drawingPane.getChildren().add(leftDown);

            Label rightDown = new Label(createdSquare.get(squareDrawn).getRd());
            rightDown.setLayoutX(350); // Adjust these values as needed
            rightDown.setLayoutY(250+yOffset);  // Adjust these values as needed
            drawingPane.getChildren().add(rightDown);

            squareDrawn++;


        }
        else{
            Alert errorAlert = new Alert(Alert.AlertType.INFORMATION);
            errorAlert.setHeaderText("Button 'ADD'");
            errorAlert.setContentText("No more 'squares' can be added");
            errorAlert.showAndWait();
        }



    }



/*
    public void goGenerate(ActionEvent actionEvent) {
        Rectangle square = new Rectangle(200, 100, 100, 100);
        transitionPane.getChildren().add(square);
    }
*/




    public int generateState = 0;
    public void goTransition(ActionEvent actionEvent) {




        List<SpanningTree> spanningTrees = new ArrayList<>();

        spanningTrees.add(spanningTree);
        spanningTrees.add(spanningTree2);
        spanningTrees.add(spanningTree3);



        if(generateState == 0 & squareDrawn ==0){
            Alert errorAlert = new Alert(Alert.AlertType.INFORMATION);
            errorAlert.setHeaderText("Button 'Generate'");
            errorAlert.setContentText("No added squares\nFirstly click ADD button to added square");
            errorAlert.showAndWait();
        }
        else if(generateState<3){
            for(int i = generateState; i<squareDrawn; i++){
                if(generateState == 0){
                    Rectangle root = new Rectangle(200, 100, 100, 100);
                    transitionPane.getChildren().add(root);
                }


                int yOffset = 200 * (i);


                // rysowanie kwadratów ---------------------------------------------------
                Rectangle square = new Rectangle(200, 300+yOffset, 100, 100);
                square.setFill(Color.CADETBLUE);
                transitionPane.getChildren().add(square);

                Rectangle squareL = new Rectangle(0, 300+yOffset, 100, 100);
                squareL.setFill(Color.CADETBLUE);
                transitionPane.getChildren().add(squareL);

                Rectangle squareR = new Rectangle(400, 300+yOffset, 100, 100);
                squareR.setFill(Color.CADETBLUE);
                transitionPane.getChildren().add(squareR);

                // napisy -------------------------------------------------
                Label middleTxt = new Label(spanningTrees.get(i).getMiddleLeaf());
                middleTxt.setLayoutX(250);
                middleTxt.setLayoutY(225+yOffset);
                transitionPane.getChildren().add(middleTxt);

                Label leftTxt = new Label(spanningTrees.get(i).getLeftLeaf());
                leftTxt.setLayoutX(25);
                leftTxt.setLayoutY(225+yOffset);
                transitionPane.getChildren().add(leftTxt);

                Label rightTxt = new Label(spanningTrees.get(i).getRightLeaf());
                rightTxt.setLayoutX(425);
                rightTxt.setLayoutY(225+yOffset);
                transitionPane.getChildren().add(rightTxt);


                // rysowanie linii --------------------------------------
                Line line = new Line(250, 200+yOffset, 250, 300+yOffset);
                line.setStroke(Color.LIME);
                Line lineL = new Line(250, 200+yOffset, 400, 300+yOffset);
                lineL.setStroke(Color.BLUE);
                Line lineR = new Line(250, 200+yOffset, 100, 300+yOffset);
                lineR.setStroke(Color.BLUE);
                transitionPane.getChildren().addAll(line, lineL, lineR);

                generateState++;

            }
        }


        if(squareDrawn >3){
            Alert errorAlert = new Alert(Alert.AlertType.INFORMATION);
            errorAlert.setHeaderText("Button 'Generate'");
            errorAlert.setContentText("Generate just all squares");
            errorAlert.showAndWait();
        }


    }
}