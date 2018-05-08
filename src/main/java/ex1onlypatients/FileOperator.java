package ex1onlypatients;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

public class FileOperator {

    //separator będzie służyc do oddzielania pol od siebie, zeby mozna linię zesplitowac po jednym znaku
    public static final String SEPARATOR = ";";
    public static final String FILEPATH = "src/main/resources/patients.txt";

    //metoda zwracajaca liste pacjentow zaladowanych z pliku tekstowego (naszej bazy danych)
    public static List<Patient> getPatientsFromFile(){

        List<Patient> patients = new ArrayList<>();
        try {

            FileReader fileReader = new FileReader(FILEPATH);
            Scanner scanner = new Scanner(fileReader);

            while(scanner.hasNextLine()){

                //czytamy linie po lini
                String line = scanner.nextLine();

                //kazda linie parsujemy na pacjenta
                Patient patient = getPatientFromLine(line);
                //..i dodajemy do naszej listy wynikowej
                patients.add(patient);

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return patients;
    }

    //metoda parsujaca linie z pliku i zwracajaca instancje obiektu typu pacjent.
    private static Patient getPatientFromLine(String line) {

        //splitujemy linie po separatorze wynikiem splitowania bedzie tablica stringow
        String [] splits = line.split(SEPARATOR);
        //kazdy element tej tablicy jest polem naszego nowego obiektu
        //wazne, zeby zachowac te sama kolejnosc
        String firstName = splits[0];
        String lastName = splits[1];
        String genderString = splits[2];
        Gender gender;
        //tutaj musimy zamienic stringa na enuma
        if(genderString.equals("MALE")){
            gender = Gender.MALE;
        }
        else if(genderString.equals("FEMALE")){
            gender = Gender.FEMALE;
        }
        else gender = Gender.UNKNOWN;

        LocalDate localDateTime = LocalDate.parse(splits[3]);
        String pesel = splits[4];

        return new Patient(firstName,lastName,gender,pesel,localDateTime);
    }

    //metoda zapisujaca liste pacjentow do pliku. jesli plik juz istnieje, to wartosci zostana nadpisane
    public static void saveToFile(List<Patient> patients){

        try {
            FileWriter fileWriter = new FileWriter(FILEPATH,false);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            //dla kazdego pacjenta w liscie "doklejamy" nowa linie w pliku
            for (Patient patient : patients) {

                //kazda linia bedzie reprezentowac obiekt w naszej liscie
                printWriter.println(patient.toFileLine());
            }

            //nie zapominajmy zamknac pliku
            printWriter.close();
        } catch (IOException e) {

            e.printStackTrace();
        }
    }

}
