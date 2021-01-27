package part1.gofpatterns.Behavioral.Strategy.problem;

public class Client {
    public static void main(String[] args) {
        //default = easy
        Chess chess = new Chess();

        System.out.println("Chess next step: " + chess.calculateNextStep());

        chess.setDifficulty(Difficulty.MEDIUM);
        System.out.println("Chess next step: " + chess.calculateNextStep());


    }
}
