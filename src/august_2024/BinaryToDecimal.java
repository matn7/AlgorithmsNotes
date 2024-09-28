package august_2024;

public class BinaryToDecimal {

    public static void main(String[] args) {
        String binary = "111100110011";

        int result = binToDec(binary);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public static int binToDec(String binary) {

        int idx = binary.length() - 1;
        int sum = 0;
        int pow = 0;
        while (idx >= 0) {
            char c = binary.charAt(idx);
            if (c == '1') {
                sum += Math.pow(2, pow);
            }
            pow++;
            idx--;
        }

        return sum;
    }

}
