import java.lang.reflect.Array;
import java.nio.file.Paths;
import java.util.*;

public class Freq implements Command{

    public ArrayList<String> findMostUseWords(String[] mots, int number)
    {
        ArrayList<String> mostUsed = new ArrayList<>();
        Map<String, Integer> dic = new LinkedHashMap<>();

        for (int i = 0; i < mots.length; i++) {
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
                if (value.compareTo(max) == 1) {
                    max = value;
                    maxS = (String)m.getKey();
                }
            }
            mostUsed.add(maxS);
            dic.replace(maxS, -1);
        }
        return mostUsed;
    }

    public String readFile(Scanner scanner)
    {
        System.out.println("Entrez un chemin de fichier : ");
        String fichier = scanner.nextLine();
        try {
            String contenu = java.nio.file.Files.readString(Paths.get(fichier));
            contenu = contenu.replaceAll("\\p{Punct}", " ");
            contenu = contenu.replaceAll("\\\n+", " ");
            contenu = contenu.replaceAll("\\\s+", " ");
            contenu = contenu.toLowerCase(Locale.ROOT);
            return contenu;
        } catch (Exception e) {
            System.out.println("Unreadable file: " + e.getClass().getName() + " " + e.getMessage());
        }
        return "";
    }

    @Override
    public String name() {
        return "freq";
    }

    @Override
    public boolean run(Scanner scanner) {
        String contenu = readFile(scanner);
        if (contenu.equals(""))
            return true;
        String[] mots = contenu.split(" ");
        ArrayList<String> mostUsed = findMostUseWords(mots, 3);
        System.out.println(mostUsed.get(0) + " " + mostUsed.get(1) + " " + mostUsed.get(2));
        return true;
    }
}
