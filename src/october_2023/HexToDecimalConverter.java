package october_2023;

public class HexToDecimalConverter {

    public static void main(String[] args) {
        String hex = "AAB1FD";
        int result = hexToDec(hex);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public static int hexToDec(String hex) {
        int sum = 0;

        String hexSymbols = "0123456789ABCDEF";
        int counter = 0;
        for (int i = hex.length() - 1; i >= 0; i--) {
            char curr = hex.charAt(i);
            int value = hexSymbols.indexOf(curr);
            sum += value * Math.pow(16, counter);
            counter++;
        }

        return sum;
    }

}
