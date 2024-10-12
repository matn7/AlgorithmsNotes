package october_2023;

public class DecimalToHexConverter {

    public static void main(String[] args) {
        int n = 2681;
        String result = decToHex(n);
        System.out.println(result);
    }

    // O(log16(n)) time | O(log16(n)) space
    public static String decToHex(int num) {
        StringBuilder builder = new StringBuilder();

        String hexSymbols = "0123456789ABCDEF";

        while (num > 0) {
            int val = num % 16;
            char c = hexSymbols.charAt(val);
            builder.append(c);
            num /= 16;
        }

        return builder.reverse().toString();
    }

}
