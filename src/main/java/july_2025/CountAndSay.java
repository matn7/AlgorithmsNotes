package july_2025;

import java.util.*;

public class CountAndSay {

    public static void main(String[] args) {
        CountAndSay countAndSay = new CountAndSay();
        String s = countAndSay.countAndSay(5);
        System.out.println(s);
    }

    // O(2^n) time | O(2^n) space
    public String countAndSay(int n) {
        return helper(n, "1");
    }

    private String helper(int n, String str) {
        if (n == 1) {
            return str;
        }

        List<String> counts = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < str.length()) {
            while (j < str.length() && str.charAt(i)==str.charAt(j)) {
                j++;
            }
            counts.add(String.valueOf(j - i));
            counts.add(String.valueOf(str.charAt(i)));
            i = j;
        }

        StringBuilder builder = new StringBuilder();
        for (String s : counts) {
            builder.append(s);
        }

        return helper(n - 1, builder.toString());
    }

}
