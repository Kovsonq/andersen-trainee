package gofpatterns.Behavioral.Strategy.solution;

public class Chess {
    private ChessAlgorithm chessAlgorithm; //= new EasyChessAlgorithm();

    public int calculateNextStep(){
        return chessAlgorithm.calculateNextStep();
    }

    public void setChessAlgorithm(ChessAlgorithm chessAlgorithm) {
        this.chessAlgorithm = chessAlgorithm;
    }
}
