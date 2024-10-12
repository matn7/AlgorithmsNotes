package leetcode;

public class IsPalindrome {

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        String intAsString = String.valueOf(x);
        int start = 0;
        int end = intAsString.length() - 1;

        while (start < end) {
            if (intAsString.charAt(start) != intAsString.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

}
