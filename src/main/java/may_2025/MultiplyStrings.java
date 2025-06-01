package may_2025;

public class MultiplyStrings {

    public static void main(String[] args) {
        String num1 = "123";
        String num2 = "456";

        MultiplyStrings multiplyStrings = new MultiplyStrings();
        String result = multiplyStrings.multiply(num1, num2);
        System.out.println(result);
    }

    public String multiply(String num1, String num2) {
        int[] dp = new int[num1.length() + num2.length()];

        for (int i = num2.length() - 1; i >= 0; i--) {
            int n2 = num2.charAt(i) - '0';
            for (int j = num1.length() - 1; j >= 0; j--) {
                int n1 = num1.charAt(j) - '0';
                int mul = n1 * n2;
                int sum = mul + dp[i + j + 1];
                dp[i + j + 1] = sum % 10;
                dp[i + j] += sum / 10;
            }
        }
        StringBuilder builder = new StringBuilder();
        for (int num : dp) {
            if (builder.isEmpty() && num == 0) {
                continue;
            }
            builder.append(num);
        }
        return builder.isEmpty() ? "0" : builder.toString();
    }

}
