package SQA;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradeDriver
{
    Scanner scan = new Scanner(System.in);

    // Controller class which will store the grade and rubric data and contains all the functionality
    // associated with them
    Controller c = new Controller();


    public StudentGradeDriver()
    {

        boolean running = true ;


        // Initializing new Rubrics , Criteria and Grades
        Rubric init = new Rubric("Code");
        init.criteria.add(new Criterion("Design",0));
        init.criteria.add(new Criterion("Implementation",0));
        init.criteria.add(new Criterion("Documentation",0));
        init.criteria.add(new Criterion("Testing",0));

        c.rubrics.add(init);

        Rubric initRubric = new Rubric("Code");
        ArrayList<Criterion> initGrade =  new ArrayList<Criterion>();
        initGrade.add(new Criterion("Design",2));
        initGrade.add(new Criterion("Implementation",4));
        initGrade.add(new Criterion("Testing",4));
        initGrade.add(new Criterion("Documentation",2));
        initRubric.setCriteria(initGrade);


        c.grades.add(new Grade("Stephen Byrne",initRubric));


        // Looping menu which is the root directory for all features in the system
        while (running)
        {
            System.out.println("(1) New Rubric");
            System.out.println("(2) Add Criterion");
            System.out.println("(3) List All Rubrics");
            System.out.println("(4) Grade a Student");
            System.out.println("(5) List All Grades ");
            System.out.println("(6) Get Grades by Rubric Name");
            System.out.println("(7) Summarize Rubric");
            System.out.println("(8) Summarize Criterion");
            System.out.println("Please enter the number of the directory you would like to visit ");
            System.out.println("type 'exit' to leave");
            String dir = scan.nextLine();

            // If user enters exit, the system closes
            if(dir.equalsIgnoreCase("exit"))
            {
                break;
            }


             if(!c.validateString(dir))
             {
                 int choice = Integer.parseInt(dir);

                 // The appropriate function in the Controller class is called based on the users selection
                 switch (choice) {
                     case 1 -> {
                         // Create a new Rubric
                         System.out.println("** Rubric Builder **");
                         System.out.println("Please enter the name of the rubric");
                         String name = scan.nextLine();
                         c.addRubric(name);
                     }
                     case 2 -> {
                         // Add a criterion to a Rubric
                         System.out.println("** Rubric Manager **");
                         System.out.println("Enter the name of the Rubric you want to edit");

                         String rName = scan.nextLine();

                         System.out.println("Enter the name of the Criterion");
                         String cName = scan.nextLine();

                         System.out.println(c.addCriterion(rName,cName));
                     }
                     case 3 -> {
                         // Displays a given list of all the Rubrics
                         ArrayList<Rubric> rubrics = c.listAllRubrics();

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
                                         System.out.println("- " + cr.title);
                                     }
                                 }

                             }
                         }
                         else
                         {
                             System.out.println("No Rubrics on system");
                         }
                     }
                     case 4 ->{
                         // Retrieves a rubric by name and uses it as a template to Grade a given student
                         System.out.println("** Grading Manager **");
                         System.out.println("Please enter a Students name");
                         String studentName = scan.nextLine();
                         Rubric gradeRubric = new Rubric("Grading");

                         System.out.println("Please enter the name of the Rubric you would like to use");
                         String rName = scan.nextLine();

                         Rubric rubric = c.getRubricbyName(rName);

                         if(rubric != null)
                         {
                             System.out.println("Rubric Found");

                             for(Criterion criterion : rubric.getCriteria())
                             {
                                 String score = "" ;
                                 do {
                                     System.out.println("Please provide a score between 1-5");
                                     System.out.println(criterion.title);
                                     score = scan.nextLine();

                                     if (!c.validateScore(score))
                                     {
                                         System.out.println("Invalid Score");
                                     }

                                 } while (!c.validateScore(score));


                                     gradeRubric.getCriteria().add(new Criterion(criterion.title,Integer.parseInt(score)));
                             }


                             c.grades.add(new Grade(studentName,gradeRubric));

                         }
                         else{
                             System.out.println("Rubric not found, please try again");
                         }

                     }
                     case 5 -> {
                         ArrayList<Grade> grades = c.listAllGrades();

                         if(!grades.isEmpty())
                         {
                             // Formats and Displays all of the existing student Grades
                             for(Grade grade : grades)
                             {
                                 System.out.println("Student :  " +grade.name);
                                 System.out.println("** Rubric  " +grade.rubric.title + " **");
                                 for(Criterion criterion : grade.getRubric().getCriteria())
                                 {
                                     System.out.println(criterion.title + "  :  " + criterion.score);
                                 }

                             }
                         }
                         else{
                             System.out.println("No Students have been graded yet");
                         }


                     }
                     case 6 -> {
                         // Retrieves a Rubric by a given name
                         System.out.println("Enter the name of the Rubric you are looking for");
                         String rName = scan.nextLine();

                         ArrayList<Grade> found = c.getGradesByRubricName(rName);

                         // Displays the Rubric if it is found and an error otherwise
                         if(found.isEmpty())
                         {
                             System.out.println("No Students Graded Yet");
                         }
                         else {
                             for (Grade grade : found) {
                                 System.out.println("Student Name : " + grade.name);
                                 for(Criterion criterion : grade.getRubric().getCriteria())
                                 {
                                     System.out.println(criterion.title + " : " + criterion.score);
                                 }
                             }
                         }
                     }
                     case 7 -> {
                            // Summarises a Rubric by its given name
                         if(!c.listAllGrades().isEmpty())
                         {
                             System.out.println("Enter the name of the Rubric you wish to summarise");
                             String rName = scan.nextLine();

                             if(c.getRubricbyName(rName) != null)
                             {
                                 System.out.println("**** Rubric Summary ****");
                                 System.out.println("Average : " + c.getRubricScoreAverage(rName));
                                 System.out.println("Minimum score : " + c.getRubricMin(rName));
                                 System.out.println("Maximum score : " +c.getRubricMax(rName));
                                 System.out.println("Standard Deviation : " +c.getRubricStdDev(rName));
                                 System.out.println("************************");
                             }
                         }
                         else{
                             System.out.println("No students have been graded yet");
                         }

                     }
                     case 8 -> {
                         // Summarizes a Criterion by its given name
                         if(!c.listAllGrades().isEmpty())
                         {
                             boolean found = false ;
                             System.out.println("Enter the name of the Criterion you wish to summarise");
                             String cName = scan.nextLine();

                             for (Rubric rubric : c.listAllRubrics()) {
                                 for (Criterion criterion : rubric.getCriteria()) {
                                     if(criterion.title.equalsIgnoreCase(cName))
                                     {
                                        found = true ;
                                        break;
                                     }
                                 }
                             }

                             // If criterion exists then the summary is displayed, error if not
                             if (found)
                             {
                                 System.out.println("**** Criterion Summary ****");
                                 System.out.println("Criterion : " + cName);
                                 System.out.println("Average : " + c.getCriteriaAvg(cName));
                                 System.out.println("Minimum score : " + c.getCriterionMin(cName));
                                 System.out.println("Maximum score : " +c.getCriterionMax(cName));
                                 System.out.println("Standard Deviation : " +c.getCriterionStdDev(cName));
                                 System.out.println("************************");
                             }
                             else{
                                 System.out.println("Criterion not found");
                             }

                         }
                         else
                         {
                             System.out.println("No students have been graded");
                         }

                     } // 0 will also close the system
                     case 0 -> running = false;
                     default -> System.out.println("Command not recognised");
                 }

             }
             else{
                 System.out.println("Command not recognised");
             }


        }





    }

    public static void main(String[] args)
    {
        new StudentGradeDriver();
    }





}
