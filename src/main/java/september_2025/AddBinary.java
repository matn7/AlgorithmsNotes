package september_2025;

public class AddBinary {

    public static void main(String[] args) {
        String a = "1010";
        String b = "1011";

        AddBinary addBinary = new AddBinary();
        String result = addBinary.addBinary(a, b);
        System.out.println(result);
    }

    // O(max(a, b)) time | O(1) space
    public String addBinary(String a, String b) {
        StringBuilder builder = new StringBuilder();
        int carry = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;
        while (i >= 0 || j >= 0 || carry > 0) {
            int n1 = i >= 0 ? a.charAt(i) - '0' : 0;
            int n2 = j >= 0 ? b.charAt(j) - '0' : 0;
            int num = n1 + n2 + carry;
            builder.append(num % 2);
            carry = num / 2;
            i--;
            j--;
        }
        return builder.reverse().toString();
    }


}
