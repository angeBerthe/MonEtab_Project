package dao.impl;

import dao.IEleveDao;
import dao.SingletonDataBase;
import models.Eleve;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class EleveDaoImpl implements IEleveDao {

    private Connection connection  = SingletonDataBase.getInstance();

    @Override
    public Eleve ajouter(Eleve eleve) throws SQLException {

        if (eleve.getDateDeNaissance() == null) {
            throw new IllegalArgumentException("La date de naissance ne peut pas être nulle.");
        }

        String insertPersonneSQL = "INSERT INTO PERSONNE (DATEDENAISSANCE, VILLE, PRENOM, NOM, TELEPHONE) VALUES (?, ?, ?, ?, ?)";
        String insertEleveSQL = "INSERT INTO ELEVE (ID, DATEDENAISSANCE, VILLE, PRENOM, NOM, TELEPHONE, CLASSE, MATRICULE) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        Connection connection = SingletonDataBase.getInstance();
        try (PreparedStatement personneStatement = connection.prepareStatement(insertPersonneSQL, PreparedStatement.RETURN_GENERATED_KEYS)) {
            personneStatement.setDate(1, new Date(eleve.getDateDeNaissance().getTime()));
            personneStatement.setString(2, eleve.getVille());
            personneStatement.setString(3, eleve.getPrenom());
            personneStatement.setString(4, eleve.getNom());
            personneStatement.setString(5, eleve.getTelephone());

            personneStatement.executeUpdate();

            try (ResultSet generatedKeys = personneStatement.getGeneratedKeys()) {
                int personneId = 0;
                if (generatedKeys.next()) {
                     personneId = generatedKeys.getInt(1);

                    try (PreparedStatement eleveStatement = connection.prepareStatement(insertEleveSQL)) {
                        eleveStatement.setInt(1, personneId);
                        eleveStatement.setDate(2, new java.sql.Date(eleve.getDateDeNaissance().getTime()));
                        eleveStatement.setString(3, eleve.getVille());
                        eleveStatement.setString(4, eleve.getPrenom());
                        eleveStatement.setString(5, eleve.getNom());
                        eleveStatement.setString(6, eleve.getTelephone());
                        eleveStatement.setString(7, eleve.getClasse());
                        eleveStatement.setString(8, eleve.getMatricule());

                        eleveStatement.executeUpdate();
                    }
                    System.out.println("Élève ajouté avec succès !");
                }
            }
        }
        return eleve;
    }


    @Override
    public Eleve modifier(Eleve eleve) {
        String query = "UPDATE personne SET dateDeNaissance=?, ville=?, prenom=?, nom=?, telephone=? WHERE id=?";
        String queryEleve = "UPDATE eleve SET dateDeNaissance=?, ville=?, prenom=?, nom=?, telephone=?, classe=?, matricule=? WHERE id=?";

        try {
            connection.setAutoCommit(false); // Commencer la transaction

            System.out.println("ID : " + eleve.getId());
            System.out.println("Date de Naissance : " + eleve.getDateDeNaissance());
            System.out.println("Ville : " + eleve.getVille());
            System.out.println("Prénom : " + eleve.getPrenom());
            System.out.println("Nom : " + eleve.getNom());
            System.out.println("Téléphone : " + eleve.getTelephone());
            System.out.println("Classe : " + eleve.getClasse());
            System.out.println("Matricule : " + eleve.getMatricule());

            // Mettre à jour la table personne
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setDate(1, new Date(eleve.getDateDeNaissance().getTime()));
                statement.setString(2, eleve.getVille());
                statement.setString(3, eleve.getPrenom());
                statement.setString(4, eleve.getNom());
                statement.setString(5, eleve.getTelephone());
                statement.setInt(6, eleve.getId());
                int rowsUpdated = statement.executeUpdate();

                if (rowsUpdated > 0) {
                    // Mettre à jour la table eleve
                    try (PreparedStatement statementEleve = connection.prepareStatement(queryEleve)) {

                        statementEleve.setDate(1, new Date(eleve.getDateDeNaissance().getTime()));
                        statementEleve.setString(2, eleve.getVille());
                        statementEleve.setString(3, eleve.getPrenom());
                        statementEleve.setString(4, eleve.getNom());
                        statementEleve.setString(5, eleve.getTelephone());
                        statementEleve.setString(6, eleve.getClasse());
                        statementEleve.setString(7, eleve.getMatricule());
                        statementEleve.setInt(8, eleve.getId());
                        statementEleve.executeUpdate();

                        connection.commit(); // Valider la transaction
                        System.out.println("Élève modifié avec succès !");
                    }
                } else {
                    connection.rollback(); // Annuler la transaction si l'ID n'existe pas
                    System.out.println("Aucun élève trouvé avec cet ID.");
                }
            }

        } catch (SQLException e) {
            try {
                connection.rollback(); // Annuler la transaction en cas d'erreur
            } catch (SQLException rollbackEx) {
                System.out.println("Erreur lors de l'annulation de la transaction : " + rollbackEx.getMessage());
            }
            System.out.println("Erreur lors de la modification de l'élève : " + e.getMessage());
        } finally {
            try {
                connection.setAutoCommit(true); // Remettre l'auto-commit à true
            } catch (SQLException e) {
                System.out.println("Erreur lors du rétablissement de l'auto-commit : " + e.getMessage());
            }
        }
        return eleve;
    }

    @Override
    public void supprimer(int id) {
        String deleteEleveSQL = "DELETE FROM eleve WHERE id = ?";
        String deletePersonneSQL = "DELETE FROM personne WHERE id = ?";

        try {
            connection.setAutoCommit(false); // Commencer la transaction

            try (PreparedStatement deleteEleveStmt = connection.prepareStatement(deleteEleveSQL)) {
                deleteEleveStmt.setInt(1, id);
                int rowsDeletedEleve = deleteEleveStmt.executeUpdate();

                if (rowsDeletedEleve > 0) {
                    try (PreparedStatement deletePersonneStmt = connection.prepareStatement(deletePersonneSQL)) {
                        deletePersonneStmt.setInt(1, id);
                        int rowsDeletedPersonne = deletePersonneStmt.executeUpdate();

                        if (rowsDeletedPersonne > 0) {
                            connection.commit(); // Valider la transaction
                            System.out.println("Élève supprimé avec succès !");
                        } else {
                            connection.rollback(); // Annuler la transaction si l'ID n'existe pas dans la table personne
                            System.out.println("Erreur lors de la suppression de l'élève dans la table personne.");
                        }
                    }
                } else {
                    connection.rollback(); // Annuler la transaction si l'ID n'existe pas dans la table eleve
                    System.out.println("Aucun élève trouvé avec cet ID dans la table eleve.");
                }
            } catch (SQLException e) {
                connection.rollback(); // Annuler la transaction en cas d'erreur
                System.out.println("Erreur lors de la suppression de l'élève : " + e.getMessage());
            } finally {
                connection.setAutoCommit(true); // Remettre l'auto-commit à true
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la gestion de la transaction : " + e.getMessage());
        }
    }

    @Override
    public List<Eleve> listerEleve() {
        List<Eleve> eleves = new ArrayList<>();
        String query = "SELECT p.id, p.dateDeNaissance, p.ville, p.prenom, p.nom,  p.telephone, e.classe, e.matricule FROM personne p INNER JOIN eleve e ON p.id = e.id";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                Eleve eleve = new Eleve(
                        resultSet.getInt("id"),
                        resultSet.getDate("dateDenaissance"),
                        resultSet.getString("ville"),
                        resultSet.getString("prenom"),
                        resultSet.getString("nom"),
                        resultSet.getString("telephone"),
                        resultSet.getString("classe"),
                        resultSet.getString("matricule")
                );
                eleves.add(eleve);
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la récupération des élèves : " + e.getMessage());
        }
        return eleves;
    }

    @Override
    public Eleve obtenir(int id) {
        String query = "SELECT p.id, p.dateDeNaissance, p.ville, p.prenom, p.nom,  p.telephone,  e.classe, e.matricule FROM personne p INNER JOIN eleve e ON p.id = e.id WHERE p.id=?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new Eleve(
                        resultSet.getInt("id"),
                        resultSet.getDate("dateDeNaissance"),
                        resultSet.getString("ville"),
                        resultSet.getString("prenom"),
                        resultSet.getString("nom"),
                        resultSet.getString("telephone"),
                        resultSet.getString("classe"),
                        resultSet.getString("matricule")
                );
            } else {
                System.out.println("Aucun élève trouvé avec cet ID.");
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la récupération de l'élève : " + e.getMessage());
        }
        return null;
    }
    }

