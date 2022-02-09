import java.util.Scanner;

public class Launcher {
    public static void main(String[] args) {
        System.out.println("un texte de bienvenue");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrez une commande : ");
        String entree = scanner.nextLine();
        if (!entree.equals("quit")) {
            System.out.println("Unknown command");
        }
    }
}
