package models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Classe représentant un professeur dans le système scolaire.
 * Hérite de la classe Personne et implémente les interfaces IProfesseurDao et service.IEducation.
 */
public class Professeur extends Personne  {
    private Boolean vacant;
    private String matiereEnseigne;
    private String prochainCours;
    private String sujetProchaineReunion;


    public static List<Professeur> professeurs = new ArrayList<>();

    /**
     * Constructeur par défaut de la classe Professeur.
     */
    public Professeur() {
    }

    /**
     * Constructeur avec paramètres de la classe Professeur.
     *
     * @param id Identifiant unique du professeur
     * @param dateDeNaissance Date de naissance du professeur
     * @param ville Ville de résidence du professeur
     * @param prenom Prénom du professeur
     * @param nom Nom du professeur
     * @param telephone Numéro de téléphone du professeur
     * @param vacant Indique si le professeur est vacant
     * @param matiereEnseigne Matière enseignée par le professeur
     * @param prochainCours Prochain cours du professeur
     * @param sujetProchaineReunion Sujet de la prochaine réunion du professeur
     */
    public Professeur(int id, Date dateDeNaissance, String ville, String prenom, String nom, String telephone, Boolean vacant, String matiereEnseigne, String prochainCours, String sujetProchaineReunion) {
        super(id, dateDeNaissance, ville, prenom, nom, telephone);
        this.vacant = vacant;
        this.matiereEnseigne = matiereEnseigne;
        this.prochainCours = prochainCours;
        this.sujetProchaineReunion = sujetProchaineReunion;
    }

    /**
     * Obtient le statut de vacance du professeur.
     *
     * @return true si le professeur est vacant, false sinon
     */
    public Boolean getVacant() {
        return vacant;
    }

    /**
     * Définit le statut de vacance du professeur.
     *
     * @param vacant Le nouveau statut de vacance
     */
    public void setVacant(Boolean vacant) {
        this.vacant = vacant;
    }

    /**
     * Obtient la matière enseignée par le professeur.
     *
     * @return La matière enseignée
     */
    public String getMatiereEnseigne() {
        return matiereEnseigne;
    }


    /**
     * Définit la matière enseignée par le professeur.
     *
     * @param matiereEnseigne La nouvelle matière enseignée
     */
    public void setMatiereEnseigne(String matiereEnseigne) {
        this.matiereEnseigne = matiereEnseigne;
    }
    /**
     * Obtient le prochain cours du professeur.
     *
     * @return Le prochain cours
     */

    public String getProchainCours() {
        return prochainCours;
    }
    /**
     * Définit le prochain cours du professeur.
     *
     * @param prochainCours Le nouveau prochain cours
     */
    public void setProchainCours(String prochainCours) {
        this.prochainCours = prochainCours;
    }

    /**
     * Obtient le sujet de la prochaine réunion du professeur.
     *
     * @return Le sujet de la prochaine réunion
     */
    public String getSujetProchaineReunion() {
        return sujetProchaineReunion;
    }

    /**
     * Définit le sujet de la prochaine réunion du professeur.
     *
     * @param sujetProchaineReunion Le nouveau sujet de la prochaine réunion
     */
    public void setSujetProchaineReunion(String sujetProchaineReunion) {
        this.sujetProchaineReunion = sujetProchaineReunion;
    }


    /**
     * Modifie les informations d'un professeur existant.
     *
     * @param professeur Le professeur avec les nouvelles informations
     * @return Le professeur modifié
     */

}
