package Behavioral.Strategy.solution;

public class Client {
    public static void main(String[] args) {
        Chess chess = new Chess();
        System.out.println("Chess next step: " + chess.calculateNextStep());

        chess.setChessAlgorithm(new HardChessAlgorithm());
        System.out.println("Chess next step: " + chess.calculateNextStep());

    }

}
