package september_2024;

public class AddBinaries {

    public static void main(String[] args) {
        String a = "1011";
        String b = "1101";

        String result = addBinaries(a, b);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public static String addBinaries(String a, String b) {
        if (a == null && b == null) {
            return null;
        }
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        StringBuilder builder = new StringBuilder();

        while (i >= 0 || j >= 0 || carry == 1) {
            if (i >= 0) {
                carry += Character.getNumericValue(a.charAt(i));
                i--;
            }
            if (j >= 0) {
                carry += Character.getNumericValue(b.charAt(j));
                j--;
            }
            builder.insert(0, carry % 2);
            carry = carry / 2;
        }
        return builder.toString();
    }
}
