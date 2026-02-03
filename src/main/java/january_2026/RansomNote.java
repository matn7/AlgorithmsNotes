package january_2026;

import java.util.HashMap;
import java.util.Map;

public class RansomNote {

    // O(n + m) time | O(1) space
    public boolean canConstruct(String ransomNote, String magazine) {
        // bbbbbccd
        int[] requiredFrequency = new int[26];
        for (char c : ransomNote.toCharArray()) {
            requiredFrequency[c - 'a']++;
        }
        // bbbbcccdefg
        int[] inventory = new int[26];
        for (char c : magazine.toCharArray()) {
            inventory[c - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (requiredFrequency[i] > inventory[i]) {
                return false;
            }
        }
        return true;
    }

    // O(n + m) time | O(n + m) space
    public boolean canConstruct2(String ransomNote, String magazine) {
        Map<Character, Integer> requiredFrequency = new HashMap<>();
        for (char c : ransomNote.toCharArray()) {
            requiredFrequency.put(c, requiredFrequency.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> inventory = new HashMap<>();
        for (char c : magazine.toCharArray()) {
            inventory.put(c, inventory.getOrDefault(c, 0) + 1);
        }

        for (Map.Entry<Character, Integer> element : requiredFrequency.entrySet()) {
            char key = element.getKey();
            int value = element.getValue();
            // either there are no elements in the inventory or
            // they are elements but not enough
            if (!inventory.containsKey(key) || inventory.get(key) < value) {
                return false;
            }
        }
        return true;
    }

}
