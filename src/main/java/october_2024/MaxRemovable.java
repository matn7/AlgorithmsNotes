package october_2024;

import java.util.HashSet;
import java.util.Set;

public class MaxRemovable {

    public static void main(String[] args) {
        String s = "abcacb";
        String p = "ab";
        int[] removable = {3, 1, 0};

        MaxRemovable maxRemovable = new MaxRemovable();
        int result = maxRemovable.maximumRemovals(s, p, removable);
        System.out.println(result);
    }

    // O(nlog(k)) time
    public int maximumRemovals(String s, String p, int[] removable) {
        int res = 0;
        int l = 0;
        int r = removable.length - 1;

        while (l <= r) {
            int m = (l + r) / 2;
            Set<Integer> removed = new HashSet<>();
            for (int i = 0; i <= m; i++) {
                removed.add(removable[i]);
            }
            if (isSubseq(s, p, removed)) {
                res = Math.max(res, m + 1);
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return res;
    }

    private boolean isSubseq(String s, String subseq, Set<Integer> removed) {
        int i1 = 0;
        int i2 = 0;

        while (i1 < s.length() && i2 < subseq.length()) {
            if (removed.contains(i1) || s.charAt(i1) != subseq.charAt(i2)) {
                i1++;
                continue;
            }
            i1++;
            i2++;
        }
        return i2 == subseq.length();
    }


    public int maximumRemovals2(String s, String p, int[] removable) {
        int count = 0;
        char[] sChars = s.toCharArray();

        for (int r = 0; r < removable.length; r++) {
            int rIdx = removable[r];
            sChars[rIdx] = '#';
            //  0 1 2 3 4 5
            // "a b c # c b"
            int sIdx = 0;
            int pIdx = 0;
            while (pIdx < p.length() && sIdx < s.length()) {
                if (sChars[sIdx] == '#') {
                    sIdx++;
                }
                if (sIdx < s.length() && sChars[sIdx] == p.charAt(pIdx)) {
                    sIdx++;
                    pIdx++;
                } else {
                    sIdx++;
                }
            }
            if (pIdx < p.length()) {
                break;
            }
            count++;
        }

        return count;
    }

}
