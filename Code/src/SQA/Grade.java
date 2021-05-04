package SQA;

public class Grade {

    String name ;
    Rubric rubric ;

    public Grade(String name, Rubric rubric)
    {
        this.name = name ;
        this.rubric = rubric ;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Rubric getRubric() {
        return rubric;
    }

    public void setRubric(Rubric rubric) {
        this.rubric = rubric;
    }
}
