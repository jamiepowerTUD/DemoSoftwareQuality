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
            System.out.println("Please enter the directory you would like to visit ");
            System.out.println("type 'exit' to return");
            String dir = scan.nextLine();
            int choice = -1 ;

            try {
                choice = Integer.parseInt(dir);
            } catch (NumberFormatException e)
            {
                if(dir.equalsIgnoreCase("exit"))
                {
                    break;
                }
                else
                {
                    System.out.println("Error - please enter a number");
                }
            }


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

                    System.out.println(c.addCriterion(rName,cName));
                }
                case 3 -> c.listAllRubrics();
                case 0 -> running = false;
                default -> System.out.println("Command not recognised");
            }


        }





    }

    public static void main(String[] args)
    {
        new StudentGradeDriver();
    }





}
