package part1.gofpatterns.Behavioral.Strategy.problem;

public class Chess {

    private Difficulty difficulty = Difficulty.EASY;

    public int calculateNextStep(){
        if (difficulty == Difficulty.EASY){
            return 1;
        }
        if (difficulty == Difficulty.MEDIUM){
            return 2;
        }
        if (difficulty == Difficulty.HARD){
            return 3;
        }
        return 0;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

}
