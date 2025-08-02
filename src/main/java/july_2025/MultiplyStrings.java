package july_2025;

public class MultiplyStrings {

    public static void main(String[] args) {
        String num1 = "123", num2 = "456";
        MultiplyStrings multiplyStrings = new MultiplyStrings();
        String result = multiplyStrings.multiply(num1, num2);
        System.out.println(result);
    }

    // Intuition:
    // - how to multiply
    // - nums array, what is max num possible 999 * 999
    // - keep track of indexes, to start from 0, reverse nums
    // Approach:
    // - create nums array
    // - multiply, remember about carry
    // - corner case if num1 or num2 is 0
    // Complexity:
    // O(n * m) time | O(n + m) space
    // Code:

    // 1 2 3
    // 4 5 6
    //     18 -> 1 carry

    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        num1 = new StringBuilder(num1).reverse().toString();
        num2 = new StringBuilder(num2).reverse().toString();
        int[] result = new int[num1.length() + num2.length()];

        for (int i = 0; i < num1.length(); i++) {
            char c1 = num1.charAt(i);
            int n1 = c1 - '0';
            for (int j = 0; j < num2.length(); j++) {
                char c2 = num2.charAt(j);
                int n2 = c2 - '0';
                result[i + j] += n1 * n2;
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
