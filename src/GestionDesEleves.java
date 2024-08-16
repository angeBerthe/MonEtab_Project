import models.Eleve;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Date;
import java.util.Scanner;

public class GestionDesEleves {


    public static void ajouterEleve() {

        Scanner scan = new Scanner(System.in);
        System.out.println("Ajout d'un nouvel élève \n");
        System.out.println("Votre identifiant:");
        int id = scan.nextInt();
        Scanner scanner = new Scanner(System.in);
        Date dateDeNaissance = null;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        while (dateDeNaissance == null) {
            System.out.print("Entrez la date de naissance (JJ/MM/AAAA) : ");
            String dateDeNaissance1 = scanner.nextLine();
            try {
                dateDeNaissance = sdf.parse(dateDeNaissance1);
            } catch (ParseException e) {
                System.out.println("Format de date invalide. Veuillez réessayer.");
            }
        }

        System.out.print("Entrez la ville : \n");
        String ville = scanner.nextLine();
        System.out.print("Entrez le prénom : \n");
        String prenom = scanner.nextLine();
        System.out.print("Entrez le nom : \n");
        String nom = scanner.nextLine();
        System.out.print("Entrez le telephone : ");
        String telephone = scanner.nextLine();
        System.out.print("Entrez la classe : \n");
        String classe = scanner.nextLine();
        System.out.print("Entrez le matricule : \n");
        String matricule = scanner.nextLine();

        Eleve nouvelEleve = new Eleve(id, dateDeNaissance, ville, prenom, nom, telephone, classe, matricule);
        Eleve eleve = new Eleve();
        eleve.ajouter(nouvelEleve);

        System.out.println("Élève ajouté avec succès ! \n ");

        System.out.println("Voulez-vous ajouter un autre élève? (OUI/NON)");
        String reponse = scanner.nextLine();
        if (reponse.equals("OUI")) {
            ajouterEleve();
        } else {
            CreationDesDifferentsMenus.afficherMenuGestionEleves();
        }
    }

    public static void supprimerEleve() {
        Eleve listeEleve = new Eleve();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez l'identifiant de l'élève à supprimer : ");
        int id = scanner.nextInt();
        listeEleve.supprimer(id); // Utiliser l'instance pour appeler supprimer
        System.out.println("Eleve supprimer avec succès!");

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

    public static void modifierEleve() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Modification d'un élève \n");

        System.out.print("Entrez l'identifiant de l'élève à modifier : ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Eleve eleve = Eleve.trouverEleveParId(id);

        if (eleve == null) {
            System.out.println("Élève introuvable.");
            return;
        }

        Eleve eleve1 = new Eleve();

        System.out.print("Modifier la ville (" + eleve.getVille() + ") : ");
        eleve1.setVille(scanner.nextLine());

        System.out.print("Modifier le prénom (" + eleve.getPrenom() + ") : ");
        eleve1.setPrenom(scanner.nextLine());

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.print("Modifier la date de naissance (" + sdf.format(eleve.getDateDeNaissance()) + ") (JJ/MM/AAAA) : ");
        try {
            Date dateDeNaissance = sdf.parse(scanner.nextLine());
            eleve1.setDateDeNaissance(dateDeNaissance);
        } catch (ParseException e) {
            System.out.println("Format de date invalide. La date n'a pas été modifiée.");
        }

        System.out.print("Modifier le nom (" + eleve.getNom() + ") : ");
        eleve1.setNom(scanner.nextLine());

        System.out.print("Modifier le téléphone (" + eleve.getTelephone() + ") : ");
        eleve1.setTelephone(scanner.nextLine());

        System.out.print("Modifier la classe (" + eleve.getClasse() + ") : ");
        eleve1.setClasse(scanner.nextLine());

        System.out.print("Modifier le matricule (" + eleve.getMatricule() + ") : ");
        eleve1.setMatricule(scanner.nextLine());

        eleve.modifier(eleve1);

        System.out.println("Élève modifié avec succès !\n");

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


    public static void listerEleve() {
        Eleve listeEleve = new Eleve();
        List<Eleve> eleves = listeEleve.listerEleves(); // Utilisez la méthode statique pour obtenir la liste des élèves

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
