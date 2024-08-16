package models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Classe représentant un élève dans le système scolaire.
 * Hérite de la classe Personne et implémente l'interface IEleveDao.
 */
public class Eleve extends Personne {
    private String classe;
    private String matricule;
    public static List<Eleve> eleves = new ArrayList<>();

    /**
     * Constructeur par défaut de la classe Eleve.
     */
    public Eleve() { }


    public Eleve(int id, Date dateDeNaissance, String ville, String prenom, String nom, String telephone, String classe, String matricule) {
        super(id, dateDeNaissance, ville, prenom, nom, telephone);
        this.classe = classe;
        this.matricule = matricule;
    }

    public Eleve(Date dateDeNaissance, String ville, String prenom, String nom, String telephone, String classe, String matricule) {
    }


    public String getClasse() {
        return this.classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public String getMatricule() {
        return this.matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }



}
