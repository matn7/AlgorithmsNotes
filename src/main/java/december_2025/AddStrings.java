package december_2025;

public class AddStrings {

    public static void main(String[] args) {
        String num1 = "22999";
        String num2 = "999";

        AddStrings addStrings = new AddStrings();
        String result = addStrings.addStrings(num1, num2);
        System.out.println(result);
    }

    // O(max(m,n)) time | O(max(m,n)) space
    public String addStrings(String num1, String num2) {
        if (num1.length() < num2.length()) {
            String temp = num1;
            num1 = num2;
            num2 = temp;
        }

        int i = 0;
        int j = 0;

        String num1R = new StringBuilder(num1).reverse().toString();
        String num2R = new StringBuilder(num2).reverse().toString();

        StringBuilder builder = new StringBuilder();

        int carry = 0;
        while (i < num1R.length() && j < num2R.length()) {
            int a = num1R.charAt(i) - '0';
            int b = num2R.charAt(j) - '0';
            int sum = a + b + carry;
            int val = sum % 10;
            carry = sum / 10;
            builder.append(val);
            i++;
            j++;
        }

        while (i < num1R.length()) {
            int a = num1R.charAt(i) - '0';
            int sum = a + carry;
            int val = sum % 10;
            carry = sum / 10;
            builder.append(val);
            i++;
        }
        if (carry != 0) {
            builder.append(carry);
        }

        return builder.reverse().toString();
    }

}
