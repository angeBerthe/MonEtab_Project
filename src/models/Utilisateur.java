package models;

import dao.SingletonDataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

    private static final String QUERY_VERIFIER_UTILISATEUR = "SELECT COUNT(*) FROM Utilisateur WHERE pseudo = ?";
    private static final String QUERY_AJOUTER_UTILISATEUR = "INSERT INTO Utilisateur (pseudo, motDePasse, dateCreation) VALUES (?, ?, NOW())";


    public static void saveUser() {
        try (Connection connexion = SingletonDataBase.getInstance()) {

            // Vérifier si l'utilisateur existe déjà
            try (PreparedStatement instructionVerifier = connexion.prepareStatement(QUERY_VERIFIER_UTILISATEUR)) {
                instructionVerifier.setString(1, "admin");

                try (ResultSet resultat = instructionVerifier.executeQuery()) {
                    if (resultat.next() && resultat.getInt(1) > 0) {
                        System.out.println("Utilisateur existe déjà.");
                        return;
                    }
                }
            }

            // Ajouter l'utilisateur si non existant
            try (PreparedStatement instructionAjouter = connexion.prepareStatement(QUERY_AJOUTER_UTILISATEUR)) {
                instructionAjouter.setString(1, "admin");
                instructionAjouter.setString(2, "admin");
                instructionAjouter.executeUpdate();
                System.out.println("Utilisateur 'admin' ajouté avec succès.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }}
