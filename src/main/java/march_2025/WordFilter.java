package march_2025;

import java.util.HashMap;
import java.util.Map;

public class WordFilter {

    public static void main(String[] args) {
        String[] word = {"apple"};
        WordFilter wordFilter = new WordFilter(word);
        int result = wordFilter.f("a", "e");
        System.out.println(result);

    }

    Map<String, Integer> map;

    public WordFilter(String[] words) {
        map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            String w = words[i];
            for (int j = 0; j < w.length(); j++) {
                String pref = w.substring(0, j + 1);
                for (int k = 0; k < w.length(); k++) {
                    String cur = pref + "$" + w.substring(k);
                    map.put(cur, i);
                }
            }
        }
    }

    public int f(String pref, String suff) {
        String s = pref + "$" + suff;
        return map.getOrDefault(s, -1);
    }

}
