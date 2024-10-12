package august_2024;

public class DecimalToHex {

    public static void main(String[] args) {
        int num = 11186685;

        String result = decToHex(num);
        System.out.println(result);
    }

    // O(log16(n)) time | O(log16(n)) space
    public static String decToHex(int num) {
        StringBuilder builder = new StringBuilder();

        String hexSymbols = "0123456789ABCDEF";

        while (num > 0) {
            int partIdx = num % 16;
            char c = hexSymbols.charAt(partIdx);
            builder.insert(0, c);
            num /= 16;
        }

        return builder.toString();

    }

}
