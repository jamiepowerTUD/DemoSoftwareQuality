package SQA;

public class Grade {

    // Grade object which stores a students name and Rubric with scored criterion

    String name ;
    Rubric rubric ;

    public Grade(String name, Rubric rubric)
    {
        this.name = name ;
        this.rubric = rubric ;
    }

    public Rubric getRubric() {
        return rubric;
    }

}
