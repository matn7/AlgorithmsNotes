package november_2024;

public class PermutationInString {

    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidboaoooab";

        PermutationInString permutation = new PermutationInString();
        boolean result = permutation.checkInclusion(s1, s2);
        System.out.println(result);
    }

    public boolean checkInclusion(String s1, String s2) {
        int[] perHash = createHash(s1);

        int[] strHash = new int[26];

        for (int i = 0; i < s2.length(); i++) {
            int idx = s2.charAt(i) - 'a';
            if (i >= s1.length()) {
                if (compare(perHash, strHash)) {
                    return true;
                }
                int toRemove = s2.charAt(i - s1.length()) - 'a';
                strHash[toRemove]--;

            }
            strHash[idx]++;
        }
        return compare(perHash, strHash);
    }

    private boolean compare(int[] a, int[] b) {
        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }

    private int[] createHash(String s) {
        int[] hash = new int[26];

        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';
            hash[idx]++;
        }

        return hash;
    }

}
