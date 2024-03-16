package october_2023;

public class PalindromeCheckV2 {

    public static void main(String[] args) {
        String str = "abcbcba";
        System.out.println(palindromeCheck(str));
        System.out.println(palindromeCheckRec(str));
    }

    // O(n) time | O(1) space
    public static boolean palindromeCheck(String str) {
        int startIdx = 0;
        int endIdx = str.length() - 1;

        while (startIdx < endIdx) {
            if (str.charAt(startIdx) != str.charAt(endIdx)) {
                return false;
            }
            startIdx++;
            endIdx--;
        }

        return true;
    }

    public static boolean palindromeCheckRec(String str) {
        return palindromeCheckRecHelper(str);
    }

    private static boolean palindromeCheckRecHelper(String str) {
        if (str.length() <= 1) {
            return true;
        }
        if (str.charAt(0) != str.charAt(str.length() - 1)) {
            return false;
        }
        return palindromeCheckRecHelper(str.substring(1, str.length()-1));
    }

}
