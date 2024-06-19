package april_2024;

public class AlmostPalindrome {

    public static void main(String[] args) {
        String str1 = "raceacar"; // true
        String str2 = "abccdba"; // true
        String str3 = "abcdefdba"; // false
        String str4 = ""; // true
        String str5 = "a"; // true
        String str6 = "ab"; // true

        System.out.println(isAlmostPalindrome(str1));
        System.out.println(isAlmostPalindrome(str2));
        System.out.println(isAlmostPalindrome(str3));
        System.out.println(isAlmostPalindrome(str4));
        System.out.println(isAlmostPalindrome(str5));
        System.out.println(isAlmostPalindrome(str6));

    }

    // O(n) time | O(1) space
    public static boolean isAlmostPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return validSubPalindrome(s, left + 1, right) || validSubPalindrome(s, left, right - 1);
            }
            left++;
            right--;
        }
        return true;
    }

    private static boolean validSubPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // O(n) time | O(1) space
    public static boolean almostPalindrome(String str) {
        if (str.length() <= 2) {
            return true;
        }
        int left  = 0;
        int right = str.length() - 1;
        StringBuilder leftStr = new StringBuilder();
        StringBuilder rightStr = new StringBuilder();

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                generateString(str, left, leftStr);
                generateString(str, right, rightStr);
                break;
            }
            left++;
            right--;
        }

        return palindrome(leftStr.toString(), left, right-1) || palindrome(rightStr.toString(), left, right-1);
    }

    private static void generateString(String str, int index, StringBuilder builder) {
        for (int i = 0; i < str.length(); i++) {
            if (i == index) {
                continue;
            }
            builder.append(str.charAt(i));
        }
    }

    public static boolean palindrome(String str, int left, int right) {
        if (str.isEmpty()) {
            return true;
        }

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
