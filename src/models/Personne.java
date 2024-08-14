package models;

import java.util.Date;

/**
 * Classe représentant une personne dans le système.
 * Cette classe contient les informations de base d'une personne, telles que son identifiant,
 * sa date de naissance, sa ville de résidence, son nom, son prénom et son numéro de téléphone.
 */
public class Personne {
    private int id;
    private Date dateDeNaissance;
    private String ville;
    private String prenom;
    private String nom;
    private String telephone;

    /**
     * Constructeur par défaut de la classe Personne.
     * Crée une instance de Personne sans initialiser ses attributs.
     */
    public Personne() { }

    /**
     * Constructeur avec tous les paramètres de la classe Personne.
     * Crée une instance de Personne en initialisant tous ses attributs.
     *
     * @param id Identifiant unique de la personne
     * @param dateDeNaissance Date de naissance de la personne
     * @param ville Ville de résidence de la personne
     * @param prenom Prénom de la personne
     * @param nom Nom de famille de la personne
     * @param telephone Numéro de téléphone de la personne
     */
    public Personne(int id, Date dateDeNaissance, String ville, String prenom, String nom, String telephone) {
        this.id = id;
        this.dateDeNaissance = dateDeNaissance;
        this.ville = ville;
        this.prenom = prenom;
        this.nom = nom;
        this.telephone = telephone;
    }

    /**
     * Obtient l'identifiant de la personne.
     *
     * @return L'identifiant unique de la personne
     */
    public int getId() {
        return id;
    }

    /**
     * Définit l'identifiant de la personne.
     *
     * @param id Le nouvel identifiant unique de la personne
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtient la date de naissance de la personne.
     *
     * @return La date de naissance de la personne
     */
    public Date getDateDeNaissance() {
        return dateDeNaissance;
    }

    /**
     * Définit la date de naissance de la personne.
     *
     * @param dateDeNaissance La nouvelle date de naissance de la personne
     */
    public void setDateDeNaissance(Date dateDeNaissance) {
        this.dateDeNaissance = dateDeNaissance;
    }

    /**
     * Obtient la ville de résidence de la personne.
     *
     * @return La ville de résidence de la personne
     */
    public String getVille() {
        return ville;
    }

    /**
     * Définit la ville de résidence de la personne.
     *
     * @param ville La nouvelle ville de résidence de la personne
     */
    public void setVille(String ville) {
        this.ville = ville;
    }

    /**
     * Obtient le prénom de la personne.
     *
     * @return Le prénom de la personne
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * Définit le prénom de la personne.
     *
     * @param prenom Le nouveau prénom de la personne
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * Obtient le nom de famille de la personne.
     *
     * @return Le nom de famille de la personne
     */
    public String getNom() {
        return nom;
    }

    /**
     * Définit le nom de famille de la personne.
     *
     * @param nom Le nouveau nom de famille de la personne
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Obtient le numéro de téléphone de la personne.
     *
     * @return Le numéro de téléphone de la personne
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * Définit le numéro de téléphone de la personne.
     *
     * @param telephone Le nouveau numéro de téléphone de la personne
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    /**
     * Retourne une représentation sous forme de chaîne de caractères de la personne.
     * Cette méthode fournit une description détaillée de tous les attributs de la personne.
     *
     * @return Une chaîne de caractères représentant la personne et tous ses attributs
     */
    @Override
    public String toString() {
        return "Personne{" +
                "id=" + id +
                ", dateDeNaissance=" + dateDeNaissance +
                ", ville='" + ville + '\'' +
                ", prenom='" + prenom + '\'' +
                ", nom='" + nom + '\'' +
                ", telephone='" + telephone + '\'' +
                '}';
    }
}
