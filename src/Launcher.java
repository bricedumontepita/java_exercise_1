import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Launcher {

    public static void main(String[] args) {
        System.out.println("un texte de bienvenue");
        Scanner scanner = new Scanner(System.in);
        String entree = "";
        boolean running = true;
        while (running) {
            System.out.println("Entrez une commande : ");
            entree = scanner.nextLine();
            Command[] commands = {new Quit(), new Fibo(), new Freq()};
            boolean executed = false;
            for (int i = 0; i < commands.length && executed == false; i++) {
                if (entree.equals(commands[i].name())){
                    running = commands[i].run(scanner);
                    executed = true;
                }
            }
            if (executed == false) {
                System.out.println("Unknown command");
            }
        }
    }
}
