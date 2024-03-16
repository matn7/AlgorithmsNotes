package october_2023;

import java.util.HashMap;
import java.util.Map;

public class RomanNumeralsToDecimal {

    static Map<Character, Integer> romanNumerals = new HashMap<>();
    static {
        romanNumerals.put('I', 1);
        romanNumerals.put('V', 5);
        romanNumerals.put('X', 10);
        romanNumerals.put('C', 100);
        romanNumerals.put('D', 500);
        romanNumerals.put('M', 1000);
    }

    public static void main(String[] args) {
        String roman = "MCMIV";
        romanToDecimal(roman);
    }

    // O(n) time | O(1) space
    public static int romanToDecimal(String roman) {
        int sum = 0;
        int prev = 0;
        for (int i = roman.length() - 1; i >= 0; i--) {
            char c = roman.charAt(i);
            Integer curr = romanNumerals.get(c); // 1000
            sum = prev < curr ? sum + curr : sum - curr; // 1904
            prev = curr; // 100
        }

        return sum;
    }

}
