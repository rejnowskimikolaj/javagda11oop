package ex2students;

import java.util.Optional;
import java.util.Scanner;

public class DziekanatTUI {

    private Scanner intScanner = new Scanner(System.in);
    private Scanner stringScanner = new Scanner(System.in);

    private Dziekanat dziekanat = new Dziekanat();

    public void start(){

        int inputNumber=0;

        while(inputNumber!=9){
            printMenu();
            inputNumber = intScanner.nextInt();

            switch(inputNumber){
                case 1: onAddStudentSelected();
                break;
                case 2: onGetStudentSelected();
                break;
                case 3: onGetStudentsWithAvgLessThanSelected();
                break;
                case 4: onGetStudentsOnYearSelected();
                break;
                case 5: onDeleteStudentSelected();
                break;
                case 6:
                    onPrintAllStudentsSelected();
                    break;
            }
        }

    }

    private void onPrintAllStudentsSelected() {

        System.out.println(dziekanat.getAllStudents());
    }

    private void onDeleteStudentSelected() {

        System.out.println("Give index number:");
        String indexNumber = stringScanner.nextLine();

        boolean result = dziekanat.removeStudentWithIndexNo(indexNumber);
        if(result){
            System.out.println("Student deleted!");
        }
        else{
            System.out.println("Student doesnt exist");
        }
    }

    private void onGetStudentsOnYearSelected() {
        System.out.println("Give year:");
        int year = intScanner.nextInt();
        System.out.println(dziekanat.getStudentsOnYear(year));
    }


    private void onGetStudentsWithAvgLessThanSelected() {
        System.out.println("Give average:");
        double avg = intScanner.nextDouble();
        System.out.println(dziekanat.getStudentsWithAvgLessThan(avg));
    }

    private void onGetStudentSelected() {

        System.out.println("Give index number:");
        String indexNumber = stringScanner.nextLine();
        Optional<Student> studentOptional = dziekanat.getStudentWithIndexNo(indexNumber);
        if(studentOptional.isPresent()) {
            System.out.println(studentOptional.get());
        }
        else{
            System.out.println("Student doesnt exist");
        }
    }

    private void onAddStudentSelected() {

        System.out.println("Give index:");
        String index = stringScanner.nextLine();
        System.out.println("Give first name:");
        String firstName = stringScanner.nextLine();
        System.out.println("Give last name:");
        String lastName = stringScanner.nextLine();
        System.out.println("Give average:");
        double markAvg = intScanner.nextDouble();
        System.out.println("Give year of study");
        int year = intScanner.nextInt();

        Student student = new Student(index,firstName,lastName,markAvg,year);

        dziekanat.addStudent(student);

    }

    private void printMenu() {
        System.out.println("What do you want?");
        System.out.println("1.Add student");
        System.out.println("2. Get student");
        System.out.println("3. Get students with avg less than");
        System.out.println("4. Get students on year");
        System.out.println("5. Delete students");
        System.out.println("6. Print all students");
        System.out.println("9. Exit");
    }
}
