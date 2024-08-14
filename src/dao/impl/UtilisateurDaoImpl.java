package dao.impl;

import dao.IUtilisateurDao;
import dao.SingletonDataBase;
import models.Utilisateur;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UtilisateurDaoImpl implements IUtilisateurDao {

    private static String QUERY_GET_USER_BY_PSEUDO_AND_PASSWORD = "SELECT * FROM Utilisateur WHERE pseudo = ? AND motDePasse = ?";
    @Override
    public Utilisateur getUser(String pseudo, String motDePasse) throws SQLException {
        PreparedStatement statement = SingletonDataBase.getInstance().prepareStatement(QUERY_GET_USER_BY_PSEUDO_AND_PASSWORD);
        statement.setString(1, pseudo);
        statement.setString(2, motDePasse);
        ResultSet resultSet = statement.executeQuery();
        Utilisateur utilisateur = null;


        if (resultSet.next()){
            int id_utilisateur = resultSet.getInt("id_utilisateur");
            pseudo = resultSet.getString("pseudo");
            motDePasse = resultSet.getString("motDePasse");
            utilisateur = new Utilisateur(id_utilisateur,pseudo,motDePasse);
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
