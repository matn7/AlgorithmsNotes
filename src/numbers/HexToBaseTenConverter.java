package numbers;

public class HexToBaseTenConverter {

    public static void main(String[] args) {
        String hex = "AAB1FD";
        hexToDecimal(hex);
    }

    // O(n) time | O(1) space
    private static long hexToDecimal(String hex) {
        hex = hex.toUpperCase();
        long decimalValue = 0;

        for (int i = hex.length() - 1; i >= 0; i--) {
            char c = hex.charAt(i);
            int digitValue = "0123456789ABCDEF".indexOf(c);
            decimalValue += digitValue * Math.pow(16, (hex.length() - 1) - i);
        }

        return decimalValue;
    }

}
