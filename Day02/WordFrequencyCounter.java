import java.io.*;
import java.util.*;

public class WordFrequencyCounter {
    public static void main(String[] args) throws IOException {
        Map<String, Integer> wordCount = new HashMap<>();
        BufferedReader br = new BufferedReader(new FileReader("example.txt"));
        String line;
        while ((line = br.readLine()) != null) {
            for (String word : line.toLowerCase().replaceAll("[^a-z ]", "").split(" ")) {
                if (!word.isEmpty()) {
                    wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                }
            }
        }
        br.close();
        
        System.out.print("Output: { ");
        Iterator<Map.Entry<String, Integer>> iterator = wordCount.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            System.out.print(entry.getKey() + "=" + entry.getValue());
            if (iterator.hasNext()) System.out.print(", ");
        }
        System.out.println(" }");
    }
}
