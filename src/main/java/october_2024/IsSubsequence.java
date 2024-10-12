package october_2024;

public class IsSubsequence {

    public static void main(String[] args) {
        String s = "axc";
        String t = "ahbgdc";

        IsSubsequence isSubsequence = new IsSubsequence();

        boolean result = isSubsequence.isSubsequence(s, t);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public boolean isSubsequence(String s, String t) {
        int first = 0;
        int second = 0;

        while (first < s.length() && second < t.length()) {
            if (s.charAt(first) == t.charAt(second)) {
                first++;
            }
            second++;
        }
        return first == s.length();
    }

}
