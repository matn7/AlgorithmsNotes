package august_2024;

public class DecimalToHexV2 {

    public static void main(String[] args) {
        int n = 2681;

        String result = decToHex(n);
        System.out.println(result);
    }

    // O(log16(n)) time | O(log16(n)) space
    public static String decToHex(int n) {
        String hexSymbols = "0123456789ABCDEF";
        StringBuilder builder = new StringBuilder();
        while (n > 0) {
            int val = n % 16;
            char c = hexSymbols.charAt(val);
            builder.append(c);
            n = n / 16;
        }
        return builder.reverse().toString();
    }

}
