package january_2024;

import java.util.HashMap;
import java.util.Map;

public class RomanToNumbers {

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

    public static void main(String[] args) {
        String roman = "MCMIV";

        int result = romanToNumerals(roman);
        System.out.println(result);

    }

    // O(n) time | O(1) space
    public static int romanToNumerals(String roman) {
        int sum = 0;
        int prev = 0;
        for (int i = roman.length() - 1; i >= 0; i--) {
            char character = roman.charAt(i); // V
            Integer curr = romanMap.get(character); // 1

            sum = prev > curr ? sum - curr : sum + curr;

            prev = curr;
        }

        return sum;

    }

}
