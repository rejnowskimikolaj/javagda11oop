package ex1onlypatients;

import java.time.LocalDate;

public class Patient {

    private String firstName;
    private String lastName;
    private Gender gender;
    private String peselId;
    private LocalDate dateBirth;


    public Patient(String firstName, String lastName, Gender gender, String peselId, LocalDate dateBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.peselId = peselId;
        this.dateBirth = dateBirth;


    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public String getPeselId() {
        return peselId;
    }

    public LocalDate getDateBirth() {
        return dateBirth;
    }

    @Override
    public String toString() {
        return "ex1onlypatients.Patient{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender=" + gender +
                ", peselId='" + peselId + '\'' +
                ", dateBirth=" + dateBirth +
                '}';
    }

    //metoda, ktora zwraca reprezentacje pacjenta w postaci lini, ktora mozemy zapisac do pliku
    public String toFileLine(){
        String SEPARATOR  = FileOperator.SEPARATOR;
        String line = "";
        //kazde pole pochodzace z obiektu zapisujemy w linii oddzielając separatorem
        line+=firstName + SEPARATOR;
        line += lastName + SEPARATOR;
        line += gender + SEPARATOR;
        line+=dateBirth+SEPARATOR;
        line += peselId +SEPARATOR;
        return line;
    }
}
