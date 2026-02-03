package january_2026;

import java.util.HashMap;
import java.util.Map;

public class WordFilter {

    public static void main(String[] args) {
        String[] words = {"apple"};

        WordFilter wordFilter = new WordFilter(words);
        int result = wordFilter.f("a", "e");
        System.out.println(result);

    }

    private Map<String, Integer> map;

    public WordFilter(String[] words) {
        map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            String w = words[i];
            for (int j = 0; j < w.length(); j++) {
                String pref = w.substring(0, j + 1);
                for (int k = 0; k < w.length(); k++) {
                    String curr = pref + "$" + w.substring(k);
                    map.put(curr, i);
                }
            }
        }
    }

    public int f(String pref, String suff) {
        String s = pref + "$" + suff;
        return map.getOrDefault(s, -1);
    }

}
