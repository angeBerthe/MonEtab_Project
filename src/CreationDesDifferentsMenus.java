import java.sql.SQLException;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;
import Exception.NotFoundExceptionMenu;

public class CreationDesDifferentsMenus {

    Date date = new Date();


    public static void afficherMenuPrincipal() throws SQLException {
        Instant debutSession = Instant.now();
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime localTime = LocalTime.parse(LocalTime.now().format(dateTimeFormatter), dateTimeFormatter);
        System.out.println("""
                            *********************************************
                                     BIENVENU DANS L' APPLICATION ETAB
                            **********************************************
                                    
                MENU:
                                    
                        1: Gestion des élèves
                        2: Gestion des professeurs
                        3: Gestion des utilisateurs
                        0: Quitter
                           
                """);

        System.out.println("Date système :" +localTime);

        System.out.print("Votre choix SVP : ");
        int choix = NotFoundExceptionMenu.obtenirChoixUtilisateur(scanner, 6);

        switch (choix) {
            case 1:
                afficherMenuGestionEleves();
                break;
            case 2:
                afficherMenuGestionProfesseurs();
                break;
            case 3:
                afficherMenuGestionUtilisateur();
                break;
            case 0:
                Instant finSession = Instant.now();  // Capturer l'instant de la fin de la session
                Duration duree = Duration.between(debutSession, finSession);

                long heures = duree.toHours();
                long minutes = duree.toMinutes() % 60;
                long secondes = duree.getSeconds() % 60;

                System.out.println("Merci d'avoir utilisé l'application ETAB. Au revoir !");
                System.out.println("Durée de la session : " + heures + " heures, " + minutes + " minutes, " + secondes + " secondes.");
                System.exit(0);
        }
        System.out.println("Date système:" + localTime);
    }

    public static void afficherMenuGestionProfesseurs() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                                 **************************************
                                        GESTION DES PROFESSEURS
                                 *************************************   
                MENU:
                                    
                        1: Ajouter un professeur
                        2: Supprimer un professeur
                        3: Modifier les informations du professeur
                        4: Lister les professeur
                        5: Obtenir le dernier professeur ajouté
                        6: Retour 
                        0: Accueil          
                """);
            System.out.print("Votre choix : ");
        int choix = NotFoundExceptionMenu.obtenirChoixUtilisateur(scanner, 6);

        switch (choix) {
            case 1:
                //GestionDesProfesseurs.ajouterProfesseur();
                break;
            case 2:
               // GestionDesProfesseurs.supprimerProfesseur();
                break;
            case 3:
                //GestionDesProfesseurs.modifierProfesseur();
                break;
            case 4:
               // GestionDesProfesseurs.listerProfesseur();
                break;
            case 6:
                afficherMenuGestionProfesseurs();
                break;
            case 0:
                afficherMenuPrincipal();
                break;
            default:
                System.out.println("Choix invalide. Veuillez réessayer.");
        }

    }

    public static void afficherMenuGestionEleves() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                                ***************************************
                                        GESTION DES ELEVES
                                ************************************   
                MENU:
                                    
                        1: Ajouter un élève
                        2: Supprimer un élève
                        3: Modifier les informations de l'élève
                        4: Lister les élèves
                        6: Retour 
                        0: Quitter  
                      
                """);
        System.out.print("Votre choix : ");
        int choix = NotFoundExceptionMenu.obtenirChoixUtilisateur(scanner, 6);

        switch (choix) {
            case 1:
                GestionDesEleves.ajouterEleve();
                break;
            case 2:
                GestionDesEleves.supprimerEleve();
                break;
            case 3:
                GestionDesEleves.modifierEleve();
                break;
            case 4:
               GestionDesEleves.listerEleve();
                break;
            case 5:
                afficherMenuGestionEleves();
                break;
            case 0:
                System.out.println("A bientôt");
                System.exit(0);
                break;
            default:
                System.out.println("Choix invalide. Veuillez réessayer.");


        }


    }

    public static void afficherMenuGestionUtilisateur(){

        Instant debutSession = Instant.now();

        int choix;

        do {
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                                ***************************************
                                        GESTION DES UTILISATEURS
                                ************************************   
                MENU:
                                    
                        1: Ajouter un utilisateur
                        2: Supprimer un utilisateur
                        3: Modifier les informations de l'utilisateur
                        4: Lister les utilisateur
                        5: Retour 
                        0: Quitter  
                      
                """);

        System.out.print("Votre choix : ");

        choix = NotFoundExceptionMenu.obtenirChoixUtilisateur(scanner, 6);

        switch (choix) {
            case 1:
                // Implémentation de l'ajout d'un utilisateur à ajouter ici
                break;
            case 5:
                //new MenuPrincipal().afficherMenu();
                break;
            case 0:
                Instant finSession = Instant.now();  // Capturer l'instant de la fin de la session
                Duration duree = Duration.between(debutSession, finSession);

                long heures = duree.toHours();
                long minutes = duree.toMinutes() % 60;
                long secondes = duree.getSeconds() % 60;

                System.out.println("Merci d'avoir utilisé l'application ETAB. Au revoir !");
                System.out.println("Durée de la session : " + heures + " heures, " + minutes + " minutes, " + secondes + " secondes.");
                System.exit(0);

            default:
                System.out.println("Choix invalide. Veuillez réessayer.");
        }
    } while (choix != 6);
}


}
