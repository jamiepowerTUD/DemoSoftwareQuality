package SQA;

public class Criterion {

    String title ;
    int score ;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Criterion(String title, int score)
    {
        this.title = title ;
        this.score = score ;
    }

}
