package com.example.kwadrat_logiczny;

public class SpanningTree {
    private String leftLeaf;
    private String rightLeaf;
    private String middleLeaf;
    private Square square;

    public SpanningTree(Square square) {
        this.square = square;
        this.leftLeaf = this.square.getLu() + "\n&\n" + this.square.getLd();
        this.middleLeaf = this.square.getRd() + "\n&\n" + this.square.getRu();
        this.rightLeaf = this.square.getRd() + "\n&\n" + this.square.getLd();
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
