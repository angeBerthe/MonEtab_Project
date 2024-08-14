package models;

import dao.SingletonDataBase;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Utilisateur {
    /**
     * Classe représentant un utilisateur dans le système.
     */
    private int id_utilisateur;
    private String pseudo;

    private String motDePasse;

    private Date dateCreation;

    private static List<Utilisateur> listeUtilisateurs = new ArrayList<>();

    public Utilisateur() {
    }

    public Utilisateur(int id_utilisateur, String pseudo, String motDePasse, Date dateCreation) {
        this.id_utilisateur = id_utilisateur;
        this.pseudo = pseudo;
        this.motDePasse = motDePasse;
        this.dateCreation = dateCreation;
    }

    public Utilisateur(int id_utilisateur, String pseudo, String motDePasse) {
        this.id_utilisateur = id_utilisateur;
        this.pseudo = pseudo;
        this.motDePasse = motDePasse;
    }


    public void saveUser() throws SQLException {

        try {
            String query = "INSERT INTO Utilisateur (pseudo, motDePasse, dateCreation) VALUES (?, ?, ?)";
            PreparedStatement statement = SingletonDataBase.getInstance().prepareStatement(query);

            // Obtenir la date et l'heure actuelles
            java.sql.Timestamp currentTimestamp = new java.sql.Timestamp(System.currentTimeMillis());

            statement.setString(1, "admin");
            statement.setString(2, "admin");
            statement.setTimestamp(3, currentTimestamp);

            statement.executeUpdate();
            System.out.println("Utilisateur ajouté avec succès.");
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'ajout de l'utilisateur : " + e.getMessage());
        }

}}
