package august_2024;

public class HexToDecimalV2 {

    public static void main(String[] args) {
        String hex = "AAB1FD";

        int result = hexToDec(hex);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public static int hexToDec(String hex) {
        int res = 0;

        String hexSymbols = "0123456789ABCDEF";

        int index = hex.length() - 1;
        int power = 0;
        while (index >= 0 ){
            char c = hex.charAt(index); // 'D'
            int value = hexSymbols.indexOf(c);
            int part = value * (int) Math.pow(16, power);
            res += part;
            power++;
            index--;
        }
        return res;
    }

}
