package january_2025;

public class LongestRepeatingChars {

    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int l = 0;
        int r = 0;
        int maxF = 0;
        int res = 0;

        while (r < s.length()) {
            char c = s.charAt(r);
            count[c - 'A']++;
//            maxF = Math.max(maxF, count[c - 'A']);

            for (int num : count) {
                maxF = Math.max(maxF, num);
            }

            while ((r - l + 1) - maxF > k) {
                count[s.charAt(l) - 'A']--;
                l++;
            }
            res = Math.max(res, r - l + 1);
            r++;
        }

        return res;
    }

}
