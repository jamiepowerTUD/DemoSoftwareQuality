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



    // Method receives a name of a Rubric and adds it to a list of Rubrics
    public Rubric addRubric(String name)
    {
        Rubric rubric = new Rubric(name);
        rubrics.add(rubric);
        System.out.println("Creating rubric......");
        return rubric;
    }



    // Method receives the name of a Rubric,
    public String addCriterion(String rubric , String criterion)
    {
        String response = "" ;
        boolean found = false ;
        for(Rubric rub : rubrics)
        {
            if(rub.title.equalsIgnoreCase(rubric)) {
                if(rub.getCriteria().size() == 10)
                {
                    response = "Rubric Full" ;
                    found = true ;
                }
                else {
                        Criterion criteria = createCriterion(criterion);
                        rub.getCriteria().add(criteria);
                        found = true ;
                        response = "Criteria Added" ; }
            }
        }
        if(!found){
            response = "Rubric not found" ;
        }
        return response ;
    }


    // Lists all existing Rubrics with their criterion
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

    // Takes the name of a rubric and returns it if found, null if not
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


    // Simple instantiation method to create a Criterion and return it
    public Criterion createCriterion(String name)
    {
        return new Criterion(name,0);
    }


    public boolean validateString(String word)
    {
        boolean result = true ;

        if (word.isEmpty())
            result = false ;
        else
        {
            try {
                Integer.parseInt(word);
                result = false ;
            } catch(NumberFormatException e){

            }

            try {
                Double.parseDouble(word);
                result = false ;
            } catch(NumberFormatException e){
            }
        }


        return  result ;
    }





}
