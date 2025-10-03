package september_2025;

public class InterleavingString {

    public static void main(String[] args) {
        String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac";
        InterleavingString interleavingString = new InterleavingString();
        boolean result = interleavingString.isInterleave(s1, s2, s3);
        System.out.println(result);
    }

    // O(n * m) time | O(n * m) space
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        int[][] cache = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i < cache.length; i++) {
            for (int j = 0; j < cache[i].length; j++) {
                cache[i][j] = -1;
            }
        }
        return helper(s1, 0, s2, 0, s3, cache);
    }

    private boolean helper(String s1, int i, String s2, int j, String s3, int[][] cache) {
        if (i + j == s3.length()) {
            return true;
        }
        if (cache[i][j] != 0) {
            return cache[i][j] == 1;
        }
        int k = i + j;
        boolean res = false;
        if (i < s1.length() && s1.charAt(i) == s3.charAt(k)) {
            res = helper(s1, i + 1, s2, j, s3, cache);
            if (res) {
                return true;
            }
        }
        if (j < s2.length() && s2.charAt(j) == s3.charAt(k) && !res) {
            res = helper(s1, i, s2, j + 1, s3, cache);
        }
        cache[i][j] = res ? 1 : 0;
        return res;
    }

}
