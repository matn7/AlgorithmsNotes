package january_2026;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

    public static void main(String[] args) {
        String s = "MCMXCIV";

        RomanToInteger romanToInteger = new RomanToInteger();
        int result = romanToInteger.romanToInt(s);
        System.out.println(result);
    }

    static Map<Character, Integer> romanNumbers;

    static {
        romanNumbers = new HashMap<>();
        romanNumbers.put('I', 1);
        romanNumbers.put('V', 5);
        romanNumbers.put('X', 10);
        romanNumbers.put('L', 50);
        romanNumbers.put('C', 100);
        romanNumbers.put('D', 500);
        romanNumbers.put('M', 1000);
    }

    // O(n) time | O(1) space
    public int romanToInt(String s) {
        int sum = 0;
        int prev = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            char curr = s.charAt(i);
            int curNum = romanNumbers.get(curr);

            if (curNum >= prev) {
                sum += curNum;
            } else {
                sum -= curNum;
            }
            prev = curNum;
        }
        return sum;
    }


}
