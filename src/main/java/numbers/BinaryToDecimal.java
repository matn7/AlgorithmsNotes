package numbers;

public class BinaryToDecimal {

    public static void main(String[] args) {
        String binaryString = "1101000101";

        binaryToDecimal(binaryString);
    }

    // O(n) time | O(1) space
    public static int binaryToDecimal(String binaryString) {
        int decimalNumber = 0;
        int binaryLength = binaryString.length();

        // Convert binary to decimal using the powers of 2
        for (int i = 0; i < binaryLength; i++) {
            int digit = Character.getNumericValue(binaryString.charAt(i));
            int power = binaryLength - 1 - i;
            decimalNumber += digit * Math.pow(2, power);
        }

        return decimalNumber;
    }

}
