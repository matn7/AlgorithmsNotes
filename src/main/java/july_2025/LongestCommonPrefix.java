package july_2025;

public class LongestCommonPrefix {

    public static void main(String[] args) {
//        String[] strs = {"flower","flow","flight"};

        String[] strs = {"dog","racecar","car"};

        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        String s = longestCommonPrefix.longestCommonPrefix(strs);
        System.out.println(s);
    }

    // O(n * p) time | O(p) space
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) {
            return strs[0];
        }

        StringBuilder result = new StringBuilder();
        int idx = 0;
        while (true) {
            if (idx == strs[0].length()) {
                return result.toString();
            }

            char curr = strs[0].charAt(idx);
            for (String str : strs) {
                if (idx == str.length() || str.charAt(idx) != curr) {
                    return result.toString();
                }
            }
            result.append(curr);
            idx++;
        }
    }

}
