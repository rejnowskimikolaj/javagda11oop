package ex2students;

public class Main {
    public static void main(String[] args) {

        Dziekanat dziekanat = new Dziekanat();
        Student student1 = new Student("123131","Mikolaj","Rej",3.9,1);
        Student student2 = new Student("123132","Boby","Dylan",2.9,2);
        Student student3 = new Student("123133","Roger","Waters",5,2);
        Student student4 = new Student("123134","Clay","David",3.8,3);

        dziekanat.addStudent(student1);
        dziekanat.addStudent(student2);
        dziekanat.addStudent(student3);
        dziekanat.addStudent(student4);

        System.out.println(dziekanat.getStudentsOnYear(2));
        System.out.println(dziekanat.getStudentsWithAvgLessThan(3.9));
        System.out.println(dziekanat.getStudentsOnYear(2));
        System.out.println(dziekanat.getStudentWithIndexNo("123131").get());

    }
}
