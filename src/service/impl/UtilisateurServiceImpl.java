package service.impl;

import dao.IUtilisateurDao;
import dao.impl.UtilisateurDaoImpl;
import models.Utilisateur;
import service.IUtilisateurService;

import java.sql.SQLException;
import java.util.List;

public class UtilisateurServiceImpl implements IUtilisateurService {
    private IUtilisateurDao utilisateurDao;

    public UtilisateurServiceImpl() {
        this.utilisateurDao = new UtilisateurDaoImpl();
    }


    @Override
    public boolean authentification(String pseudo, String motDePasse) throws SQLException {
        Utilisateur user = utilisateurDao.getUser(pseudo,motDePasse);
        return user!=null;

    }

    @Override
    public boolean getUser(String pseudo, String motDePasse) throws SQLException {
        return false;
    }

    @Override
    public boolean updateUser(String pseudo, String motDePasse) {
        return false;
    }

    @Override
    public void deleteCompte(String pseudo, String motDePasse) {

    }

    @Override
    public List<Utilisateur> listeUtilisateur() {
        return null;
    }
}
