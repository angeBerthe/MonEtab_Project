import dao.IUtilisateurDao;
import dao.impl.UtilisateurDaoImpl;
import models.Utilisateur;
import service.IUtilisateurService;
import service.impl.UtilisateurServiceImpl;


import java.sql.SQLException;
import java.util.Scanner;

import static models.Utilisateur.*;

public class PageDeConnexion {

    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                      *************************************************
                            BIENVENU DANS NOTRE APPLICATION ETAB         
                      *************************************************
                      
                            CONNEXION
                """);
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.saveUser();

        System.out.print("Pseudo : ");
        String pseudo = scanner.nextLine();
        System.out.print("Mot de passe : ");
        String motDePasse = scanner.nextLine();

        boolean authentifier;
         // ou toute autre implémentation
        IUtilisateurService utilisateurService = new UtilisateurServiceImpl();
        authentifier = utilisateurService.authentification(pseudo,motDePasse);

        if (authentifier){
            CreationDesDifferentsMenus.afficherMenuPrincipal();
        }
        else{
            System.out.println("Identifiant incorecte");
            System.out.println("Voulez-vous ressayer (O/N)");
            String rep = scanner.nextLine();
            if(rep.equalsIgnoreCase("oui")){
               // ressayer();
            }else if(rep.equalsIgnoreCase("non")){
                System.exit(0);
            }else{
                System.out.println("Option non géré");
            }

        }
    }
}

