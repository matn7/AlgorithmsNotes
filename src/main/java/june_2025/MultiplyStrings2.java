package june_2025;

public class MultiplyStrings2 {

    public static void main(String[] args) {
        String num1 = "123";
        String num2 = "456";

        MultiplyStrings2 multiplyStrings = new MultiplyStrings2();
        String multiply = multiplyStrings.multiply(num1, num2);
        System.out.println(multiply);
    }

    // O(n * m) time | O(n + m) space
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int[] dp = new int[num1.length() + num2.length()];

        StringBuilder s1 = new StringBuilder(num1).reverse();
        StringBuilder s2 = new StringBuilder(num2).reverse();

        for (int i = 0; i < s1.length(); i++) {
            int n1 = s1.charAt(i) - '0';
            for (int j = 0; j < s2.length(); j++) {
                int n2 = s2.charAt(j) - '0';
                int num = n1 * n2;
                dp[i + j] += num % 10;
                dp[i + j + 1] += num / 10 + dp[i + j] / 10;
                dp[i + j] %= 10;
            }
        }

        int idx = dp.length - 1;
        while (idx >= 0 && dp[idx] == 0) {
            idx--;
        }
        StringBuilder result = new StringBuilder();
        while (idx >= 0) {
            result.append(dp[idx]);
            idx--;
        }
        return result.toString();
    }


}
