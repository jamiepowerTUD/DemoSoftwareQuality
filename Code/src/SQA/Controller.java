package SQA;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Controller {

    Scanner scan = new Scanner(System.in);
    ArrayList<Rubric> rubrics = new ArrayList<>();

    public Controller()
    {

    }



    public Rubric addRubric(String name)
    {
        Rubric rubric = new Rubric(name);
        rubrics.add(rubric);
        System.out.println("Creating rubric......");
        return rubric;
    }



    public String addCriterion(String rubric , String criterion)
    {
        String response = "" ;
        boolean found = false ;

        for(Rubric rub : rubrics)
        {
            if(rub.title.equalsIgnoreCase(rubric)) {
                Criterion criteria = new Criterion(criterion,0);
                rub.getCriteria().add(criteria);
                found = true ;
                response = "Criteria Added" ;
            }
        }

        if(!found){
            response = "Rubric not found" ;
        }


        return response ;
    }

    public void listAllRubrics()
    {
        if(rubrics.size() != 0)
        {
            System.out.println("**** All Rubrics ****");
            for(Rubric rubric:rubrics) {

                System.out.println(rubric.getTitle());
                if(rubric.getCriteria().isEmpty())
                {
                    System.out.println("No Criterion defined");
                }
                else
                {
                    for (Criterion cr : rubric.getCriteria()) {
                        System.out.println(cr.title);
                    }
                }

            }
        }
        else
        {
            System.out.println("No Rubrics on system");
        }



    }


    public Rubric getRubricbyName(String name)
    {
        Rubric rubric = null ;

        for (Rubric rub : rubrics ) {
            if(name.equalsIgnoreCase(rub.getTitle()))
            {
                rubric = rub ;
            }
        }

        return  rubric ;
    }







}
