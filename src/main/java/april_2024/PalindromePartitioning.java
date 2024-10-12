package april_2024;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {


    public static void main(String[] args) {
        String s = "aab";

        List<List<String>> partition = partition(s);
        System.out.println(partition);

        boolean result = isPalindromeRec("anbna");
        System.out.println(result);
    }

    // O(n * 2^n) time | O(2^n) space (call stack)
    public static List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        solution(s, new ArrayList<>(), ans);
        return ans;
    }

    private static void solution(String s, List<String> currArr, List<List<String>> ans) {
        if (s.length() == 0) {
            ans.add(new ArrayList<>(currArr));
        }

        for (int i = 1; i <= s.length(); i++) {
            String currString = s.substring(0, i);
            if (isPalindrome(currString)) {
                currArr.add(currString);
                solution(s.substring(i), currArr, ans);
                currArr.remove(currArr.size() - 1);
            }
        }
    }

    private static boolean isPalindromeRec(String s) {
        if (s.length() <= 1) {
            return true;
        }
        if (s.charAt(0) != s.charAt(s.length() - 1)) {
            return false;
        }
        return isPalindromeRec(s.substring(1,s.length() - 1));
    }

    private static boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;

        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }


}
