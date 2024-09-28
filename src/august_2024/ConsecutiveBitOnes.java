package august_2024;

public class ConsecutiveBitOnes {

    public static void main(String[] args) {

        int result = countBits(255);
        System.out.println(result);

    }

    // O(log(n)) time | O(1) space
    public static int countBits(int num) {
        int maxLen = 0;

        int BIT_MASK = 1;

        while (num != 0) {
            int curr = 0;
            while ((num & BIT_MASK) == 1) {
                curr++;
                num = num >> 1;
            }
            maxLen = Math.max(maxLen, curr);
            num = num >> 1;
        }

        return maxLen;
    }

}
