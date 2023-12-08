package com.example.kwadrat_logiczny;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HelloController {

    @FXML
    private Pane drawingPane; // Add this line

    @FXML
    private Pane transitionPane; // Add this line




    public boolean isDrawn_SpanningTree = false;

    private int squareDrawn = 0;



    // stworzenie przykladowych kwadratów
    Square square1 = new Square("¬ Immobilising","Taxiing","Immobilising","Stop");
    Square square2 = new Square("Steps","Engine on","Open","Engine of");
    Square square3 = new Square("Cleaned","Unloading","Locked","Empty");


    // stworzenie przykladowych grafów
    SpanningTree spanningTree = new SpanningTree(square1);
    SpanningTree spanningTree2 = new SpanningTree(square2);
    SpanningTree spanningTree3 = new SpanningTree(square3);


    @FXML
    private VBox vbox2;





    public List<SpanningTree> spanningTrees = new ArrayList<>();

    public List<SpanningTree_Label> spanningTreeLabels = new ArrayList<>();

    public List<Rectangle> rectangles = new ArrayList<>();
    public TabPane tabPane = new TabPane();
    public List<Square> saveSquares = new ArrayList<>();    // ważne -------------------------------------------------------


    public List<Corner> isCornerChange = new ArrayList<>();     // ważne -------------------------------------------------------

    public List<Square> createdSquare = new ArrayList<>();
    public List<DrawSquare> drawSquares = new ArrayList<>();

    public void initialize() {
        // zmienna sprwdzajaca czy zmieniono wartośći w kwadracie
        isCornerChange.add(new Corner());
        isCornerChange.add(new Corner());
        isCornerChange.add(new Corner());


        createdSquare.add(new Square());



        spanningTreeLabels.add(new SpanningTree_Label());
        spanningTreeLabels.add(new SpanningTree_Label());
        spanningTreeLabels.add(new SpanningTree_Label());


        addSquare();






        // towrzenie panelu ze zmiennym widokiem

        VBox vbox = new VBox(tabPane);
        vbox2.getChildren().add(vbox);
        vbox2.getChildren().add(new Button("HEHE XD"));


        for (int i = 0; i < 3; i++) {
            rectangles.add(null);
        }

        if(rectangles.get(0) == null){
            System.out.println("First NULL");
        }


    }




    public void createTabPane(VBox box, Square square, Integer number){


        Tab tab = new Tab();
        tab.setText("Square "+(number+1));
        createTab(box, square, number);
        tab.setContent(box);
        tabPane.getTabs().add(tab);




        // okrągły przycisk
        Button button = new Button("SCENARIOS");
        Circle circle = new Circle();
        circle.setRadius(50.0f);
        button.setShape(circle);
        button.setMinSize(100.0, 100.0);
        StackPane stackPane = new StackPane();
        stackPane.getChildren().add(button);
        box.setMargin(stackPane, new Insets(20));

        button.setOnAction(e -> {
            writeScenarios();
        });

        box.getChildren().add(stackPane);

        // Panel rozwijany z podpowiedzią ZASADY
        Label label = new Label("A -> E:\tcontrary\nA -> O:\tcontradictory\nA -> I:\tsubalternate");
        TitledPane titledPane = new TitledPane("Rules", label);
        titledPane.setExpanded(false);
        box.getChildren().add(titledPane);

    }



    public void saveSquare(){

    }


    public void createTab(VBox vBox, Square square, int nr_square){

        Rectangle rectangle = new Rectangle(200, 100, 100, 100);
        rectangle.setFill(Color.DARKSEAGREEN);



        Text text1 = new Text("TIPS");
        //Text text2 = new Text("YOU");
        //text2.setStyle("-fx-font-weight: bold");
        //Text text3 = new Text(" baby");


        TextFlow textFlow = new TextFlow(text1);
        textFlow.setStyle("-fx-border-color: blue");
        textFlow.setMinHeight(50);

        vBox.getChildren().add(textFlow);



        Button b1 = new Button("A");
        Button b2 = new Button("E");
        Button b3 = new Button("I");
        Button b4 = new Button("O");


        /*
        checkLeaf_color(b1);
        checkLeaf_color(b2);
        checkLeaf_color(b3);
        checkLeaf_color(b4);
        */


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



        Label label_tmp1 = new Label("SET A:\t ");
        Label label_tmp2 = new Label("SET I:\t ");
        Label label_tmp3 = new Label("SET O:\t ");
        Label label_tmp4 = new Label("SET E:\t ");

        HBox hBox1 = new HBox();
        HBox hBox2 = new HBox();
        HBox hBox3 = new HBox();
        HBox hBox4 = new HBox();

        TextField txt_corner1 = new TextField();
        TextField txt_corner2 = new TextField();
        TextField txt_corner3 = new TextField();
        TextField txt_corner4 = new TextField();


        Button buttonSave = new Button("SAVE");
        buttonSave.setStyle("-fx-background-color: #9e9e9e;");





        // dodawanie ' triggera'  -  sprawdza czy zmieniono wrtość
        txt_corner1.textProperty().addListener((observable, oldValue, newValue) -> {
            Corner tmpCorner = isCornerChange.get(nr_square);
            tmpCorner.setA(1);
            buttonSave.setStyle("-fx-background-color: #9e9e9e;");          // po zmianie, ustawia stan jako niezpisany, [ Button color ]
            isCornerChange.set(nr_square, tmpCorner);
        });
        txt_corner2.textProperty().addListener((observable, oldValue, newValue) -> {
            Corner tmpCorner = isCornerChange.get(nr_square);
            tmpCorner.setI(1);
            buttonSave.setStyle("-fx-background-color: #9e9e9e;");
            isCornerChange.set(nr_square, tmpCorner);
        });
        txt_corner3.textProperty().addListener((observable, oldValue, newValue) -> {
            Corner tmpCorner = isCornerChange.get(nr_square);
            tmpCorner.setO(1);
            buttonSave.setStyle("-fx-background-color: #9e9e9e;");
            isCornerChange.set(nr_square, tmpCorner);
        });
        txt_corner4.textProperty().addListener((observable, oldValue, newValue) -> {
            Corner tmpCorner = isCornerChange.get(nr_square);
            tmpCorner.setE(1);
            buttonSave.setStyle("-fx-background-color: #9e9e9e;");
            isCornerChange.set(nr_square, tmpCorner);
        });




        hBox1.getChildren().add(label_tmp1);
        hBox1.getChildren().add(txt_corner1);
        hBox2.getChildren().add(label_tmp2);
        hBox2.getChildren().add(txt_corner2);
        hBox3.getChildren().add(label_tmp3);
        hBox3.getChildren().add(txt_corner3);
        hBox4.getChildren().add(label_tmp4);
        hBox4.getChildren().add(txt_corner4);

        vBox.getChildren().add(hBox1);
        vBox.getChildren().add(hBox2);
        vBox.getChildren().add(hBox3);
        vBox.getChildren().add(hBox4);




        buttonSave.setMinSize(200,50);

        buttonSave.setOnAction(e -> {
            click_buttonSave(txt_corner2, txt_corner1, txt_corner4, txt_corner3, nr_square, buttonSave);
        });



        vBox.getChildren().add(buttonSave);

    }


    private void checkLeaf_color(Button btn){


        btn.setOnAction(e -> {

            if(btn.getStyle().contains("-fx-background-color: red;")){
                btn.setStyle("");
            }
            else{
                btn.setStyle("-fx-background-color: red;");
            }

        });


    }



    private void click_buttonSave(TextField txt_corner2, TextField txt_corner1, TextField txt_corner4, TextField txt_corner3, int nr_square, Button buttonSave){

        System.out.println("corner change: \t"+isCornerChange.get(0).isCornerChange());

        Square squareSave = new Square(txt_corner2.getText(), txt_corner1.getText(), txt_corner4.getText(), txt_corner3.getText());


        if(isCornerChange.get(nr_square).isCornerChange()){             // jeśli zmieniono nazwę aktualizuj kwadrat
            DrawSquare tmp = drawSquares.get(nr_square);
            tmp.luCorner.setText(txt_corner1.getText());
            tmp.ldCorner.setText(txt_corner2.getText());
            tmp.rdCorner.setText(txt_corner3.getText());
            tmp.ruCorner.setText(txt_corner4.getText());
            drawSquares.set(nr_square,tmp);

        }

        buttonSave.setStyle("-fx-background-color: #3cbd26;");

        // po zapisaniu aktualny stan isChange zeruje się
        isCornerChange.set(0, new Corner());
        isCornerChange.set(1, new Corner());
        isCornerChange.set(2, new Corner());





        SpanningTree tmp_spanningTree = new SpanningTree(squareSave);

        if(saveSquares.size()==nr_square){
            saveSquares.add(squareSave);
            spanningTrees.add(tmp_spanningTree);
        }
        else{
            saveSquares.set(nr_square, squareSave);
            spanningTrees.set(nr_square, tmp_spanningTree);
        }


            if(generateState<squareDrawn){
                goTransition();
            }
            else{
                Update_SpanningTree();
            }




        System.out.println("Spanning test "+nr_square+"\t"+spanningTrees.get(nr_square).getLeftLeaf()+"\t"+spanningTrees.get(nr_square).getRightLeaf());


    }


    @FXML
    protected void addSquare() {

        String tmp;
        for (int i =0; i<squareDrawn; i++){
            System.out.println("is CHANGE ?  ["+i+"]:   "+isCornerChange.get(i).isCornerChange());
        }




        if(createdSquare.size()<3){
            createdSquare.add(new Square());
        }


        if(squareDrawn <3){

            VBox tabBox = new VBox();
            createTabPane(tabBox, createdSquare.get(squareDrawn), squareDrawn);

            DrawSquare drawSquare = new DrawSquare();           // tmp

            int yOffset = 250 * squareDrawn;
            // Draw a square
            Rectangle square = new Rectangle(200, 100+yOffset, 100, 100);
            drawingPane.getChildren().add(square);

            // Draw diagonals
            Line diagonal1 = new Line(200, 100+yOffset, 300, 200+yOffset);
            diagonal1.setStroke(Color.BLUE);
            Line diagonal2 = new Line(200, 200+yOffset, 300, 100+yOffset);
            diagonal2.setStroke(Color.BLUE);

            Line space = new Line(50, 280+yOffset, 450, 280+yOffset);
            space.setStroke(Color.BLACK);
            space.getStrokeDashArray().addAll(20d, 10d);
            drawingPane.getChildren().addAll(diagonal1, diagonal2, space);



            // TEXT name of corners
            Label rightUp = new Label(createdSquare.get(squareDrawn).getRu());
            rightUp.setLayoutX(350);
            rightUp.setLayoutY(50+yOffset);
            drawSquare.setRuCorner(rightUp);            // dodanie do klasy przycisków  rogów
            drawingPane.getChildren().add(rightUp);

            Label leftUp = new Label(createdSquare.get(squareDrawn).getLu());
            leftUp.setLayoutX(100);
            leftUp.setLayoutY(50+yOffset);
            drawSquare.setLuCorner(leftUp);
            drawingPane.getChildren().add(leftUp);

            Label leftDown = new Label(createdSquare.get(squareDrawn).getLd());
            leftDown.setLayoutX(100);
            leftDown.setLayoutY(250+yOffset);
            drawSquare.setLdCorner(leftDown);
            drawingPane.getChildren().add(leftDown);

            Label rightDown = new Label(createdSquare.get(squareDrawn).getRd());
            rightDown.setLayoutX(350);
            rightDown.setLayoutY(250+yOffset);
            drawSquare.setRdCorner(rightDown);
            drawingPane.getChildren().add(rightDown);

            drawSquares.add(drawSquare);            // dodanie (całego,jednego) obiektu z przyciskami do listy



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

    private Rectangle tmp_square;

    public void goTransition() {

        isDrawn_SpanningTree = true;            // flaga, naryswano dzrewo

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


                int finalI = i;


                square.setOnMouseClicked(event -> {
                        onClick_chooseNode(square, finalI);
                    });

                    Tooltip t = new Tooltip("Select this node");
                    Tooltip.install(square, t);
                    t.setShowDelay(Duration.seconds(0));

                square.setOnMouseEntered(event -> {
                    square.setCursor(Cursor.HAND); // Change cursor to hand on hover
                    });


                square.setOnMouseExited(event -> {
                    square.setCursor(Cursor.DEFAULT); // Change cursor back to default when not hovering
                    });
                    System.out.println("DO: "+finalI);






                Rectangle squareL = new Rectangle(0, 300+yOffset, 100, 100);
                squareL.setFill(Color.CADETBLUE);
                transitionPane.getChildren().add(squareL);

                squareL.setOnMouseClicked(event -> {
                    onClick_chooseNode(squareL, finalI);
                });

                Tooltip t2 = new Tooltip("Select this node");
                Tooltip.install(squareL, t2);
                t2.setShowDelay(Duration.seconds(0));

                squareL.setOnMouseEntered(event -> {
                    squareL.setCursor(Cursor.HAND); // Change cursor to hand on hover
                });


                squareL.setOnMouseExited(event -> {
                    squareL.setCursor(Cursor.DEFAULT); // Change cursor back to default when not hovering
                });



                Rectangle squareR = new Rectangle(400, 300+yOffset, 100, 100);
                squareR.setFill(Color.CADETBLUE);
                transitionPane.getChildren().add(squareR);

                squareR.setOnMouseClicked(event -> {
                    onClick_chooseNode(squareR, finalI);
                });

                Tooltip t3 = new Tooltip("Select this node");
                Tooltip.install(squareR, t3);
                t3.setShowDelay(Duration.seconds(0));

                squareR.setOnMouseEntered(event -> {
                    squareR.setCursor(Cursor.HAND); // Change cursor to hand on hover
                    //squareR.show(rectangle, event.getScreenX(), event.getScreenY());
                });

                squareR.setOnMouseExited(event -> {
                    squareR.setCursor(Cursor.DEFAULT); // Change cursor back to default when not hovering
                    //tooltip.hide();
                });




                SpanningTree_Label tmp_TreeLabel = new SpanningTree_Label();

                // napisy -------------------------------------------------
                Label middleTxt = new Label(spanningTrees.get(i).getMiddleLeaf());
                middleTxt.setLayoutX(250);
                middleTxt.setLayoutY(225+yOffset);
                tmp_TreeLabel.setMiddleLeaf(middleTxt);         // przypsanie do klasy SpanningTree przyciski( Label )
                transitionPane.getChildren().add(middleTxt);

                Label leftTxt = new Label(spanningTrees.get(i).getLeftLeaf());
                leftTxt.setLayoutX(25);
                leftTxt.setLayoutY(225+yOffset);
                tmp_TreeLabel.setLeftLeaf(leftTxt);
                transitionPane.getChildren().add(leftTxt);

                Label rightTxt = new Label(spanningTrees.get(i).getRightLeaf());
                rightTxt.setLayoutX(425);
                rightTxt.setLayoutY(225+yOffset);
                tmp_TreeLabel.setRightLeaf(rightTxt);
                transitionPane.getChildren().add(rightTxt);

                spanningTreeLabels.set(generateState, tmp_TreeLabel);



                // rysowanie linii --------------------------------------
                Line line = new Line(250, 200+yOffset, 250, 300+yOffset);
                line.setStroke(Color.BLUE);
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


    private void onClick_chooseNode(Rectangle rectangle, int level){

        if(rectangles.get(level) == null){
            System.out.println("LEAV: null");
        }
        if (rectangle.getFill() == Color.CADETBLUE) {
            rectangle.setFill(Color.RED);
            if(rectangles.get(level) != null){
                Rectangle tmp = rectangles.get(level);
                tmp.setFill(Color.CADETBLUE);
            }
            rectangles.set(level, rectangle);
        } else {
            rectangle.setFill(Color.CADETBLUE);
            rectangles.set(level, null);
        }



    }



    @FXML
    private VBox mainBox;
    public void writeScenarios() {


        System.out.println("squareDrawn "+squareDrawn );
        System.out.println("Generate square "+generateState );


        if(generateState==0){
            Alert errorAlert = new Alert(Alert.AlertType.INFORMATION);
            errorAlert.setHeaderText("Button 'SCENARIOS'");
            errorAlert.setContentText("Firstly create any square");
            errorAlert.showAndWait();
        }
        else {
            for(int i = 0; i<squareDrawn; i++){
                Text scenarios = new Text("Scenario "+(i+1)+":\t");
                Text text_L = new Text(spanningTrees.get(i).getScenarios_L().toString());
                Text text_M = new Text(spanningTrees.get(i).getScenarios_M().toString());
                Text text_R = new Text(spanningTrees.get(i).getScenarios_R().toString());
                //  odstępy     ---------------------------------------------------------------
                Text txt_space = new Text("   and then   ");
                txt_space.setFont(Font.font("Arial", FontWeight.BOLD, 12));
                Text txt_space2 = new Text("   and then   ");
                txt_space2.setFont(Font.font("Arial", FontWeight.BOLD, 12));

                TextFlow textFlow = new TextFlow(scenarios, text_L, txt_space, text_M, txt_space2, text_R);
                mainBox.getChildren().add(textFlow);
            }
        }


    }


    public void makeSquareList(DrawSquare draw, Integer number) {

        String A = draw.luCorner.getText();
        String I = draw.ldCorner.getText();
        String O = draw.rdCorner.getText();
        String E = draw.ruCorner.getText();

        Square tmp = new Square(I,A,E,O);


        if(squareDrawn>=saveSquares.size()){
            saveSquares.add(tmp);
        }
        else{
            saveSquares.set(number, tmp);
        }

    }


    public void Update_SpanningTree() {



        //Square tmp = new Square(drawSquares.get(0).luCorner.getText())

        if(!(spanningTreeLabels.isEmpty())){
            for(int k = 0; k< squareDrawn; k++){
                SpanningTree_Label spanningTreeLabel2 = spanningTreeLabels.get(k);
                makeSquareList(drawSquares.get(k), k);
                SpanningTree tmpSpan = new SpanningTree(saveSquares.get(k));

                spanningTreeLabel2.leftLeaf.setText(tmpSpan.getLeftLeaf().toString());
                spanningTreeLabel2.middleLeaf.setText(tmpSpan.getMiddleLeaf().toString());
                spanningTreeLabel2.rightLeaf.setText(tmpSpan.getRightLeaf().toString());

                spanningTreeLabels.set(k, spanningTreeLabel2);
                //spanningTreeLabel2.
            }

        }



        System.out.println("\nTEST   Draw squares: "+drawSquares.get(0).luCorner.getText());
        System.out.println("Spanning tree Label: "+spanningTreeLabels.get(0).leftLeaf.getText()+"\t"+spanningTreeLabels.get(0).rightLeaf.getText());
        System.out.println("\nsave SQUARE: "+saveSquares.get(1).getLu()+"\t"+saveSquares.get(1).getLd());




    }

    public void test(ActionEvent actionEvent) {
        System.out.println("Drawn: "+squareDrawn+"\tState: "+generateState);
    }
}






class Corner {
    private Integer A = 0;
    private Integer I = 0;
    private Integer O = 0;
    private Integer E = 0;

    public void setA(Integer a) {
        A = a;
    }

    public void setI(Integer i) {
        I = i;
    }

    public void setO(Integer o) {
        O = o;
    }

    public void setE(Integer e) {
        E = e;
    }

    public Boolean isCornerChange(){

        boolean tmp = true;
        if((A==0 && I==0 && O==0 && E==0)){
             tmp = false;
        }
        return tmp;
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