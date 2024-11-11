package november_2024;

import java.util.ArrayList;
import java.util.List;

public class ZigZag {

    public static void main(String[] args) {
        ZigZag zigZag = new ZigZag();

        String s = "PAYPALISHIRING";
        int numRows = 3;
        String convert = zigZag.convert(s, numRows);
        System.out.println(convert);
    }

    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        boolean increasing = false;
        List<List<Character>> chars = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            chars.add(new ArrayList<>());
        }
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            chars.get(index).add(c);
            if (index == numRows - 1 || index == 0) {
                increasing = !increasing;
            }
            if (increasing) {
                index++;
            } else {
                index--;
            }
        }
        StringBuilder builder = new StringBuilder();
        for (List<Character> aChar : chars) {
            for (Character character : aChar) {
                builder.append(character);
            }
        }

        return builder.toString();
    }

}
