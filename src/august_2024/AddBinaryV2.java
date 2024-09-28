package august_2024;

public class AddBinaryV2 {

    public static void main(String[] args) {
        String a = "1011";
        String b = "1101";

        String result = addBinary(a, b);
        System.out.println(result);
    }

    public static String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        StringBuilder builder = new StringBuilder();

        // 1 0 1 1
        // i
        // 1 1 0 1
        // j
        // 1 0 0 0
        // carry = 1
        while (i >= 0 && j >= 0) {
            char aChar = a.charAt(i);
            char bChar = b.charAt(j);

            int aNum = aChar - '0'; // 1
            int bNum = bChar - '0'; // 1
            int sum = aNum + bNum + carry; // 1
            int value = sum % 2;
            builder.insert(0, value); // 0
            if (value == 0 || sum > 2) {
                carry = 1;
            } else {
                carry = 0;
            }
            i--;
            j--;
        }
        if (carry > 0) {
            builder.insert(0, "1");
        }

        return builder.toString();
    }

}
