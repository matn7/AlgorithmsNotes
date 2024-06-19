package april_2024;

public class Palindrome {

    public static void main(String[] args) {

        System.out.println(palindrome("race car"));
        System.out.println(palindrome("aba"));
        System.out.println(palindrome("a"));
        System.out.println(palindrome(""));
        System.out.println(palindrome("abaa"));
        System.out.println(palindrome("A man, a plan, a canal: Panama"));
        System.out.println();

        System.out.println(palindrome2("race car"));
        System.out.println(palindrome2("aba"));
        System.out.println(palindrome2("a"));
        System.out.println(palindrome2(""));
        System.out.println(palindrome2("abaa"));
        System.out.println(palindrome2("A man, a plan, a canal: Panama"));
    }

    // O(n) time | O(n) space
    public static boolean palindrome(String str) {
        if (str.isEmpty()) {
            return true;
        }
        str = str.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        int startIdx = 0;
        int endIdx = str.length() - 1;
        if (str.charAt(startIdx) == str.charAt(endIdx)) {
            if (startIdx == endIdx) {
                return true;
            }
            return palindrome(str.substring(startIdx + 1, endIdx));
        }
        return false;
    }

    // O(n) time | O(1) space
    public static boolean palindrome2(String str) {
        if (str.isEmpty()) {
            return true;
        }
        str = str.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}
