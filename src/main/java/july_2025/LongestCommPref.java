package july_2025;

public class LongestCommPref {

    public static void main(String[] args) {
        String[] strs = {"dog","racecar","car"};
        LongestCommPref longestCommPref = new LongestCommPref();
        String s = longestCommPref.longestCommonPrefix(strs);
        System.out.println(s);
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        StringBuilder builder = new StringBuilder();
        int idx = 0;
        while (true) {
            if (idx >= strs[0].length()) {
                return builder.toString();
            }
            char c = strs[0].charAt(idx);
            for (String str : strs) {
                if (idx >= str.length() || c != str.charAt(idx)) {
                    return builder.toString();
                }
            }
            builder.append(c);
            idx++;
        }
    }


}
