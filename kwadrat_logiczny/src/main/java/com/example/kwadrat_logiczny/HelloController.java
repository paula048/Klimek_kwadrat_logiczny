package com.example.kwadrat_logiczny;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.Arrays;
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


    public List<SpanningTree> spanningTrees = new ArrayList<>();

    public void initialize() {


        // Podstawa towrzenie listy kwadratów
        spanningTrees.add(spanningTree);
        spanningTrees.add(spanningTree2);
        spanningTrees.add(spanningTree3);

        //vbox2
        Label selectedLeaf = new Label("set leaf A");
        vbox2.getChildren().add(selectedLeaf);

        createTabPane();








    }




    public void createTabPane(){
        // deklaracja

        VBox vBox1 = new VBox();
        VBox vBox2 = new VBox();
        VBox vBox3 = new VBox();


        // towrzenie panelu ze zmiennym widokiem

        TabPane tabPane = new TabPane();

        Tab tab1 = new Tab();
        tab1.setText("Square 1");
        createTab(vBox1, square1);
        tab1.setContent(vBox1);
        tabPane.getTabs().add(tab1);

        Tab tab2 = new Tab();
        tab2.setText("Square 2");
        createTab(vBox2, square2);
        tab2.setContent(vBox2);
        tabPane.getTabs().add(tab2);

        Tab tab3 = new Tab();
        tab3.setText("Square 3");
        createTab(vBox3, square3);
        tab3.setContent(vBox3);
        tabPane.getTabs().add(tab3);


        VBox vbox = new VBox(tabPane);
        vbox2.getChildren().add(vbox);
    }


    public void createTab(VBox vBox, Square square){

        Rectangle rectangle = new Rectangle(200, 100, 100, 100);
        rectangle.setFill(Color.DARKSEAGREEN);

        Button haha = new Button("click");
        vBox.getChildren().add(haha);

        Button b1 = new Button("A");
        Button b2 = new Button("E");
        Button b3 = new Button("I");
        Button b4 = new Button("O");

        checkLeaf_color(b1);
        checkLeaf_color(b2);
        checkLeaf_color(b3);
        checkLeaf_color(b4);

        //mozliwosc optymalizacji  przez liste
        ArrayList<Button> buttonBox = new ArrayList<Button>(Arrays.asList(b1,b2,b3,b4));



        //  towrzenie kwadratu z liśćmi(leafs) jako przyciskami
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.add(b1,0,0);
        gridPane.add(b2,2,0);
        gridPane.add(rectangle,1,1);
        gridPane.add(b3,0,2);
        gridPane.add(b4,2,2);

        vBox.getChildren().add(gridPane);


        ChoiceBox<Integer> choiceBox1 = new ChoiceBox<>();
        choiceBox1.getItems().add(0);
        choiceBox1.getItems().add(1);
        ChoiceBox<Integer> choiceBox2 = new ChoiceBox<>();
        choiceBox2.getItems().add(0);
        choiceBox2.getItems().add(1);
        ChoiceBox<Integer> choiceBox3 = new ChoiceBox<>();
        choiceBox3.getItems().add(0);
        choiceBox3.getItems().add(1);
        ChoiceBox<Integer> choiceBox4 = new ChoiceBox<>();
        choiceBox4.getItems().add(0);
        choiceBox4.getItems().add(1);


        Label label_tmp1 = new Label("SET A:\t "+square.getLu());
        Label label_tmp2 = new Label("SET I:\t "+square.getLd());
        Label label_tmp3 = new Label("SET O:\t "+square.getRd());
        Label label_tmp4 = new Label("SET E:\t "+square.getRu());

        HBox hBox1 = new HBox();
        HBox hBox2 = new HBox();
        HBox hBox3 = new HBox();
        HBox hBox4 = new HBox();

        hBox1.getChildren().add(label_tmp1);
        hBox1.getChildren().add(choiceBox1);
        hBox2.getChildren().add(label_tmp2);
        hBox2.getChildren().add(choiceBox2);
        hBox3.getChildren().add(label_tmp3);
        hBox3.getChildren().add(choiceBox3);
        hBox4.getChildren().add(label_tmp4);
        hBox4.getChildren().add(choiceBox4);


        vBox.getChildren().add(hBox1);
        vBox.getChildren().add(hBox2);
        vBox.getChildren().add(hBox3);
        vBox.getChildren().add(hBox4);
    }


    private void checkLeaf_color(Button btn){

        /*  optymalizacja
        for (int i = 0; i < Cars.size(); i++) {
            Cars.set(i, Cars.get(i) + "A");
        }
        */


        btn.setOnAction(e -> {

            if(btn.getStyle().contains("-fx-background-color: red;")){
                btn.setStyle("");
            }
            else{
                btn.setStyle("-fx-background-color: red;");

            }

        });


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




    public int generateState = 0;
    public void goTransition(ActionEvent actionEvent) {








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


class Person {
    private String firstName = null;
    private String lastName = null;

    public Person() {
    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}