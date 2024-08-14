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

    /**
     * Constructeur avec paramètres de la classe Eleve.
     *
     * @param id Identifiant unique de l'élève
     * @param dateDeNaissance Date de naissance de l'élève
     * @param ville Ville de résidence de l'élève
     * @param prenom Prénom de l'élève
     * @param nom Nom de l'élève
     * @param telephone Numéro de téléphone de l'élève
     * @param classe Classe de l'élève
     * @param matricule Matricule de l'élève
     */
    public Eleve(int id, Date dateDeNaissance, String ville, String prenom, String nom, String telephone, String classe, String matricule) {
        super(id, dateDeNaissance, ville, prenom, nom, telephone);
        this.classe = classe;
        this.matricule = matricule;
    }

    /**
     * Obtient la classe de l'élève.
     *
     * @return La classe de l'élève
     */
    public String getClasse() {
        return classe;
    }

    /**
     * Définit la classe de l'élève.
     *
     * @param classe La nouvelle classe de l'élève
     */
    public void setClasse(String classe) {
        this.classe = classe;
    }

    /**
     * Obtient le matricule de l'élève.
     *
     * @return Le matricule de l'élève
     */
    public String getMatricule() {
        return matricule;
    }

    /**
     * Définit le matricule de l'élève.
     *
     * @param matricule le nouveau matricule de l'élève
     */
    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    /**
     * Ajoute un nouvel élève à la liste des élèves.
     *
     * @param eleve  à ajouter
     * @return L'élève ajouté
     */

}
