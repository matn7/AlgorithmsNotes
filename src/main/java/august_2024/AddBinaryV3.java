package august_2024;

public class AddBinaryV3 {

    public static void main(String[] args) {
        String a = "1011";
        String b = "1101";

        String result = addBinary(a, b);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public static String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        StringBuilder builder = new StringBuilder();
        while (i >= 0 || j >= 0 || carry == 1) {
            int sum = 0;
            if (i < 0) {
                sum += 0;
            } else {
                sum += Character.getNumericValue(a.charAt(i));
            }
            if (j < 0) {
                sum += 0;
            } else {
                sum += Character.getNumericValue(b.charAt(j));
            }
            sum += carry;
            int value = sum % 2;
            builder.insert(0, value);
            carry = sum / 2;
            i--;
            j--;
        }
        if (carry > 0) {
            builder.insert(0, carry);
        }
        return builder.toString();
    }

}
