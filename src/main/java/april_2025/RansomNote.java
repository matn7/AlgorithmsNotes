package april_2025;

import october_2024.CoinChange;

import java.util.HashMap;
import java.util.Map;

public class RansomNote {

    public static void main(String[] args) {

    }

    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> magazineFreq = new HashMap<>();
        Map<Character, Integer> noteFreq = new HashMap<>();

        for (char c : ransomNote.toCharArray()) {
            noteFreq.put(c, noteFreq.getOrDefault(c, 0) + 1);
        }

        for (char c : magazine.toCharArray()) {
            magazineFreq.put(c, magazineFreq.getOrDefault(c, 0) + 1);
        }

        for (Map.Entry<Character, Integer> elem : noteFreq.entrySet()) {
            char c = elem.getKey();
            int freq = elem.getValue();

            if (!magazineFreq.containsKey(c) || magazineFreq.get(c) < freq) {
                return false;
            }
        }
        return true;
    }

}
