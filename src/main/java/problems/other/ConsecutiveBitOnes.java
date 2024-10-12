package problems.other;

public class ConsecutiveBitOnes {

    public static void main(String[] args) {
        int num = 99999;
        ConsecutiveBitOnes consecutiveBitOnes = new ConsecutiveBitOnes();
        int result = consecutiveBitOnes.longest_run(num);
        System.out.println(result);
        int result2 = consecutiveBitOnes.longest_run2(num);
        System.out.println(result2);
    }

    // ********
    // * STAR - G *
    // ********

    // O(log(n)) time | O(1) space
    public int longest_run(int n) {
        int longest_run = 0;
        int current_run = 0;
        int BITMASK = 1;

        while (n != 0) {
            int i = n & BITMASK;
            if (i == 0) {
                longest_run = Math.max(longest_run, current_run);
                current_run = 0;
            } else {
                current_run++;
            }
            n = n >> 1;
        }
        longest_run = Math.max(longest_run, current_run);
        return longest_run;
    }

    // right shift means div by 2 ==> log(n)
    // O(log(n)) time | O(1) space
    public int longest_run2(int num) {
        // 242
        // 1 1 1 1 0 0 1 0
        //       1 &
        //
        // counter = 1
        int max = 0; // 1
        int BIT_MASK = 1;

        while (num != 0) {
            int curr = 0;
            int val = num & BIT_MASK;
            while (val == 1) {
                curr++;
                num = num >> 1;
                val = num & BIT_MASK;
            }
            max = Math.max(max, curr);
            num = num >> 1;
        }
        return max;
    }

}
