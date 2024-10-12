package july_2024;

public class AddBinary {

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
        StringBuilder result = new StringBuilder();
        while (i >= 0 || j >= 0 || carry == 1) {
            if (i >= 0) {
                carry += Character.getNumericValue(a.charAt(i));
                i--;
            }
            if (j >= 0) {
                carry += Character.getNumericValue(b.charAt(j));
                j--;
            }
            result.insert(0, carry % 2);
            carry = carry / 2;
        }
        return result.toString();
    }

}
