import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Client {
    private static int idCounter = 1;
    private int id;
    private String nom, prenom, Email, adresse;
    private String NumTele;
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Client> clients = new ArrayList<>();

    public Client(String nom, String prenom, String Email, String adresse, String NumTele) {
        this.id=idCounter;
        this.nom = nom;
        this.prenom = prenom;
        this.Email = Email;
        this.adresse = adresse;
        this.NumTele = NumTele;
        idCounter++;
    }

    @Override
    public String toString() {
        return "{"+ " id=" + id + ", nom='" + nom + '\'' + ",  prenom='" + prenom + '\'' + ", email='" + Email + '\'' + ", adresse='" + adresse + '\'' + ", NumTele=" + NumTele + '}';

    }

    public int getId() {
        return id;
    }
    public String getNom() {return nom;}
    public String getPrenom() {return prenom;}
    public String getEmail() {
        return Email;
    }
    public String getAdresse() {
        return adresse;
    }
    public String getNumTele() {
        return NumTele;
    }

    public static boolean validationemail(String email) {
        String emailRegex = "^[A-Za-z0-9._%+-]+@[A-Za-z]+\\.[A-Za-z]{2,6}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public Client(){}
    public void ajouterclient() {
        System.out.println("Entrer le nom:");
        String nom = sc.nextLine();
        System.out.println("Enter le prenom:");
        String prenom = sc.nextLine();
        String email;
        do {
            System.out.println("Entrer l'email:");
            email = sc.nextLine();
            if (!validationemail(email)) {
                System.out.println("Email invalide. Veuillez réessayer.");
            }
        } while (!validationemail(email));
        System.out.println("Entrer l'Adresse:");
        String adresse = sc.nextLine();
        Client client=new Client(nom,prenom,email,adresse,NumTele);
        clients.add(client);
        System.out.println("client ajouter avec succées");
    }
    public void afficherlisteclient(){
        if (clients.isEmpty()){
            System.out.println("aucun client trouvé!!");
        }
        for (Client client:clients){
            System.out.println(client);
        }
    }

    public void gestiondeclient() {
        int choix;
        do {
            System.out.println("menu de client");
            System.out.println("1- Ajouter client");
            System.out.println("2- Afficher client");
            System.out.println("3- Quitter");
            System.out.println("Entrer votre choix:");
            choix = sc.nextInt();
            switch (choix) {
                case 1:
                    ajouterclient();
                    break;
                case 2:
                    afficherlisteclient();
                    break;
                case 3:
                    System.out.println("vous avez choisi le retour au menu principal");
                    break;
            }
        } while (choix != 3) ;
    }
}
