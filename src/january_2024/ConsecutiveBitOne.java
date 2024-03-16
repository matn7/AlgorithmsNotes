package january_2024;

public class ConsecutiveBitOne {

    public static void main(String[] args) {
        System.out.println(consecutiveBitOne(242));
    }

    // O(sqrt(n)) time | O(1) space
    public static int consecutiveBitOne(int num) {
        int max = 0;
        int BIT_MASK = 1;

        while (num > 0) {
            int curr = 0;
            while ((num & BIT_MASK) == 1) {
                curr++;
                num = num >> 1;
            }
            max = Math.max(max, curr);
            num = num >> 1;
        }
        return max;
    }

}
