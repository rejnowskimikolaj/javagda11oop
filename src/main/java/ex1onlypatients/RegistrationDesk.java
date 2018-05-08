package ex1onlypatients;

import java.util.List;
import java.util.Optional;

public class RegistrationDesk {

    private List<Patient> patientList;

    public RegistrationDesk() {
        //w momencie stworzenia nowego ex1onlypatients.RegistrationDesk - ladujemy pacjentow z pliku (jesli istnieje)

        patientList = FileOperator.getPatientsFromFile();
    }


    //po dodaniu pacjenta "updatujemy" nasz plik "bazodanowy"
    public void addPatient(Patient patient){

        patientList.add(patient);
        saveToFile();
    }

    //metoda zwracajaca pacjenta o danym peselu
    public Optional<Patient> getPatient(String pesel){

        Patient result =null;
        //iterujemy sie przez liste pacjentow
        for (Patient patient : patientList) {
            //jesli znajdziemy pacjenta z danym peselem, ustawiamy go jako wynik i wychodzimy z petli
            if(patient.getPeselId().equals(pesel)) result = patient;
            break;
        }
        //jesli nie znajdziemy danego pacjenta, result jest nullem

        //zwracamy rezultat opakowany w optionala. uzywajac metody ofNullable mozemy zwrocic pustego
        //optionala, jesli result jest nullem
        return Optional.ofNullable(result);
    }

    //metoda, ktora zapisze wszystkich pacjentow z listy do pliku z pacjentami. plik zostanie nadpisany
    public void saveToFile(){
        FileOperator.saveToFile(patientList);
    }

    //metoda drukujaca wszystkich pacjentow w naszej liscie
    public void printPatients(){
        System.out.println(patientList);
    }
}
