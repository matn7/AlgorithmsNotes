package august_2024;

public class AddBinary {

    public static void main(String[] args) {
//        String a = "1011";
//        String b = "1101";

        String a = "1011";
        String b = "1101";

        String result = addBinary(a, b);
        System.out.println(result);
    }

    public static String addBinary(String a, String b) {

        int i = a.length() - 1;
        int j = b.length() - 1;

        StringBuilder sb = new StringBuilder();
        int carry = 0;
        while (i >= 0 && j >= 0) {
            int aVal = Character.getNumericValue(a.charAt(i));
            int bVal = Character.getNumericValue(b.charAt(i));

            int sum = aVal + bVal + carry;
            carry = sum / 2;
            sb.insert(0, sum % 2);

            i--;
            j--;
        }
        if (carry > 0) {
            sb.insert(0, carry);
        }

        return sb.toString();
    }

}
