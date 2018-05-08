package ex1onlypatients;

public class Main {
    public static void main(String[] args) {

        //tworzymy registration desk. w tym przypadku nie dodaje zadnych nowych pacjentow
        //jesli w pliku patients.txt sa jacys pacjenci, to aplikacja wydrukuje ich
        RegistrationDesk registrationDesk = new RegistrationDesk();
        registrationDesk.printPatients();

    }
}
