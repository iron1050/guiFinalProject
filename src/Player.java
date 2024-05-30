public class Player {
    private int score;
    private String name;


    public Player(String n) {
        name = n;
        score = 0;
    }

    public void iterateScore() {
        score++;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }
}

