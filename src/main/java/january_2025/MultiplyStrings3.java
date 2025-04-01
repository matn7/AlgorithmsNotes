package january_2025;

public class MultiplyStrings3 {

    // O(n*m) time | O(n + m) space
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int[] res = new int[num1.length() + num2.length()];
        num1 = new StringBuilder(num1).reverse().toString();
        num2 = new StringBuilder(num2).reverse().toString();

        for (int i = 0; i < num1.length(); i++) {
            for (int j = 0; j < num2.length(); j++) {
                int digit = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                res[i + j] += digit;
                res[i + j + 1] += res[i + j + 1] / 10;
                res[i + j] %= 10;
            }
        }
        StringBuilder number = new StringBuilder();
        int i = res.length - 1;
        while (i >= 0 && res[i] == 0) {
            i--;
        }
        while (i >= 0) {
            number.append(res[i]);
            i--;
        }
        return number.toString();
    }

}
