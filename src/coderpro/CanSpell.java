package coderpro;

import javax.security.auth.callback.CallbackHandler;
import java.util.HashMap;
import java.util.Map;

public class CanSpell {

    public static void main(String[] args) {
        String mag = "ABCDEF";
        String word = "BEDX";

        CanSpell canSpell = new CanSpell();
        boolean result = canSpell.canSpell(mag, word);
        System.out.println(result);
    }

    // O(n + m) time | O(26) -> O(1) space
    public boolean canSpell(String mag, String word) {
        Map<Character, Integer> magMap = prepareMap(mag);
        Map<Character, Integer> wordMap = prepareMap(word);

        for (Map.Entry<Character, Integer> entry : wordMap.entrySet()) {
            Character key = entry.getKey();
            Integer value = entry.getValue();
            if (!magMap.containsKey(key) || magMap.get(key) < value) {
                return false;
            }
        }

        return true;
    }

    private Map<Character, Integer> prepareMap(String word) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : word.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        return map;
    }

}
