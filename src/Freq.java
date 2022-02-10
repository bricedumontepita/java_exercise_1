import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class Freq implements Command{
    public static String[] findMostUseWords(String[] mots, int number)
    {
        String[] mostUsed = new String[number];
        Map<String, Integer> dic = new HashMap<>();
        for (int i = 0; i < mots.length - 1; i++) {
            if (dic.containsKey(mots[i]))
            {
                dic.replace(mots[i], dic.get(mots[i])  + 1);
            }
            else
            {
                dic.put(mots[i], 1);
            }
        }
        // get max
        for (int i = 0; i < number; i++)
        {
            Integer max = 0;
            String maxS = "";
            for (Map.Entry m : dic.entrySet()) {
                Integer value = (Integer)m.getValue();
                if (Integer.compare(value , max) > 0) {
                    max = value;
                    maxS = (String)m.getKey();
                }
            }
            mostUsed[i] = maxS;
            dic.replace(maxS, -1);
        }

        return mostUsed;
    }

    @Override
    public String name() {
        return "freq";
    }

    @Override
    public boolean run(Scanner scanner) {
        System.out.println("Entrez un chemin de fichier : ");
        String fichier = scanner.nextLine();
        try {
            String contenu = java.nio.file.Files.readString(Paths.get(fichier));
            contenu = contenu.replaceAll("\\p{Punct}", " ");
            contenu = contenu.replaceAll("\\\n+", " ");
            contenu = contenu.replaceAll("\\\s+", " ");
            contenu = contenu.toLowerCase(Locale.ROOT);
            String[] mots = contenu.split(" ");
            String[] mostUsed = findMostUseWords(mots, 3);
            System.out.println(mostUsed[0] + " " + mostUsed[1] + " " + mostUsed[2]);
        } catch (Exception e) {
            System.out.println("Unreadable file: " + e.getClass().getName() + " " + e.getMessage());
        }
        return true;
    }
}
