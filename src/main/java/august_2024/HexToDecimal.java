package august_2024;

public class HexToDecimal {

    public static void main(String[] args) {
        String hex = "AAB1FD";

        int result = hexToDecimal(hex);
        System.out.println(result);
    }

    public static int hexToDecimal(String hex) {
        int result = 0;
        String hexSymbols = "0123456789ABCDEF";
        int idx = hex.length() - 1;
        int pow = 0;
        while (idx >= 0) {
            char c = hex.charAt(idx);
            int mul = hexSymbols.indexOf(c);
            result += mul * Math.pow(16, pow);
            pow++;
            idx--;
        }

        return result;
    }

}
