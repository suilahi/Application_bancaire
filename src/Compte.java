import java.util.Scanner;

abstract class Compte {
    private long numeroCompte;
    private Client propietaire;
    private double soldeinitial;
    private String type;

    public Compte(long numeroCompte, Client propietaire, double soldeinitial) {
        this.numeroCompte = numeroCompte;
        this.propietaire = propietaire;
        this.soldeinitial = soldeinitial;
    }
    public Compte(){}
    public Compte(long numeroCompte,double soldeinitial){
        this.numeroCompte=numeroCompte;
        this.soldeinitial=soldeinitial;
    }

    public long getNum() {
        return numeroCompte;
    }

    public void setNum(int number) {
        this.numeroCompte = number;
    }

    public Client getPropietaire() {
        return propietaire;
    }

    public void setPropietaire(Client propietaire) {
        this.propietaire = propietaire;
    }

    public double getSoldeinitial() {
        return soldeinitial;
    }

    public void setSoldeinitial(long soldeinitial) {
        this.soldeinitial = soldeinitial;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    Scanner sc = new Scanner(System.in);

    @Override
    public String toString() {
        return "{" +
                " numeroCompte=" + numeroCompte +
                "\n propietaire=" + propietaire +
                " \n soldeinitial=" + soldeinitial +
                '}';
    }



    public void gestiondecompte() {
        int choix;
        CompteCourant compteCourant=new CompteCourant();
        CompteEpargne compteEpargne=new CompteEpargne();
        do {
            System.out.println("menu de compte");
            System.out.println("1- Créer compte");
            System.out.println("2- Afficher compte");
            System.out.println("Entrer votre choix:");
            choix = sc.nextInt();

            switch (choix) {
                case 1:
                    System.out.println("1 pour compte courant et 2 pour compte épargne:");
                    int choixCompte= sc.nextInt();
                    switch (choixCompte){
                        case 1:
                            compteCourant.creercompte();
                            break;
                        case 2:
                            compteEpargne.creercompte();
                            break;
                    }
                    break;
                case 2:System.out.println("1 pour compte courant et 2 pour compte épargne:");
                    int choixCompt= sc.nextInt();
                    switch (choixCompt){
                        case 1:
                            compteCourant.afficherComptes();
                            break;
                        case 2:
                            compteEpargne.afficherComptes();
                            break;
                    }
                    break;
                case 3:
                    System.out.println("vous avez choisi le retour au menu principal");
                    break;
            }
        } while (choix != 3);
    }
    abstract  public void creercompte();

    public Client RechercheClientIdExiste(int idClient){
        for (Client client : Client.clients){
            if (idClient==Client.getId()){
                return client;
            }
        }
        System.out.println("client introuvable");
        return null;
    }
}
