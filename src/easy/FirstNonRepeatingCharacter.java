package easy;

import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeatingCharacter {

    public static void main(String[] args) {
        String string = "abcdcaf";
        FirstNonRepeatingCharacter firstNonRepeatingCharacter = new FirstNonRepeatingCharacter();
        firstNonRepeatingCharacter.firstNonRepeatingCharacter(string);
    }

    // OK - repeated 05/03/2022
    // O(n) time | O(1) space (at most 26 character see task input)
    public int firstNonRepeatingCharacter(String string) {
        // Write your code here.
        Map<Character, Integer> countMap = new HashMap<>();
        //                       i
        // string = [a b c d c a f]
        // countMap = {a : 2, b : 1, c : 2, d : 1, f : 1}
        for (int i = 0; i < string.length(); i++) {
            if (countMap.containsKey(string.charAt(i))) {
                countMap.put(string.charAt(i), countMap.get(string.charAt(i)) + 1);
            } else {
                countMap.put(string.charAt(i), 1);
            }
        }

        //                      *
        // countMap = {a : 2, b : 1, c : 2, d : 1, f : 1}
        char nonRepeat = 0;
        for (Map.Entry<Character, Integer> element : countMap.entrySet()) {
            if (element.getValue() == 1) {
                nonRepeat = element.getKey(); // b
                break;
            }
        }

        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == nonRepeat) { // b == b
                return i; // 1
            }
        }

        return -1;
    }

}
