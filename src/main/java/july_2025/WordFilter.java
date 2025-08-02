package july_2025;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WordFilter {

    public static void main(String[] args) {
        String[] words = {"apple"};

        WordFilter wordFilter = new WordFilter(words);
        int result = wordFilter.f("a", "e");
        System.out.println(result);
    }

    // O(n * m^3) time | O(m) space
    // n - num of words, m - avg len of each word
    private Map<String, Integer> mp;

    public WordFilter(String[] words) {
        mp = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            String w = words[i];
            for (int j = 0; j < w.length(); j++) {
                String pref = w.substring(0, j + 1);
                for (int k = 0; k < w.length(); k++) {
                    String cur = pref + "$" + w.substring(k);
                    mp.put(cur, i);
                }
            }
        }
    }

    public int f(String pref, String suff) {
        String s = pref + "$" + suff;
        return mp.getOrDefault(s, -1);
    }

}
