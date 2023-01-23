package coderpro;

import java.util.HashMap;
import java.util.Map;

public class RomanNumeralsToDecimal {

    static Map<Character, Integer> romanNumerals = new HashMap<>();

    static {
        romanNumerals.put('I', 1);
        romanNumerals.put('V', 5);
        romanNumerals.put('X', 10);
        romanNumerals.put('L', 50);
        romanNumerals.put('C', 100);
        romanNumerals.put('D', 500);
        romanNumerals.put('M', 1000);
    }

    public static void main(String[] args) {
        String n = "MCMIV";
        RomanNumeralsToDecimal romanNumeralsToDecimal = new RomanNumeralsToDecimal();
        int result = romanNumeralsToDecimal.romanToInteger(n);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public int romanToInteger(String s) {
        int prev = 0;
        int sum = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            Integer curr = romanNumerals.get(s.charAt(i));

            sum = prev < curr ? sum + curr : sum - curr;
//            if (prev > curr) {
//                sum -= curr;
//            } else {
//                sum += curr;
//            }
            prev = curr;
        }
        return sum;
    }

}
