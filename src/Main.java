import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int choix = 0;
        Scanner scanner=new Scanner(System.in);
        Client client=new Client();
        CompteCourant compteCourant=new CompteCourant();
        Operations operations=new Operations();

        do {
            System.out.println("menu principal");
            System.out.println("1. Gérer les clients");
            System.out.println("2. Gérer les comptes");
            System.out.println("3. Gérer les opérations");
            System.out.println("4. Filtrage");
            System.out.println("choisi votre choix:");
            choix = scanner.nextInt();
            switch (choix){
                case 1:
                    client.gestiondeclient();                    break;
                case 2:

                    compteCourant.gestiondecompte();
                    break;
                case 3:
                    operations.gestionDesOperations();
                    break;
                case 4:
                    break;
            }
        }while (choix!=4);

    }

}