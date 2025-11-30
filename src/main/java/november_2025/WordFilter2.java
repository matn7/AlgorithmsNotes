package november_2025;

import java.util.HashMap;
import java.util.Map;

public class WordFilter2 {

    // O(n * m^3) time | O(n * m^3) space
    private Map<String, Integer> map;

    public WordFilter2(String[] words) {
        map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            String w = words[i];
            for (int j = 0; j < w.length(); j++) {
                String pref = w.substring(0, j + 1);
                for (int k = 0; k < w.length(); k++) {
                    String suff = w.substring(k);
                    String curr = pref + "$" + suff;
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
