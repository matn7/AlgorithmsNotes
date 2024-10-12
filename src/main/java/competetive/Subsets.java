package competetive;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public static void main(String[] args) {
        String str = "abc";

        subsets(str);
    }

    // O(n) time | O(n) space
    public static List<String> subsets(String str) {
        List<String> result = new ArrayList<>();

        int numbers = (int) Math.pow(2, str.length()) - 1;

        int BIT_MASK = 1;

        for (int i = 0; i < numbers; i++) {
            int value = i;
            int pos = 0;
            int idx = str.length() - 1;
            StringBuilder builder = new StringBuilder();
            while (value > 0) {
                if ((value & BIT_MASK) == 1) {
                    char c = str.charAt(idx - pos); // c
                    builder.append(c);
                }
                pos++;
                value = value >> 1;
            }
            result.add(builder.toString());
        }

        return result;
    }

    // O(2^n) time | O(2^n) space
    public static List<String> subsetsV2(String str) {
        List<String> result = new ArrayList<>();
        result.add("");
        subsetsHelper(str, result);
        return result;
    }

    private static void subsetsHelper(String str, List<String> result) {

        for (char c : str.toCharArray()) {
            int elements = result.size();
            for (int i = 0; i < elements; i++) {
                String current = result.get(i);
                result.add(current + c);
            }
        }

    }

}
