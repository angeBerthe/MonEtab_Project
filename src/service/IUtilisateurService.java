package service;

import models.Utilisateur;

import java.sql.SQLException;
import java.util.List;

public interface IUtilisateurService {

    boolean authentification(String pseudo, String motDePasse) throws SQLException;

    public boolean getUser (String pseudo, String motDePasse) throws SQLException;
    public boolean updateUser(String pseudo, String motDePasse);
    public void deleteCompte(String pseudo, String motDePasse);
    public List<Utilisateur> listeUtilisateur();
}
