package Exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class NotFoundExceptionMenu {

    // Méthode pour obtenir un choix valide de l'utilisateur
    public static int obtenirChoixUtilisateur(Scanner scanner, int options) {
        int choix = -1;
        boolean choixValide = false;

        while (!choixValide) {
            try {
                System.out.print("Votre choix : ");
                choix = scanner.nextInt();
                scanner.nextLine();  // Consomme le retour à la ligne

                if (choix >= 0 && choix <= options) {
                    choixValide = true;  // Sortir de la boucle si le choix est valide
                } else {
                    System.out.println("Choix invalide. Veuillez réessayer.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Choix invalide. Veuillez entrer un nombre correspondant à une option du menu.");
                scanner.nextLine();  // Consommer l'entrée incorrecte pour éviter une boucle infinie
            }
        }

        return choix;
}


}
