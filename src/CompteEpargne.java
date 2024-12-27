import java.util.ArrayList;
import java.util.Scanner;

public class CompteEpargne extends Compte {
    private double tauxinteret;
    static ArrayList<CompteEpargne> compteepargnes = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public CompteEpargne(long num, Client propietaire, double soldeinitial) {
        super(num, propietaire, soldeinitial);

    }

    public CompteEpargne(long numero, double soldeinitial, double tauxinteret) {
        super(numero, soldeinitial);
        this.tauxinteret = tauxinteret;
    }

    public CompteEpargne() {}

    @Override
    public void creercompte() {
        System.out.println("entrer l'id du client:");
        int idClient = scanner.nextInt();
        scanner.nextLine();
        Client client = RechercheClientIdExiste(idClient);
        if (client != null) {
            System.out.println("numéro de compte:");
            long numero = scanner.nextLong();
            scanner.nextLine();
            System.out.println("solde initial:");
            double soldeinitial = scanner.nextDouble();
            scanner.nextLine();
            CompteEpargne compteepargne = new CompteEpargne(numero,client, soldeinitial);
            compteepargnes.add(compteepargne);
            System.out.println("compte crée avec succés");
        } else {
            System.out.println("client introuvable!!");
        }

    }
    public  void afficherComptes() {
        if (compteepargnes.isEmpty()) {
            System.out.println("Aucun compte epargne trouvé !");
            return;
        }

        System.out.println("Liste des comptes epargnes :");
        for (CompteEpargne compteepargne : compteepargnes) {
            System.out.println(compteepargnes);
        }
    }
}
