package april_2025;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

    public static void main(String[] args) {
        String s = "MCMXCIV";
        RomanToInteger romanToInteger = new RomanToInteger();
        int result = romanToInteger.romanToInt(s);
        System.out.println(result);
    }

    static Map<Character, Integer> romanMap = new HashMap<>();

    static {
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);
    }

    // O(n) time | O(1) space
    public int romanToInt(String s) {
        int value = romanMap.get(s.charAt(s.length() - 1));

        for (int i = s.length() - 2; i >= 0; i--) {
            char prev = s.charAt(i + 1);
            char curr = s.charAt(i);
            int prevVal = romanMap.get(prev);
            int currVal = romanMap.get(curr);
            if (currVal < prevVal) {
                value -= currVal;
            } else {
                value += currVal;
            }
        }

        return value;
    }

}
