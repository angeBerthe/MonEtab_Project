package dao.impl;

import dao.IUtilisateurDao;
import dao.SingletonDataBase;
import models.Utilisateur;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UtilisateurDaoImpl implements IUtilisateurDao {

    private static String QUERY_GET_USER_BY_PSEUDO_AND_PASSWORD = "SELECT * FROM utilisateur WHERE pseudo = ? AND motDePasse = ?";
    @Override
    public Utilisateur getUser(String pseudo, String motDePasse) throws SQLException {

            Connection connection = SingletonDataBase.getInstance();

            if (connection == null || connection.isClosed()) {
                System.out.println("Tentative de réouverture de la connexion...");
                connection = SingletonDataBase.getInstance(); // Tentative de réouverture
                if (connection == null || connection.isClosed()) {
                    throw new SQLException("La connexion à la base de données est fermée ou non disponible.");
                }
            }

            Utilisateur utilisateur = null;

            try (PreparedStatement statement = connection.prepareStatement(QUERY_GET_USER_BY_PSEUDO_AND_PASSWORD)) {
                statement.setString(1, pseudo);
                statement.setString(2, motDePasse);

                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        int id = resultSet.getInt("id_utilisateur");
                        pseudo = resultSet.getString("pseudo");
                        motDePasse = resultSet.getString("motDePasse");
                        utilisateur = new Utilisateur(id, pseudo, motDePasse);
                    }
                }
            }

            return utilisateur;
        }


    @Override
    public Utilisateur updateUser(String pseudo, String motDePasse) {
        return null;
    }

    @Override
    public void deleteCompte(String pseudo, String motDePasse) {

    }

    @Override
    public List<Utilisateur> listeUtilisateur() {
        return null;
    }
}
