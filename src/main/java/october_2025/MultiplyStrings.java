package october_2025;

public class MultiplyStrings {

    public static void main(String[] args) {
        String num1 = "123";
        String num2 = "456";

        MultiplyStrings multiplyStrings = new MultiplyStrings();
        String result = multiplyStrings.multiply(num1, num2);
        System.out.println(result);
    }

    // O(n * m) time | O(n + m) space
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        String n1 = new StringBuilder(num1).reverse().toString();
        String n2 = new StringBuilder(num2).reverse().toString();

        int[] result = new int[n1.length() + n2.length()];

        for (int i = 0; i < n1.length(); i++) {
            int a = n1.charAt(i) - '0';
            for (int j = 0; j < n2.length(); j++) {
                int b = n2.charAt(j) - '0';
                result[i + j] += a * b;
                result[i + j + 1] += result[i + j] / 10;
                result[i + j] %= 10;
            }
        }
        int idx = result.length - 1;

        while (result[idx] == 0) {
            idx--;
        }
        StringBuilder builder = new StringBuilder();
        while (idx >= 0) {
            builder.append(result[idx]);
            idx--;
        }
        return builder.toString();
    }


}
