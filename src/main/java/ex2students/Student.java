package ex2students;

public class Student {

    private String indexNumber;
    private String firstName;
    private String lastName;
    private double markAvg;
    private int yearOfStudy;

    public Student(String indexNumber, String firstName, String lastName, double markAvg, int yearOfStudy) {
        this.indexNumber = indexNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.markAvg = markAvg;
        this.yearOfStudy = yearOfStudy;
    }

    public String getIndexNumber() {
        return indexNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public double getMarkAvg() {
        return markAvg;
    }

    public int getYearOfStudy() {
        return yearOfStudy;
    }

    public void setIndexNumber(String indexNumber) {
        this.indexNumber = indexNumber;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setMarkAvg(double markAvg) {
        this.markAvg = markAvg;
    }

    public void setYearOfStudy(int yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }

    @Override
    public String toString() {
        return "Student{" +
                "indexNumber='" + indexNumber + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", markAvg=" + markAvg +
                ", yearOfStudy=" + yearOfStudy +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (Double.compare(student.markAvg, markAvg) != 0) return false;
        if (yearOfStudy != student.yearOfStudy) return false;
        if (indexNumber != null ? !indexNumber.equals(student.indexNumber) : student.indexNumber != null) return false;
        if (firstName != null ? !firstName.equals(student.firstName) : student.firstName != null) return false;
        return lastName != null ? lastName.equals(student.lastName) : student.lastName == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = indexNumber != null ? indexNumber.hashCode() : 0;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        temp = Double.doubleToLongBits(markAvg);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + yearOfStudy;
        return result;
    }
}
