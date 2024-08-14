import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import Exception.NotFoundExceptionMenu;

public class CreationDesDifferentsMenus {


    public static void afficherMenuPrincipal() {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime localTime = LocalTime.parse(LocalTime.now().format(dateTimeFormatter), dateTimeFormatter);
        System.out.println("""
                **********************************************************
                                 BIENVENU DANS L' APPLICATION ETAB
                **********************************************************
                                    
                MENU:
                                    
                        1: Gestion des élèves
                        2: Gestion des professeurs
                        3: Gestion des utilisateurs
                        0: Quitter
                           
                """);
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
                System.out.println("A bientôt");
                System.exit(0);
                break;
        }
        System.out.println("Date système:" + localTime);
    }

    public static void afficherMenuGestionProfesseurs() {
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

    public static void afficherMenuGestionEleves() {
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

    }

    public static void afficherMenuGestionUtilisateur(){

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



    }
}
