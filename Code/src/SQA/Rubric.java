package SQA;


import java.util.ArrayList;

public class Rubric
{

    // A rubric has a title and a list of criterion
    String title ;
    ArrayList<Criterion> criteria ;

    public Rubric(String title)
    {
        this.title = title ;
        criteria = new ArrayList<Criterion>();
    }

    public String getTitle() {
        return title;
    }

    public ArrayList<Criterion> getCriteria() {
        return criteria;
    }

    public void setCriteria(ArrayList<Criterion> criteria) {
        this.criteria = criteria;
    }
}
