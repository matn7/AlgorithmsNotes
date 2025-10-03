package september_2025;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

    public static void main(String[] args) {
//        String s = "MCMXCIV";

        String s = "LVIII";

        RomanToInteger romanToInteger = new RomanToInteger();
        int result = romanToInteger.romanToInt(s);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public int romanToInt(String s) {
        Map<Character, Integer> roman = new HashMap<>();
        roman.put('I', 1);
        roman.put('V', 5);
        roman.put('X', 10);
        roman.put('L', 50);
        roman.put('C', 100);
        roman.put('D', 500);
        roman.put('M', 1000);
        int sum = roman.get(s.charAt(s.length() - 1));

        for (int i = s.length() - 2; i >= 0; i--) {
            char prev = s.charAt(i + 1);
            char curr = s.charAt(i);
            int prevVal = roman.get(prev);
            int currVal = roman.get(curr);

            if (prevVal > currVal) {
                sum -= currVal;
            } else {
                sum += currVal;
            }
        }
        return sum;
    }

}
