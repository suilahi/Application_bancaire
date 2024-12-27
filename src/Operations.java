import java.util.ArrayList;
import java.util.Scanner;

public class Operations {
    Scanner scanner = new Scanner(System.in);

    // Simulation de la liste des comptes courants (à connecter avec votre gestion de comptes).
    public static ArrayList<CompteCourant> comptes = new ArrayList<>();

    public double calculeSoldeActuel(CompteCourant compte) {
        if (compte == null) {
            System.out.println("Compte non valide.");
            return 0;
        }
        double depot = 0; // Ce dépôt peut être ajusté ou mis à jour en fonction des besoins.
        double soldeInitial = compte.getSoldeinitial();
        return soldeInitial + depot;
    }

    public double calculeTauxInteret(CompteCourant compte) {
        System.out.println("Entrez le numéro du compte pour effectuer le dépôt :");
        long numeroCompte = scanner.nextLong();
        scanner.nextLine();

        // Recherche du compte
        CompteCourant compteTrouve = null;
        for (CompteCourant compte1 : comptes) {
            if (compte1.getNum() == numeroCompte) {
                compteTrouve = compte1;
                break;
            }
        }
        if (compte == null) {
            System.out.println("Compte non valide.");
            return 0;
        }
        System.out.println("Un taux d'intérêt de 3% par année");
        System.out.println("Combien d'années de blocage : ");
        int nombreAnnee = scanner.nextInt();
        scanner.nextLine();

        if (nombreAnnee <= 0) {
            System.out.println("Le nombre d'années doit être supérieur à zéro.");
            return 0;
        }

        double montantActuel = compte.getSoldeinitial(); // Utilisation du solde initial comme base.
        double tauxInteret = (nombreAnnee * montantActuel * 3) / 100; // Taux de 3% par année.
        montantActuel=montantActuel+tauxInteret;

        return tauxInteret;
    }

    public void effectuerDepot() {
        System.out.println("Entrez le numéro du compte pour effectuer le dépôt :");
        long numeroCompte = scanner.nextLong();
        scanner.nextLine();

        // Recherche du compte
        CompteCourant compteTrouve = null;
        for (CompteCourant compte : comptes) {
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
                System.out.println("Dépôt effectué avec succès ! Nouveau solde : " + nouveauSolde);
            } else {
                System.out.println("Montant invalide. Le dépôt doit être supérieur à zéro.");
            }
        } else {
            System.out.println("Compte introuvable !");
        }
    }
    Scanner sc=new Scanner(System.in);
    public void gestiondesoperations(){
        int choix;
      do{
          System.out.println("menu de gestion d'operations");
          System.out.println("1-Effectuer depot");
          System.out.println("2-Effecruer retrait");
          System.out.println("3-Effectuer virement");
          System.out.println("4-Afficher l'historique des opérations pour un compte");
          System.out.println("saisir votre choix:");
          choix = sc.nextInt();
          switch (choix){
              case 1:
                  effectuerDepot();
                  break;
              case 2:
                  break;
              case 3:
                  break;
              case 4:
                  break;
              default:
                  System.out.println("choix invalide");

          }
      }while (choix!=4);



    }
}
