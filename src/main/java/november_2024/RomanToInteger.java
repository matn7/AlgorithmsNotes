package november_2024;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

    public static void main(String[] args) {
//        String s = "MCMXCIV";
        String s = "III";

        RomanToInteger romanToInteger = new RomanToInteger();
        int result = romanToInteger.romanToInt(s);
        System.out.println(result);
    }

    static Map<Character, Integer> roman = new HashMap<>();

    static {
        roman.put('I', 1);
        roman.put('V', 5);
        roman.put('X', 10);
        roman.put('L', 50);
        roman.put('C', 100);
        roman.put('D', 500);
        roman.put('M', 1000);
    }

    public int romanToInt(String s) {
        int sum = 0;
        int prev = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            int num = roman.get(c);
            if (prev <= num) {
                sum += num;
            } else {
                sum -= num;
            }
            prev = num;
        }
        return sum;
    }

}
