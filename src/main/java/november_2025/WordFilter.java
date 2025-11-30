package november_2025;

import java.util.HashMap;
import java.util.Map;

public class WordFilter {

    // O(n * m^3) time | O(m) space
    Map<String, Integer> map;

    public WordFilter(String[] words) {
        map = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (int j = 0; j < word.length(); j++) {
                String prefix = word.substring(0, j + 1);
                for (int k = 0; k < word.length(); k++) {
                    String suffix = word.substring(k);
                    String curr = prefix + "$" + suffix;
                    map.put(curr, i);
                }
            }
        }

    }

    public int f(String pref, String suff) {
        String key = pref + "$" + suff;
        return map.getOrDefault(key, -1);
    }

}
