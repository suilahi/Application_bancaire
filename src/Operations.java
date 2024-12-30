import java.util.ArrayList;
import java.util.Scanner;

public class Operations {
    private Scanner scanner = new Scanner(System.in);
    public static ArrayList<CompteCourant> comptesCourants = new ArrayList<>();
    private ArrayList<String> historique = new ArrayList<>(); // Historique des opérations

    // Méthode pour effectuer un retrait
    public void effectuerRetrait() {
        System.out.println("Entrez le numéro du compte pour effectuer le retrait :");
        long numeroCompte = scanner.nextLong();
        scanner.nextLine();
        CompteCourant compteTrouve = null;
        for (CompteCourant compte : comptesCourants) {
            if (compte.getNum() == numeroCompte) {
                compteTrouve = compte;
                break;
            }
        }
        if (compteTrouve != null) {
            System.out.println("Montant à retirer :");
            double montant = scanner.nextDouble();
            scanner.nextLine();
            if (montant > 0 && montant <= compteTrouve.getSoldeinitial()) {
                double nouveauSolde = compteTrouve.getSoldeinitial() - montant;
                compteTrouve.setSoldeinitial(nouveauSolde);
                historique.add("Retrait de " + montant + " du compte " + numeroCompte);
                System.out.println("Retrait effectué avec succès ! Nouveau solde : " + nouveauSolde);
            } else if (montant > compteTrouve.getSoldeinitial()) {
                System.out.println("Fonds insuffisants pour ce retrait.");
            } else {
                System.out.println("Montant invalide. Le retrait doit être supérieur à zéro.");
            }
        } else {
            System.out.println("Compte introuvable !");
        }
    }

    // Méthode pour effectuer un dépôt
    public void effectuerDepot() {
        System.out.println("Entrez le numéro du compte pour effectuer le dépôt :");
        long numeroCompte = scanner.nextLong();
        scanner.nextLine();
        CompteCourant compteTrouve = null;
        for (CompteCourant compte : comptesCourants) {
            if (compte.getNum() == numeroCompte) {
                compteTrouve = compte;
                break;
            }
        }
        if (compteTrouve != null) {
            System.out.println("Montant à déposer :");
            double montant = scanner.nextDouble();
            scanner.nextLine();
            if (montant > 0) {
                double nouveauSolde = compteTrouve.getSoldeinitial() + montant;
                compteTrouve.setSoldeinitial(nouveauSolde);
                historique.add("Dépôt de " + montant + " sur le compte " + numeroCompte);
                System.out.println("Dépôt effectué avec succès ! Nouveau solde : " + nouveauSolde);
            } else {
                System.out.println("Montant invalide. Le dépôt doit être supérieur à zéro.");
            }
        } else {
            System.out.println("Compte introuvable !");
        }
    }



    // Méthode de gestion des opérations
    public void gestionDesOperations() {
        int choix;
        do {
            System.out.println("\nMenu de gestion des opérations");
            System.out.println("1 - Effectuer un dépôt");
            System.out.println("2 - Effectuer un retrait");
            System.out.println("3 - Effectuer un virement");
            System.out.println("4 - Afficher l'historique des opérations");
            System.out.println("5 - Quitter");
            System.out.print("Saisir votre choix : ");
            choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1:
                    effectuerDepot();
                    break;
                case 2:
                    effectuerRetrait();
                    break;

                case 3:
                    System.out.println("Retour au menu principal.");
                    break;
                default:
                    System.out.println("Choix invalide.");
            }
        } while (choix != 5);
    }
}