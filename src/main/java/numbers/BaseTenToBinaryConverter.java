package numbers;

public class BaseTenToBinaryConverter {

    public static void main(String[] args) {
        String result = convertDecimalToBinary(3891);
        System.out.println(result);
    }

    // O(log(n)) time | O(log(n)) space
    public static String convertDecimalToBinary(int decimalNumber) {
        if (decimalNumber == 0) {
            return "0";
        }

        StringBuilder binary = new StringBuilder();

        while (decimalNumber > 0) {
            int remainder = decimalNumber % 2;
            binary.insert(0, remainder); // Prepend the remainder to the binary string
            decimalNumber = decimalNumber / 2;
        }

        return binary.toString();
    }

}
