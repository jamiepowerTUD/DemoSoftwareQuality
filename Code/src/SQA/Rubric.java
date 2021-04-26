package SQA;


import java.util.ArrayList;

public class Rubric
{

    String title ;
    ArrayList<Criterion> criteria ;

    public Rubric(String title)
    {
        this.title = title ;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<Criterion> getCriteria() {
        return criteria;
    }

    public void setCriteria(ArrayList<Criterion> criteria) {
        this.criteria = criteria;
    }
}
