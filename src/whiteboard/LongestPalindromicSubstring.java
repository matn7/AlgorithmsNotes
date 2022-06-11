package whiteboard;

public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        String string = "abaxyzzyxf";

        String result = longestPalindromicSubstring(string);
        System.out.println(result);
    }

    // O(n^2) time | O(n) space
    public static String longestPalindromicSubstring(String str) {
        // Write your code here.
        int[] longest = {0, 0};
        for (int idx = 1; idx < str.length(); idx++) {
            int[] current = {0, 0};
            int firstEven = idx - 1;
            int secondEven = idx + 1;
            while (firstEven >= 0 && secondEven < str.length() && isMatch(str, firstEven, secondEven)) {
                firstEven--;
                secondEven++;
            }
            firstEven++;
            secondEven--;
            int evenDiff = secondEven - firstEven;

            int firstOdd = idx - 1;
            int secondOdd = idx;
            while (firstOdd >= 0 && secondOdd < str.length() && isMatch(str, firstOdd, secondOdd)) {
                firstOdd--;
                secondOdd++;
            }
            firstOdd++;
            secondOdd--;
            int oddDiff = secondOdd - firstOdd;
            if (evenDiff > oddDiff) {
                current[0] = firstEven;
                current[1] = secondEven;
            } else {
                current[0] = firstOdd;
                current[1] = secondOdd;
            }

            if (current[1] - current[0] > longest[1] - longest[0]) {
                longest[0] = current[0];
                longest[1] = current[1];
            }

        }

        return str.substring(longest[0], longest[1] + 1);
    }

    private static boolean isMatch(String str, int first, int second) {
        return str.charAt(first) == str.charAt(second);
    }

}
