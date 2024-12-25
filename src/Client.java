import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Client {
    private int id;
    private String nom, prenom, Email, adresse;
    private long NumTele;
    Scanner sc = new Scanner(System.in);
    private ArrayList<Client> clients = new ArrayList<>();

    public Client(int id, String nom, String prenom, String Email, String adresse, long NumTele) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.Email = Email;
        this.adresse = adresse;
        this.NumTele = NumTele;
    }

    @Override
    public String toString() {

        return "Client{" +
                "\n id=" + id +
                "\n nom='" + nom + '\'' +
                "\n  prenom='" + prenom + '\'' +
                "\n email='" + Email + '\'' +
                "\n adresse='" + adresse + '\'' +
                "\n NumTele=" + NumTele +
                '}';

    }

    public int getId() {
        return id;
    }
    public String getNom() {
        return nom;
    }
    public String getPrenom() {
        return prenom;
    }
    public String getEmail() {
        return Email;
    }
    public String getAdresse() {
        return adresse;
    }
    public long getNumTele() {
        return NumTele;
    }
    public static boolean validationemail(String email) {
        String emailRegex = "^[A-Za-z0-9._%+-]+@[A-Za-z]+\\.[A-Za-z]{2,6}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    public Client(){}
    public void ajouterclient(){
        int id= clients.size()+1;
        sc.nextLine();
        System.out.println("Entrer le nom:");
        String nom=sc.nextLine();
        System.out.println("Enter le prenom:");
        String prenom=sc.nextLine();
        String email;
        do {
            System.out.println("Entrer l'email:");
            email = sc.nextLine();
            if (!validationemail(email)) {
                System.out.println("Email invalide. Veuillez réessayer.");
            }
        } while (!validationemail(email));
        System.out.println("Entrer l'Adresse:");
        String adresse=sc.nextLine();
        System.out.println("Entrer Numero de Telephone::");
        long NumTele=sc.nextLong();
        Client client=new Client(id,nom,prenom,email,adresse,NumTele);
        clients.add(client);
        System.out.println("client ajouter avec succées");
    }
    public void afficherlisteclient(){
        if (clients.isEmpty()){
            System.out.println("aucun client trouvé!!");
        }
        for (Client client:clients){
            System.out.println(clients);
        }
    }

    public void gestiondeclient() {
        int choix;
        do {
            System.out.println("menu de client");
            System.out.println("1- Ajouter client");
            System.out.println("2- Afficher client");
            System.out.println("Entrer votre choix:");
            choix = sc.nextInt();
            switch (choix) {
                case 1:
                    ajouterclient();
                    break;
                case 2:

                    break;
                case 3:
                    System.out.println("vous avez choisi le retour au menu principal");
                    break;
            }
        } while (choix != 3) ;

    }

}
