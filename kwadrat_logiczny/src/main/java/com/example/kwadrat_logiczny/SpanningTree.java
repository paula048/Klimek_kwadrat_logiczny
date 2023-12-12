package com.example.kwadrat_logiczny;

public class SpanningTree {
    private String leftLeaf;
    private String rightLeaf;
    private String middleLeaf;
    private Square square;
    public String choseedCorner = "right";


    public String getChoseedCorner() {
        return choseedCorner;
    }

    public void setChoseedCorner(String choseedCorner) {
        this.choseedCorner = choseedCorner;
    }




    public SpanningTree(Square square) {
        this.square = square;
        this.leftLeaf = this.square.lu.getCornerName() + "\n&\n" + this.square.ld.getCornerName();
        this.middleLeaf = this.square.rd.getCornerName() + "\n&\n" + this.square.ru.getCornerName();
        this.rightLeaf = this.square.rd.getCornerName() + "\n&\n" + this.square.ld.getCornerName();
    }


    public String getScenarios_L() {
        return leftLeaf.replace("\n&\n", " & ");
    }
    public String getScenarios_M() {
        return middleLeaf.replace("\n&\n", " & ");
    }
    public String getScenarios_R() {
        return rightLeaf.replace("\n&\n", " & ");
    }

    public String getLeftLeaf() {
        return leftLeaf;
    }

    public String getRightLeaf() {
        return rightLeaf;
    }

    public String getMiddleLeaf() {
        return middleLeaf;
    }
}
