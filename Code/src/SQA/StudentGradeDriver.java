package SQA;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradeDriver
{
    Scanner scan = new Scanner(System.in);

    Controller c = new Controller();





    public StudentGradeDriver()
    {

        boolean running = true ;


        while (running)
        {
            System.out.println("(1) New Rubric");
            System.out.println("(2) Add Criterion");
            System.out.println("(3) List All Rubrics");
            System.out.println("(4) Grade a Student");
            System.out.println("(5) List All Grades ");
            System.out.println("Please enter the directory you would like to visit ");
            System.out.println("type 'exit' to return");
            String dir = scan.nextLine();

            if(dir.equalsIgnoreCase("exit"))
            {
                break;
            }


             if(!c.validateString(dir))
             {
                 int choice = Integer.parseInt(dir);

                 switch (choice) {
                     case 1 -> {
                         System.out.println("** Rubric Builder **");
                         System.out.println("Please enter the name of the rubric");
                         String name = scan.nextLine();
                         c.addRubric(name);
                     }
                     case 2 -> {
                         System.out.println("** Rubric Manager **");
                         System.out.println("Enter the name of the Rubric you want to edit");

                         String rName = scan.nextLine();

                         System.out.println("Enter the name of the Criterion");
                         String cName = scan.nextLine();

                         System.out.println("Creating rubric......");
                         System.out.println(c.addCriterion(rName,cName));
                     }
                     case 3 -> {
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
                     case 4 ->{
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

                     }
                     case 5 -> {
                         ArrayList<Grade> grades = c.listAllGrades();

                         if(!grades.isEmpty())
                         {
                             // Formats and Displays all of the existing student Grades
                             for(Grade grade : grades)
                             {
                                 System.out.println("Student :  " +grade.name);
                                 System.out.println("** Topic  " +grade.rubric.title + " **");
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
