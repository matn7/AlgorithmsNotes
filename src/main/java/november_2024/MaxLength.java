package november_2024;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MaxLength {

    public int maxLength(List<String> arr) {
        Set<Character> charSet = new HashSet<>();
        return backtrack(0, arr, charSet);
    }

    private boolean overlap(Set<Character> charSet, String s) {
        Set<Character> prev = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (charSet.contains(c) || prev.contains(c)) {
                return true;
            }
            prev.add(c);
        }
        return false;
    }

    private int backtrack(int i, List<String> arr, Set<Character> charSet) {
        if (i == arr.size()) {
            return charSet.size();
        }
        int res = 0;
        if (!overlap(charSet, arr.get(i))) {
            for (char c : arr.get(i).toCharArray()) {
                charSet.add(c);
            }
            res = backtrack(i + 1, arr, charSet);
            for (char c : arr.get(i).toCharArray()) {
                charSet.remove(c);
            }
        }

        return Math.max(res, backtrack(i + 1, arr, charSet));
    }


}
