package SQA;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Controller {

    // Arrays to hold the Rubric and Graded Student Data
    ArrayList<Rubric> rubrics = new ArrayList<>();
    ArrayList<Grade> grades = new ArrayList<>();



    // Empty Constructor for initialization
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


    // Retrieves a Grade by the name of student given
    public ArrayList<Grade> getGradesByRubricName(String name)
    {
        ArrayList<Grade> foundGrades = new ArrayList<>();

        for (Grade grade : grades) {

            if(grade.getRubric().title.equalsIgnoreCase(name))
                foundGrades.add(grade);
        }

        return foundGrades ;
    }

    // Gets the average score across all graded Students
    public double getRubricScoreAverage(String name)
    {
        int sum = 0 ;
        int count = 0 ;
        int avg = 0 ;


        for (Grade grade : grades) {
            if(grade.getRubric().title.equalsIgnoreCase(name))
            {
                for (Criterion criterion : grade.getRubric().getCriteria())
                {
                    sum += criterion.score;
                    count ++ ;
                }
            }

        }

        if(sum != 0 && count != 0)
        {
            avg = sum/count ;
        }


        return avg ;
    }


    // Get the lowest score given to a student in a Rubric
    public int getRubricMin(String name)
    {
        List<Integer> entries = new ArrayList<>();

        for (Grade grade : grades)
        {
            if(grade.getRubric().title.equalsIgnoreCase(name))
            {
                for (Criterion criterion : grade.getRubric().getCriteria())
                {
                    entries.add(criterion.score);

                }
            }
        }

        return Collections.min(entries) ;
    }


    // Retrieve the highest score achieved in a specific Rubric
    public int getRubricMax(String name)
    {
        List<Integer> entries = new ArrayList<>();

        for (Grade grade : grades)
        {
            if(grade.getRubric().title.equalsIgnoreCase(name))
            {
                for (Criterion criterion : grade.getRubric().getCriteria())
                {
                    entries.add(criterion.score);
                }
            }

        }

        return Collections.max(entries);
    }


    // Get the Standard Deviation of all scores for a specific Rubric
    public double getRubricStdDev(String name)
    {
        List<Integer> numArray = new ArrayList<>();

        for (Grade grade : grades)
        {
            if(grade.getRubric().title.equalsIgnoreCase(name))
            {
                for (Criterion criterion : grade.getRubric().getCriteria())
                {
                    numArray.add(criterion.score);
                }
            }

        }

        double sum = 0.0, standardDeviation = 0.0;
        int length = numArray.size();

        for(double num : numArray) {
            sum += num;
        }

        double mean = sum/length;

        for(double num: numArray) {
            standardDeviation += Math.pow(num - mean, 2);
        }

        return Math.sqrt(standardDeviation/length);

    }


    // Get the average of all scores for a given Criteria
    public double getCriteriaAvg(String name)
    {
        int sum = 0 ;
        int count = 0 ;
        int avg = 0 ;

        for(Grade grade : grades)
        {
            for (Criterion criterion : grade.getRubric().getCriteria()) {

                if(criterion.title.equalsIgnoreCase(name))
                {
                   sum += criterion.score ;
                   count ++ ;
                }


            }
        }

        if(sum != 0 && count != 0)
        {
            avg = sum/count ;
        }


        return avg ;
    }


    // Get the minimum score given for a certain Criteria
    public int getCriterionMin(String name)
    {
        ArrayList<Integer> nums = new ArrayList<>();

        for(Grade grade : grades)
        {
            for (Criterion criterion : grade.getRubric().getCriteria()) {

                if(criterion.title.equalsIgnoreCase(name))
                {
                   nums.add(criterion.score);
                }
            }
        }


        return Collections.min(nums);
    }

    // Get the highest score given for a certain Criteria
    public int getCriterionMax(String name)
    {
        ArrayList<Integer> nums = new ArrayList<>();

        for(Grade grade : grades)
        {
            for (Criterion criterion : grade.getRubric().getCriteria()) {

                if(criterion.title.equalsIgnoreCase(name))
                {
                    nums.add(criterion.score);
                }
            }
        }


        return Collections.max(nums);
    }


    // Calculate the Standard Deviation for a scores for a given Criterion
    public double getCriterionStdDev(String name)
    {
        ArrayList<Integer> numArray = new ArrayList<>();

        for(Grade grade : grades)
        {
            for (Criterion criterion : grade.getRubric().getCriteria()) {

                if(criterion.title.equalsIgnoreCase(name))
                {
                    numArray.add(criterion.score);
                }
            }
        }

        double sum = 0.0, standardDeviation = 0.0;
        int length = numArray.size();

        for(double num : numArray) {
            sum += num;
        }

        double mean = sum/length;

        for(double num: numArray) {
            standardDeviation += Math.pow(num - mean, 2);
        }

        return Math.sqrt(standardDeviation/length);


    }














}
