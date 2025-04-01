package march_2025;

public class DecimalToBinary {

    public static void main(String[] args) {
        int num = 3991;
        DecimalToBinary decimalToBinary = new DecimalToBinary();
        String result = decimalToBinary.decimalToBinary(num);
        System.out.println(result);
        System.out.println(decimalToBinary.binaryToDecimal(result));
    }

    // O(n) time | O(1) space
    public String decimalToBinary(int num) {

        StringBuilder builder = new StringBuilder();
        while (num > 0) {
            if (num % 2 == 0) {
                builder.append("0");
            } else {
                builder.append("1");
            }
            num = num / 2;
        }

        return builder.reverse().toString();
    }

    public int binaryToDecimal(String num) {
        int res = 0;
        int mul = 1;
        for (int i = num.length() - 1; i >= 0; i--) {
            int n = num.charAt(i) - '0'; // 1
            res += mul * n;
            mul *= 2;
        }

        return res;
    }

}
