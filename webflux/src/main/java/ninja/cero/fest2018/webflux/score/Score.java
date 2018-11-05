package ninja.cero.fest2018.webflux.score;

public class Score {
    public int id;
    public String type;
    public int score;

    public Score(int id, String type, int score) {
        this.id = id;
        this.type = type;
        this.score = score;
    }

    @Override
    public String toString() {
        return this.id + " " + this.type + " " + this.score;
    }
}
