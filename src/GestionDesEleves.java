import dao.IEleveDao;
import dao.impl.EleveDaoImpl;
import models.Eleve;
import service.impl.EleveServiceImpl;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class GestionDesEleves {

    private static EleveDaoImpl eleveDao = new EleveDaoImpl();
    private static EleveServiceImpl eleveService = new EleveServiceImpl(eleveDao);

    public static void ajouterEleve() throws SQLException {

        Scanner scanner = new Scanner(System.in);


        try {
            System.out.println("Enregistrement d'un nouvel élève");

            Scanner scan = new Scanner(System.in);

            System.out.print("Identifiant : ");
            int id = scan.nextInt();

            System.out.print("Nom : ");
            String nom = scanner.nextLine();

            System.out.print("Prénom : ");
            String prenom = scanner.nextLine();

            Date dateDeNaissance = null;
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            while (dateDeNaissance == null) {
                System.out.print("Entrez la date de naissance (JJ/MM/AAAA) : ");
                String dateInput = scanner.nextLine();
                try {
                    dateDeNaissance = sdf.parse(dateInput);
                } catch (ParseException e) {
                    System.out.println("Format de date invalide. Veuillez réessayer.");
                }
            }

            System.out.print("Ville : ");
            String ville = scanner.nextLine();

            System.out.print("Classe : ");
            String classe = scanner.nextLine();

            System.out.print("Matricule : ");
            String matricule = scanner.nextLine();

            System.out.print("Téléphone : ");
            String telephone = scanner.nextLine();

            Eleve eleve = new Eleve(id, dateDeNaissance, ville, prenom, nom, telephone, classe, matricule);
            eleveService.save(eleve);

        } catch (SQLException e) {
            System.out.println("Erreur lors de l'enregistrement de l'élève : " + e.getMessage());
        }

        boolean choixValide = false;
        while (!choixValide) {
            System.out.println(" Votre choix");
            System.out.println("1. Retour au menu utilisateur");
            System.out.println("2. Quitter le programme");
            System.out.print("Votre choix (1 ou 2) : ");

            String choix = scanner.nextLine();

            switch (choix) {
                case "1":
                    choixValide = true;
                    CreationDesDifferentsMenus.afficherMenuGestionEleves();
                    break;
                case "2":
                    System.out.println("Merci d'avoir utilisé notre programme. Au revoir !");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Choix non valide. Veuillez entrer 1 ou 2.");
            }
        }

    }
    public static void supprimerEleve() throws SQLException {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez l'identifiant de l'élève à supprimer : ");
        int id = scanner.nextInt();
        eleveService.delete(id);

        boolean choixValide = false;
        while (!choixValide) {
            System.out.println(" Votre choix");
            System.out.println("1. Retour au menu utilisateur");
            System.out.println("2. Quitter le programme");
            System.out.print("Votre choix (1 ou 2) : ");

            String choix = scanner.nextLine();

            switch (choix) {
                case "1":
                    choixValide = true;
                    CreationDesDifferentsMenus.afficherMenuGestionEleves();
                    break;
                case "2":
                    System.out.println("Merci d'avoir utilisé notre programme. Au revoir !");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Choix non valide. Veuillez entrer 1 ou 2.");
            }
        }
    }

    public static void modifierEleve() throws SQLException {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez l'ID de l'élève à modifier : ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consomme le retour à la ligne

        Eleve eleve = eleveService.getOne(id);
        if (eleve != null) {
            System.out.println("Modifiez les informations de l'élève (ID: " + id + ")");

            // Modification du nom
            System.out.print("Nouveau nom (laisser vide pour ne pas modifier) : ");
            String nom = scanner.nextLine();
            if (!nom.isEmpty()) {
                eleve.setNom(nom);
            }

            // Modification du prénom
            System.out.print("Nouveau prénom (laisser vide pour ne pas modifier) : ");
            String prenom = scanner.nextLine();
            if (!prenom.isEmpty()) {
                eleve.setPrenom(prenom);
            }

            // Modification de la date de naissance
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            System.out.print("Modifier la date de naissance (" + sdf.format(eleve.getDateDeNaissance()) + ") (JJ/MM/AAAA) : ");
            try {
                Date dateDeNaissance = sdf.parse(scanner.nextLine());
                eleve.setDateDeNaissance(dateDeNaissance);
            } catch (ParseException e) {
                System.out.println("Format de date invalide. La date n'a pas été modifiée.");
            }

            // Modification de la ville
            System.out.print("Nouvelle ville (laisser vide pour ne pas modifier) : ");
            String ville = scanner.nextLine();
            if (!ville.isEmpty()) {
                eleve.setVille(ville);
            }

            // Modification du téléphone
            System.out.print("Nouveau téléphone (laisser vide pour ne pas modifier) : ");
            String telephone = scanner.nextLine();
            if (!telephone.isEmpty()) {
                eleve.setTelephone(telephone);
            }

            // Modification de la classe
            System.out.print("Nouvelle classe (laisser vide pour ne pas modifier) : ");
            String classe = scanner.nextLine();
            if (!classe.isEmpty()) {
                eleve.setClasse(classe);
            }

            // Modification de la classe
            System.out.print("Nouvelle matricule (laisser vide pour ne pas modifier) : ");
            String matricule = scanner.nextLine();
            if (!matricule.isEmpty()) {
                eleve.setMatricule(matricule);
            }

            // Mise à jour des informations de l'élève
            eleveService.update(eleve);
        } else {
            System.out.println("Aucun élève trouvé avec l'ID spécifié.");
        }
        boolean choixValide = false;
        while (!choixValide) {
            System.out.println(" Votre choix");
            System.out.println("1. Retour au menu utilisateur");
            System.out.println("2. Quitter le programme");
            System.out.print("Votre choix (1 ou 2) : ");

            String choix = scanner.nextLine();

            switch (choix) {
                case "1":
                    choixValide = true;
                    CreationDesDifferentsMenus.afficherMenuGestionEleves();
                    break;
                case "2":
                    System.out.println("Merci d'avoir utilisé notre programme. Au revoir !");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Choix non valide. Veuillez entrer 1 ou 2.");
            }
        }

    }


    public static void listerEleve() throws SQLException {
        List<Eleve> eleves = eleveService.getAll(); // Utilisez la méthode statique pour obtenir la liste des élèves

        if (eleves.isEmpty()) {
            System.out.println("Aucun élève n'est enregistré.");
        } else {
            for (Eleve eleve : eleves) {
                System.out.println(eleve.toString());
            }
        }
        Scanner scanner = new Scanner(System.in);

        boolean choixValide = false;
        while (!choixValide) {
            System.out.println(" Votre choix");
            System.out.println("1. Retour au menu utilisateur");
            System.out.println("2. Quitter le programme");
            System.out.print("Votre choix (1 ou 2) : ");

            String choix = scanner.nextLine();

            switch (choix) {
                case "1":
                    choixValide = true;
                    CreationDesDifferentsMenus.afficherMenuGestionEleves();
                    break;
                case "2":
                    System.out.println("Merci d'avoir utilisé notre programme. Au revoir !");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Choix non valide. Veuillez entrer 1 ou 2.");
            }
        }

    }
    }

