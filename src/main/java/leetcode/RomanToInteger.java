package leetcode;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

    public static void main(String[] args) {
        RomanToInteger romanToInteger = new RomanToInteger();

//        String roman = "MDCCCLXXXVIII";
        String roman = "MCMXCIV";
//        String roman = "LVIII";
//        String roman = "III";
        int result = romanToInteger.romanToInt(roman);
        System.out.println(result);
    }

    static Map<String, Integer> romanCode = new HashMap<>();

    static {
        romanCode.put("I", 1);
        romanCode.put("V", 5);
        romanCode.put("X", 10);
        romanCode.put("L", 50);
        romanCode.put("C", 100);
        romanCode.put("D", 500);
        romanCode.put("M", 1000);
        romanCode.put("IV", 4);
        romanCode.put("IX", 9);
        romanCode.put("XL", 40);
        romanCode.put("XC", 90);
        romanCode.put("CD", 400);
        romanCode.put("CM", 900);
    }

    // O(1) time | O(1) space
    public int romanToInt(String s) {
        if (s.length() == 1) {
            return romanCode.get(s);
        }

        int sum = 0;
        int index = 0;
        while (index < s.length()) {
            String current = String.valueOf(s.charAt(index));
            int count = 0;
            while (index < s.length() && current.equals(String.valueOf(s.charAt(index)))) {
                index++;
                count++;
            }
            if (index < s.length() && romanCode.containsKey(current + s.charAt(index))) {
                String code = current + s.charAt(index);
                sum += romanCode.get(code);
                index++;
            } else {
                String code = current;
                int value = count * romanCode.get(code);
                sum += value;
            }
        }

        return sum;
    }

}
