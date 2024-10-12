package october_2023;

public class ConsecutiveBitOne {

    public static void main(String[] args) {
        consecutiveBitOne(2678);
    }

    // O(sqrt(n)) time | O(1) space
    public static int consecutiveBitOne(int num) {
        int max = 0;
        int BIT_MASK = 1;

        while (num != 0) {
            int curr = 0;
            int n = num & BIT_MASK;
            while (n == 1) {
                curr++;
                num = num >> 1;
                n = num & BIT_MASK;
            }
            max = Math.max(max, curr);
            num = num >> 1;
        }

        return max;
    }

}
