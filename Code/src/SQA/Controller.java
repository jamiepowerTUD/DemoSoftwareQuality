package SQA;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Controller {

    ArrayList<Rubric> rubrics = new ArrayList<>();
    ArrayList<Grade> grades = new ArrayList<>();



    public Controller()
    {

    }


    // Method receives a name of a Rubric and adds it to a list of Rubrics
    public Rubric addRubric(String name)
    {
        Rubric rubric = new Rubric(name);
        rubrics.add(rubric);
        return rubric;
    }

    public Grade addGrade(String name, Rubric rubric)
    {
        Grade grade = new Grade(name,rubric);
        grades.add(grade);
        return grade ;
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


    // Returns a list of all existing Rubrics
    public ArrayList<Rubric> listAllRubrics()
    {
        return rubrics ;
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



    // Validates whether a users input is a String or not
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
            } catch(NumberFormatException ignored){}



            try {
                Double.parseDouble(word);
                result = false ;
            } catch(NumberFormatException ignored){ }
        }


        return  result ;
    }



    // Validates that a score given to grade a Student is a number between 1-5
    public Boolean validateScore(String input)
    {
        boolean valid = true ;

        if (!validateString(input))
        {
            int score = 0 ;
            try {
                score = Integer.parseInt(input);
            } catch (NumberFormatException ignored){}


            if(score < 1 || score > 5)
            {
                valid = false ;
            }

        }
        else{
            valid = false ;
        }


        return valid ;
    }


    // Returns a list of all existing student Grades
    public ArrayList<Grade> listAllGrades()
    {
        return grades ;
    }





}
