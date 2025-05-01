package april_2025;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramsInString {

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";

        FindAllAnagramsInString findAllAnagramsInString = new FindAllAnagramsInString();
        List<Integer> result = findAllAnagramsInString.findAnagrams(s, p);
        System.out.println(result);
    }

    // O(n + m) time | O(n + m) space
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int[] pattern = new int[26];
        int[] str = new int[26];

        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            pattern[c - 'a']++;
        }
        int L = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (i < p.length()) {
                str[c - 'a']++;
            } else {
                // compare pattern with str
                boolean match = true;
                for (int j = 0; j < 26; j++) {
                    if (pattern[j] != str[j]) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    result.add(L);
                }
                str[c - 'a']++;
                str[s.charAt(L) - 'a']--;
                L++;
            }
        }
        boolean match = true;
        for (int j = 0; j < 26; j++) {
            if (pattern[j] != str[j]) {
                match = false;
                break;
            }
        }
        if (match) {
            result.add(L);
        }

        return result;
    }

}
