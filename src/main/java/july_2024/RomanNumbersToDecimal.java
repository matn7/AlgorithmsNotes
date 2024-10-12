package july_2024;

import java.util.HashMap;
import java.util.Map;

public class RomanNumbersToDecimal {

    public static void main(String[] args) {
        String s = "MCMIV";
        int result = romanToDecimal(s);
        System.out.println(result);
    }

    static Map<Character, Integer> romanNumerals = new HashMap<>();
    static {
        romanNumerals.put('I', 1);
        romanNumerals.put('V', 5);
        romanNumerals.put('X', 10);
        romanNumerals.put('C', 100);
        romanNumerals.put('D', 500);
        romanNumerals.put('M', 1000);
    }

    // O(n) time | O(1) space
    public static int romanToDecimal(String s) {
        int prev = 0;
        int sum = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            Integer curr = romanNumerals.get(s.charAt(i));
            sum = prev < curr ? sum + curr : sum - curr;
            prev = curr;
        }
        return sum;
    }

}
