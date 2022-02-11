import java.nio.file.Paths;
import java.util.*;

public class Predict extends Freq implements Command {

    public ArrayList<String> findWordsAfter(String word, String[] words)
    {
        ArrayList<String> afterWords = new ArrayList<>();
        for (int i = 0; i < words.length - 1; i++)
        {
            if (words[i].equals(word)) {
                afterWords.add(words[i + 1]);
            }
        }
        return afterWords;
    }

    public void demandeMot(Map<String, String> dic, Scanner scanner) {
        System.out.println("Entrez un mot : ");
        String mot = scanner.nextLine();
        mot = mot.toLowerCase(Locale.ROOT);
        if (!dic.containsKey(mot))
        {
            System.out.println("Aucune prédiction pour ce mot");
            return;
        }
        int limit = 20;
        while (limit > 0 && dic.containsKey(mot))
        {
            mot = dic.get(mot);
            System.out.print(mot + (dic.containsKey(mot) ? " " : ""));
            limit--;
        }
        System.out.println("");
    }

    @Override
    public String name() {
        return "predict";
    }

    @Override
    public boolean run(Scanner scanner) {
        String contenu = readFile(scanner);
        if (contenu.equals(""))
            return true;
        String[] mots = contenu.split(" ");
        // on récupère les mots après pour chaque mots
        Map<String, String> dic = new HashMap<>();

        for (int i = 0; i < mots.length; i++) {

            if (!dic.containsKey(mots[i]))
            {
                ArrayList<String>  afterWords = findWordsAfter(mots[i], mots);

                String afterWordsString[] = new String[afterWords.size()];
                Object[] objArr = afterWords.toArray();
                int k = 0;
                for (Object obj : objArr) {
                    afterWordsString[k++] = (String)obj;
                }
                ArrayList<String> mostUsed = findMostUseWords(afterWordsString, 1);
                dic.put(mots[i], mostUsed.get(0));
            }
        }
        demandeMot(dic, scanner);
        return true;
    }
}
