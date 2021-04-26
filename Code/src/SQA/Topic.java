package SQA;

import java.util.ArrayList;

public class Topic {

    String title ;
    ArrayList<Rubric> rubrics ;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<Rubric> getRubrics() {
        return rubrics;
    }

    public void setRubrics(ArrayList<Rubric> rubrics) {
        this.rubrics = rubrics;
    }

    public Topic(String title)
    {
        this.title = title ;

    }


}
