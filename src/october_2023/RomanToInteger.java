package october_2023;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

    public static void main(String[] args) {
        String roman = "MCMXCIV";

        System.out.println(romanToInteger(roman));
    }

    static Map<Character, Integer> romanValues = new HashMap<>();

    static {
        romanValues.put('I', 1);
        romanValues.put('V', 5);
        romanValues.put('X', 10);
        romanValues.put('L', 50);
        romanValues.put('C', 100);
        romanValues.put('D', 500);
        romanValues.put('M', 1000);
    }

    // O(n) time | O(1) space
    public static int romanToInteger(String roman) {
        int sum = 0;
        int prev = 0;
        for (int i = roman.length() - 1; i >= 0; i--) {
            char c = roman.charAt(i); // 'C'
            Integer value = romanValues.get(c); // 100
            sum = prev < value ? sum + value : sum - value; // 994
            prev = value; // 1000
        }
        return sum;
    }

}
