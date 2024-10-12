package leetcode;

import java.util.HashMap;
import java.util.Map;

public class IntegerToRoman {

    public static void main(String[] args) {
        IntegerToRoman integerToRoman = new IntegerToRoman();
        String result = integerToRoman.intToRoman(1888);
        System.out.println(result);
    }

    static Map<Integer, String> romanCode = new HashMap<>();

    static {
        romanCode.put(1, "I");
        romanCode.put(5, "V");
        romanCode.put(10, "X");
        romanCode.put(50, "L");
        romanCode.put(100, "C");
        romanCode.put(500, "D");
        romanCode.put(1000, "M");
        romanCode.put(4, "IV");
        romanCode.put(9, "IX");
        romanCode.put(40, "XL");
        romanCode.put(90, "XC");
        romanCode.put(400, "CD");
        romanCode.put(900, "CM");
    }

    // O(1) time | O(1) space
    public String intToRoman(int num) {
        if (num < 1 || num > 3999) {
            return "";
        }
        if (romanCode.containsKey(num)) {
            return romanCode.get(num);
        }
        String numAsStr = String.valueOf(num);
        int mod = numAsStr.length();
        int div = mod - 1;
        int dec = 10;
        StringBuilder builder = new StringBuilder();
        for (int d = div; d >= 0; d--) {
            int modDenom = (int) Math.pow(dec, mod);
            int modPhase = num % modDenom;
            int divDenom = (int) Math.pow(dec, div);
            int divPhase = modPhase / divDenom;
            int code = divPhase * divDenom;
            if (romanCode.containsKey(code)) {
                builder.append(romanCode.get(code));
            } else {
                if (divPhase > 5) {
                    divPhase = divPhase - 5;
                    code = 5 * divDenom;
                    builder.append(romanCode.get(code));
                }
                for (int i = 0; i < divPhase; i++) {
                    code = divDenom;
                    builder.append(romanCode.get(code));
                }
            }
            mod--;
            div--;
        }
        String result = builder.toString();
        return result;
    }

}
