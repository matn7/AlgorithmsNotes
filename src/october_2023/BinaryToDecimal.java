package october_2023;

public class BinaryToDecimal {

    public static void main(String[] args) {
        String binary = "1101000101";
        int result = binaryToDecimal(binary);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public static int binaryToDecimal(String binary) {
        // 1101000101
        int sum = 0;
        int counter = 0;
        for (int i = binary.length() - 1; i >= 0; i--) {
            char curr = binary.charAt(i);
            if (curr == '1') {
                sum += Math.pow(2, counter);
            }
            counter++;
        }

        return sum;
    }

}
