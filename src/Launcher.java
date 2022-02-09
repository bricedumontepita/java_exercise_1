import java.util.Scanner;

public class Launcher {
    public static void main(String[] args) {
        System.out.println("un texte de bienvenue");
        Scanner scanner = new Scanner(System.in);
        String entree = "";

        while (!entree.equals("quit")) {
            System.out.println("Entrez une commande : ");
            entree = scanner.nextLine();
            if (entree.equals("fibo")) {
                System.out.println("Entrez un nombre : ");
                int n = scanner.nextInt();
                int rang1 = 0;
                int rang2 = 1;
                for (int i = 3; i <= n + 1; i++) {
                    int temp = rang1;
                    rang1 = rang2;
                    rang2 = temp + rang2;
                }
                System.out.println(rang2);
                scanner.nextLine();
            }
            else
            {
                System.out.println("Unknown command");
            }
        }
    }
}
