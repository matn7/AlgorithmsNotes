package november_2024;

import java.util.HashMap;
import java.util.Map;

public class LongestCommonPrefix2 {

    public static void main(String[] args) {
        String[] strs = { "ab", "a" };

        LongestCommonPrefix2 longestCommonPrefix = new LongestCommonPrefix2();
        String result = longestCommonPrefix.longestCommonPrefix(strs);
        System.out.println(result);
    }

    public String longestCommonPrefix(String[] strs) {
        StringBuilder builder = new StringBuilder();
        String str = strs[0];

        // [ "flower", "flow", "flowight" ]

        for (int i = 0; i < str.length(); i++) {
            char curr = str.charAt(i);
            boolean found = true;
            for (int j = 1; j < strs.length; j++) {
                String s = strs[j];
                if (i >= s.length() || s.charAt(i) != curr) {
                    found = false;
                    break;
                }
            }
            if (found) {
                builder.append(curr);
            } else {
                break;
            }
        }

        return builder.toString();
    }


}
