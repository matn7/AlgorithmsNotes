package leetcode;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};

        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        String result = longestCommonPrefix.longestCommonPrefix(strs);
        System.out.println(result);
    }

    // O(n * m) time | O(1) space (n is strs.length and m is strs[0].length)
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) {
            return strs[0];
        }

        String first = strs[0];
        int[] sub = new int[]{0, -1};
        for (int idx = 0; idx < first.length(); idx++) {
            boolean breakCheck = false;
            char toCompare = first.charAt(idx);
            for (int i = 0; i < strs.length; i++) {
                String current = strs[i];
                if (idx > current.length() - 1) {
                    breakCheck = true;
                    break;
                }
                char currChar = current.charAt(idx);
                if (toCompare != currChar) {
                    breakCheck = true;
                    break;
                }
            }
            if (breakCheck) {
                break;
            }
            sub[1] = idx;
        }
        return first.substring(sub[0], sub[1] + 1);
    }
    
}
