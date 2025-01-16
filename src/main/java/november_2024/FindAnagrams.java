package november_2024;

import java.util.ArrayList;
import java.util.List;

public class FindAnagrams {

    public static void main(String[] args) {
//        String s = "cbaebabacd";
//        String p = "abc";

        String s = "abab";
        String p = "ab";

        FindAnagrams findAnagrams = new FindAnagrams();
        List<Integer> result = findAnagrams.findAnagrams(s, p);
        System.out.println(result);
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int[] phash = calculateHash(p.toCharArray());
        int index = 0;
        int[] shash = new int[26];
        while (index < s.length()) {
            int idx = s.charAt(index) - 'a';
            if (index >= p.length()) {
                if (compare(shash, phash)) {
                    result.add(index - p.length());
                }
                int idxToRemove = s.charAt(index - p.length()) - 'a';
                shash[idxToRemove]--;
            }
            shash[idx]++;
            index++;
        }
        if (compare(shash, phash)) {
            result.add(index - p.length());
        }
        return result;
    }

    private boolean compare(int[] a, int[] b) {
        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }

    private int[] calculateHash(char[] arr) {
        int[] hash = new int[26];
        for (int i = 0; i < arr.length; i++) {
            int idx = arr[i] - 'a';
            hash[idx]++;
        }
        return hash;
    }

}
