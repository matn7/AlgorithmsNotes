package july_2024;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    public static void main(String[] args) {
        String s = "aab";

        List<List<String>> partition = partition(s);
        System.out.println(partition);
    }

    // O(n*2^n) time | O(2^n) space
    public static List<List<String>> partition(String s) {
        List<List<String>> answer = new ArrayList<>();
        solution(s, new ArrayList<>(), answer);
        return answer;
    }

    private static void solution(String s, List<String> currArr, List<List<String>> answer) {
        if (s.length() == 0) {
            answer.add(new ArrayList<>(currArr));
        }
        for (int i = 1; i <= s.length(); i++) {
            String currString = s.substring(0, i);
            if (isPalindrome(currString)) {
                currArr.add(currString);
                solution(s.substring(i), currArr, answer);
                currArr.remove(currArr.size() - 1);
            }
        }
    }

    private static boolean isPalindrome(String s) {
        if (s.length() == 1) {
            return true;
        }
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

}
