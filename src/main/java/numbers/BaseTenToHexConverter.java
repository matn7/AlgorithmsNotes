package numbers;

public class BaseTenToHexConverter {

    public static void main(String[] args) {
        String result = convertDecimalToHexadecimal(2681);
        System.out.println(result);
    }

    // O(log16(n)) time | O(log16(n)) space
    public static String convertDecimalToHexadecimal(int decimalNumber) {
        if (decimalNumber == 0) {
            return "0";
        }

        StringBuilder hexadecimal = new StringBuilder();

        while (decimalNumber > 0) {
            int remainder = decimalNumber % 16;
            if (remainder < 10) {
                hexadecimal.insert(0, (char) ('0' + remainder));
            } else {
                hexadecimal.insert(0, (char) ('A' + remainder - 10));
            }
            decimalNumber = decimalNumber / 16;
        }

        return hexadecimal.toString();
    }

}
