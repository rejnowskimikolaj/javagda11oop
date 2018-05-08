package ex2students;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Dziekanat {

    private List<Student> studentList;

    public Dziekanat() {

        studentList = new ArrayList<>();
    }

    public void addStudent(Student student) {
        studentList.add(student);
    }

    public Optional<Student> getStudentWithIndexNo(String indexNo) {
        //return studentList.stream().filter(x->x.getIndexNumber().equals(indexNo)).findAny();

        Student result = null;

        for (Student student : studentList) {

            if (student.getIndexNumber().equals(indexNo)) result = student;
            break;
        }

        return Optional.ofNullable(result);
    }

    public List<Student> getStudentsWithAvgLessThan(double avg) {

        //return studentList.stream().filter(x->x.getMarkAvg()<avg).collect(Collectors.toList());

        List<Student> result = new ArrayList<>();

        for (Student student : studentList) {

            if (student.getMarkAvg() < avg) result.add(student);
        }

        return result;
    }

    public boolean removeStudentWithIndexNo(String indexNo) {

        for (Student student : studentList) {

            if (student.getIndexNumber().equals(indexNo)) {
                studentList.remove(student);
                return true;
            }
        }
        return false;
    }

    public List<Student> getStudentsOnYear(int year) {
        List<Student> result = new ArrayList<>();

        for (Student student : studentList) {

            if (student.getYearOfStudy() == year) result.add(student);
        }

        return result;
    }

    public Student getStudentWithAvgIncremented(Student student){
        Student newStudent = new Student(student.getIndexNumber(),student.getFirstName(),student.getLastName(),student.getMarkAvg()+1,student.getYearOfStudy());
        return newStudent;
    }

}
