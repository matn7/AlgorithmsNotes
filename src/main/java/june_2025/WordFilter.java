package june_2025;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordFilter {

    public static void main(String[] args) {
        String[] words = {"apple"};
        WordFilter wordFilter = new WordFilter(words);

        int result = wordFilter.f("a", "e");
        System.out.println(result);


    }

    // O(n * m^3) time | O(n * m^3) space
    private Map<String, Integer> mp;

    public WordFilter(String[] words) {
        mp = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            String w = words[i];
            for (int j = 0; j < w.length(); j++) {
                String pref = w.substring(0, j + 1);
                for (int k = 0; k < w.length(); k++) {
                    String suff = w.substring(k);
                    String key = pref + "$" + suff;
                    mp.put(key, i);
                }
            }
        }
    }

    public int f(String pref, String suff) {
        String key = pref + "$" + suff;
        return mp.getOrDefault(key, -1);
    }

}
