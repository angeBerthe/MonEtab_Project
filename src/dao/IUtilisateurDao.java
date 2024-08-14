package dao;

import models.Utilisateur;

import java.sql.SQLException;
import java.util.List;

public interface IUtilisateurDao {
    public Utilisateur getUser (String pseudo, String motDePasse) throws SQLException;
    public Utilisateur updateUser(String pseudo, String motDePasse);
    public void deleteCompte(String pseudo, String motDePasse);
    public List<Utilisateur> listeUtilisateur();
}
