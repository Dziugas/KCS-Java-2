package uzklausos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
                redagavimas();
                break;
            case 2:
                trynimas();
                 break;
        }
    }

    public void redagavimas() {
        System.out.println("Redaguosime lentelę. Pridėsime dar vieną studentą");
        Scanner sc = new Scanner(System.in);
                System.out.println("Įveskite vardą");
                String name = sc.next();
                System.out.println("Įveskite naują pavardę");
                String surname = sc.next();
                System.out.println("Įveskite naują emeilą");
                String email = sc.next();
                System.out.println("Įveskite naują telefono nr.");
                int phone = sc.nextInt();
                String insertTableSQL = "INSERT INTO `students`"
                        + "(`name`,`surname`,`email`,`phone`) VALUES"
                        + "(?,?,?,?)";
                try {
                    PreparedStatement preparedStatement = connection.prepareStatement(insertTableSQL);
                    preparedStatement.setString(1, name);
                    preparedStatement.setString(2, surname);
                    preparedStatement.setString(3, email);
                    preparedStatement.setInt(4, phone);
                    preparedStatement.executeUpdate();
                }
                catch (Exception klaida){
                }
        }


    public void trynimas(){
        System.out.println("Trinsime duomenis. Kurio studento įrašą norite išrinti? Įveskite studento ID");
     //   try{
      //      PreparedStatement preparedStatement = connection.prepareStatement()
      //  }
    }
}