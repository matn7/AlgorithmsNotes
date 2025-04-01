package march_2025;

public class HexToDecimal {

    public static void main(String[] args) {
        String hex = "AAB1FD";

        HexToDecimal hexToDecimal = new HexToDecimal();
        int result = hexToDecimal.hexToDecimal(hex);
        System.out.println(result);

//        String hex1 = hexToDecimal.decimalToHex(11186685);
        String hex1 = hexToDecimal.decimalToHex(-1);
        System.out.println(hex1);
    }

    public String decimalToHex(int num) {
        if (num == 0) return "0";

        String nums = "0123456789abcdef";
        StringBuilder builder = new StringBuilder();

        // Konwersja do 32-bitowego zapisu szesnastkowego
        // Ponieważ int to liczba ze znakiem, dla liczb ujemnych stosujemy maskowanie.
        long n = num & 0xFFFFFFFFL; // Maskowanie, aby operować na liczbach bez znaku

        while (n > 0) {
            int elem = (int) (n % 16);
            builder.append(nums.charAt(elem));
            n /= 16;
        }

        return builder.reverse().toString();
    }

    public int hexToDecimal(String hex) {
        String nums = "0123456789ABCDEF";

        int res = 0;
        int mul = 1;
        int i = hex.length() - 1;
        while (i >= 0) {
            char c = hex.charAt(i);
            int num = nums.indexOf(c);
            res += num * mul;
            mul *= 16;
            i--;
        }
        return res;
    }

}
