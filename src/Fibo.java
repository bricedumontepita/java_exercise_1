import java.util.Scanner;

public class Fibo implements Command {
    @Override
    public String name() {
        return "fibo";
    }

    @Override
    public boolean run(Scanner scanner) {
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
        return true;
    }
}
