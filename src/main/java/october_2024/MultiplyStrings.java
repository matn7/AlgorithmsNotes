package october_2024;

public class MultiplyStrings {

    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        int[] res = new int[num1.length() + num2.length()];

        for (int i1 = num1.length() - 1; i1 >= 0; i1--) {
            for (int i2 = num2.length() - 1; i2 >= 0; i2--) {
                int digit1 = num1.charAt(i1) - '0';
                int digit2 = num2.charAt(i2) - '0';
                int product = digit1 * digit2;

                int sum = product + res[i1 + i2 + 1];
                res[i1 + i2 + 1] = sum % 10; // Store the single digit
                res[i1 + i2] += sum / 10; // Carry to the next position
            }
        }

        StringBuilder builder = new StringBuilder();
        for (int num : res) {
            if (!(builder.isEmpty() && num == 0)) { // Skip leading zeros
                builder.append(num);
            }
        }

        return builder.isEmpty() ? "0" : builder.toString();
    }


}
