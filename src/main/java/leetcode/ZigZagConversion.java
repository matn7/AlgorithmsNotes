package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ZigZagConversion {

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        ZigZagConversion zigZagConversion = new ZigZagConversion();
        zigZagConversion.convert(s, s.length());

        int value = 123;


    }

    // O(n) time | O(n) space
    public String convert(String s, int numRows) {
        if (numRows == 0 || numRows >= s.length()) {
            return s;
        }
        Map<Integer, List<Character>> zigzagMap = new HashMap<>();
        int row = 0;
        int col = 0;
        int counter = 0;
        boolean goDown = true;
        while (counter < s.length()) {
            if (goDown) {
                if (!zigzagMap.containsKey(row)) {
                    zigzagMap.put(row, new ArrayList<>());
                }
                char currChar = s.charAt(counter);
                zigzagMap.get(row).add(currChar);
                counter++;
                row++;
                if (row == numRows) {
                    row--;
                    goDown = false;
                }
            } else {
                char currChar = s.charAt(counter);
                row--;
                zigzagMap.get(row).add(currChar);
                counter++;
                if (row == 0) {
                    row++;
                    goDown = true;
                }
            }
        }
        List<Character> chars = new ArrayList<>();
        for (Map.Entry<Integer, List<Character>> elem : zigzagMap.entrySet()) {
            chars.addAll(elem.getValue());
        }

        StringBuilder result = new StringBuilder();
        for (char element : chars) {
            result.append(element);
        }

        return result.toString();
    }

}
