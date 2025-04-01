package march_2025;

public class AddBinary {

    public static void main(String[] args) {
        String a = "11";
        String b = "1";

        AddBinary addBinary = new AddBinary();
        String result = addBinary.addBinary(a, b);
        System.out.println(result);
    }

    // O(max(n, m)) time | O(1) space
    public String addBinary(String a, String b) {
        int carry = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;
        StringBuilder builder = new StringBuilder();
        while (i >= 0 || j >= 0) {
            int aNum = i < 0 ? 0 : a.charAt(i) - '0';
            int bNum = j < 0 ? 0 : b.charAt(j) - '0';
            int num = aNum + bNum + carry;
            builder.append(num % 2);
            carry = num / 2;
            i--;
            j--;
        }
        if (carry > 0) {
            builder.append(carry);
        }
        return builder.reverse().toString();
    }

}
