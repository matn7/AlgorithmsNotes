package december_2024;

public class LongestRepeatingCharacterReplacement {

    public static void main(String[] args) {
//        String s = "ABABBACCCCCCCDCD";
//        int k = 2;

        String s = "BAAA";
        int k = 0;

        LongestRepeatingCharacterReplacement replacement = new LongestRepeatingCharacterReplacement();
        int result = replacement.characterReplacement2(s, k);
        System.out.println(result);
    }

    // ********
    // * STAR *
    // ********

    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int l = 0;
        int r = 0;
        int res = 0;
        while (r < s.length()) {
            char c = s.charAt(r);
            count[c - 'A']++;
            int max = Integer.MIN_VALUE;
            int idx = 0;
            // find min in count
            for (int i = 0; i < count.length; i++) {
                if (count[i] != 0) {
                    if (count[i] > max) {
                        idx = i;
                        max = count[i];
                    }
                }
            }
            int winLen = r - l + 1;
            if (winLen - count[idx] <= k) {
                res = winLen;
            } else {
                count[s.charAt(l) - 'A']--;
                l++;
            }
            r++;
        }

        return res;
    }


    public int characterReplacement2(String s, int k) {
        int[] count = new int[26];
        int l = 0;
        int r = 0;
        int res = 0;
        int maxf = 0;
        while (r < s.length()) {
            char c = s.charAt(r);
            count[c - 'A']++;
            maxf = Math.max(maxf, count[c - 'A']);

            while ((r - l + 1) - maxf > k) {
                count[s.charAt(l) - 'A']--;
                l++;
            }
            r++;
        }
        return res;
    }


}
