package june_2025;

public class MultiplyStrings3 {

    public static void main(String[] args) {
        String num1 = "123";
        String num2 = "456";

        MultiplyStrings3 multiplyStrings3 = new MultiplyStrings3();
        String result = multiplyStrings3.multiply(num1, num2);
        System.out.println(result);
    }

    // O(n * m) time | O(n + m) space
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        int[] dp = new int[num1.length() + num2.length()];

        num1 = String.valueOf(new StringBuilder(num1).reverse());
        num2 = String.valueOf(new StringBuilder(num2).reverse());

        for (int i = 0; i < num1.length(); i++) {
            int n1 = num1.charAt(i) - '0';
            for (int j = 0; j < num2.length(); j++) {
                int n2 = num2.charAt(j) - '0';
                int digit = n1 * n2;
                dp[i + j] += digit;
                dp[i + j + 1] += dp[i + j] / 10;
                dp[i + j] %= 10;
            }
        }

        int idx = dp.length - 1;
        while (idx >= 0 && dp[idx] == 0) {
            idx--;
        }
        StringBuilder builder = new StringBuilder();
        while (idx >= 0) {
            builder.append(dp[idx]);
            idx--;
        }

        return builder.toString();
    }


}
