import java.util.ArrayList;
import java.util.Scanner;

public class CompteCourant extends Compte{
    private double fraisbancaire;
    public static ArrayList<CompteCourant>Comptecourant=new ArrayList<>();
    static Scanner scanner=new Scanner(System.in);

    public CompteCourant(long numero ,Client propietaire, double soldeinitial, double fraisbancaire){
        super( numero, propietaire, soldeinitial);
        this.fraisbancaire = fraisbancaire;
    }
    public CompteCourant(){}
    public CompteCourant(long numero,double soldeinitial,double fraisbancaire){
        super(numero,soldeinitial);
        this.fraisbancaire=fraisbancaire;
    }
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
            CompteCourant compteCourant = new CompteCourant(numero, soldeinitial, fraisbancaire);
            Comptecourant.add(compteCourant);
            System.out.println("compte crée avec succés");
        } else {
            System.out.println("client introuvable!!");
        }
    }
        public  void afficherComptes() {
            if (Comptecourant.isEmpty()) {
                System.out.println("Aucun compte courant trouvé !");
                return;
            }

            System.out.println("Liste des comptes courants :");
            for (CompteCourant compte : Comptecourant) {
                System.out.println(compte);
            }
        }





}
