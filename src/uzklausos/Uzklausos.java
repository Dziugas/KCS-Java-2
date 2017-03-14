package uzklausos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

/**
 * Created by User on 2017-03-14.
 */
public class Uzklausos {
    private Connection connection;
    public Uzklausos() {
        try {
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/kcs",
                    "root",
                    "");
        }
        catch (Exception klaida){
            System.out.println(klaida);
        }
    }
    public void pasisveikink(){
        System.out.println("Sveikas, galėsime lenteles koreguoti arba ištrinti");
    }

    public void paklausk(){
        System.out.println("Pasirink ką norėsi daryti. Spausk '1', jei koreguoti, '2', jei trinti");
    }

    public void nuspresk(){
        Scanner sc= new Scanner(System.in);
        int pasirinkimas = sc.nextInt();
        switch(pasirinkimas){
            case 1:
                System.out.println("Koreguosime lentele. Kurio stulpelio duomenis norite keisti?");
                break;
            case 2:
                System.out.println("Trinsime duomenis. Kurį įrašą norite išrinti?");
                break;
        }
    }
}