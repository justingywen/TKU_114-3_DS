public class Contestant {
    private String id;
    private String name;
    private int score;
    private int seconds;

    public Contestant(String id, String name, int score, int seconds) {
        this.id = id;
        this.name = name;
        this.score = score;
        this.seconds = seconds;
    }

    public int getScore() { return score; }
    public int getSeconds() { return seconds; }

    @Override
    public String toString() {
        return String.format("%s | %-8s | %3d 分 | %3d 秒", id, name, score, seconds);
    }
}