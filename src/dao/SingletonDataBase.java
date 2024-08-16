package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingletonDataBase {

    //URL de connexion à la base de données etab_db
    private final static String URL = "jdbc:mysql://localhost:3306/etab_db";
    // Nom d'utilisateur
    private final static String USERNAME = "root";
    //Mot de pass
    private final static String PASSWORD = "";

    static Connection connection;

    private SingletonDataBase() {
        // Création d'une nouvelle connexion
        try {
            connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public static Connection getInstance() {
        try {
            if (connection == null || connection.isClosed()) {
                new SingletonDataBase();
                System.out.println("Nouvelle connexion à la base de données créée.");
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la vérification de l'état de la connexion : " + e.getMessage());
        }
        return connection;
    }
}
