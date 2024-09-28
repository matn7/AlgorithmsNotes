package august_2024;

public class AddBinaryV4 {
    public static void main(String[] args) {
        String a = "1011";
        String b = "1101";

        String result = addBinary(a, b);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public static String addBinary(String a, String b) {

        int carry = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;
        StringBuilder builder = new StringBuilder();

        while (i >= 0 || j >= 0 || carry > 0) {
            if (i >= 0) {
                carry += Character.getNumericValue(a.charAt(i));
                i--;
            }
            if (j >= 0) {
                carry += Character.getNumericValue(b.charAt(j));
                j--;
            }
            if (carry % 2 == 0) {
                builder.insert(0, '0');
            } else {
                builder.insert(0, '1');
            }
            carry = carry / 2;
        }

        return builder.toString();
    }

}
