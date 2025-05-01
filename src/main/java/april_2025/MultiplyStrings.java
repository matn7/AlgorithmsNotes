package april_2025;

public class MultiplyStrings {

    public static void main(String[] args) {
        String num1 = "123";
        String num2 = "456";

        MultiplyStrings multiplyStrings = new MultiplyStrings();
        String result = multiplyStrings.multiply(num1, num2);
        System.out.println(result);
    }

    // O(n*m) time | O(n + m) space
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        int[] dp = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            int n1 = num1.charAt(i) - '0';
            for (int j = num2.length() - 1; j >= 0; j--) {
                int n2 = num2.charAt(j) - '0';
                int mul = n1 * n2; // 18

                int sum = mul + dp[i + j + 1]; // 18 + 0 = 18
                dp[i + j + 1] = sum % 10; // 8
                dp[i + j] += sum / 10;
            }
        }

        StringBuilder builder = new StringBuilder();
        for (int num : dp) {
            if (!(builder.isEmpty() && num == 0)) {
                builder.append(num);
            }
        }
        return builder.isEmpty() ? "0" : builder.toString();
    }

}
