package september_2025;

public class ValidPalindrome {

    public static void main(String[] args) {
//        String s = "A man, a plan, a canal: Panama";
//        String s = "race a car";
        String s = "aa";
        ValidPalindrome validPalindrome = new ValidPalindrome();
        boolean result = validPalindrome.isPalindrome(s);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public boolean isPalindrome(String s) {
        if (s.isEmpty()) {
            return true;
        }
        return helper(s, 0, s.length() - 1);
    }

    private boolean helper(String s, int start, int end) {
        if (start == end) {
            return true;
        }
        while (start < end && !Character.isLetterOrDigit(s.charAt(start))) {
            start++;
        }
        while (end > start && !Character.isLetterOrDigit(s.charAt(end))) {
            end--;
        }
        if (start >= end) {
            return true;
        }
        if (Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))) {
            return false;
        }
        start++;
        end--;
        return helper(s, start, end);
    }

    // O(n) time | O(1) space
    public boolean isPalindrome2(String s) {
        if (s.isEmpty()) {
            return true;
        }
        int start = 0;
        int end = s.length() - 1;

        while (start <= end) {
            while (start < end && !Character.isLetterOrDigit(s.charAt(start))) {
                start++;
            }
            while (end > start && !Character.isLetterOrDigit(s.charAt(end))) {
                end--;
            }
            if (start == end) {
                return true;
            }
            if (Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }


}
