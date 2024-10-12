package october_2024;

public class AddBinary {

    public static void main(String[] args) {
        String a = "11";
        String b = "1";

        AddBinary addBinary = new AddBinary();
        String result = addBinary.addBinary(a, b);
        System.out.println(result);
    }

    public String addBinary(String a, String b) {

        StringBuilder builder = new StringBuilder();
        int carry = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;

        while (i >= 0 || j >= 0) {
            int sum = 0;
            if (i >= 0) {
                sum += a.charAt(i) - '0';
            }
            if (j >= 0) {
                sum += b.charAt(j) - '0';
            }
            sum += carry;

            builder.insert(0, sum % 2);
            carry = sum / 2;
            i--;
            j--;
        }

        if (carry > 0) {
            builder.insert(0, carry);
        }

        return builder.toString();
    }


    // O(n) time | O(1) space
    public String addBinary2(String a, String b) {

        StringBuilder builder = new StringBuilder();
        int carry = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;

        while (i >= 0 || j >= 0) {
            int sum = 0;
            if (i >= 0) {
                sum += Character.getNumericValue(a.charAt(i));
            }
            if (j >= 0) {
                sum += Character.getNumericValue(b.charAt(j));
            }
            sum += carry;

            builder.append(sum % 2);
            carry = sum / 2;
            i--;
            j--;
        }

        if (carry > 0) {
            builder.append(carry);
        }

        return builder.reverse().toString();
    }



}
