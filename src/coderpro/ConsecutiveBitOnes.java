package coderpro;

public class ConsecutiveBitOnes {

    public static void main(String[] args) {
        int num = 242;
        ConsecutiveBitOnes consecutiveBitOnes = new ConsecutiveBitOnes();
        int result = consecutiveBitOnes.longest_run(num);
        System.out.println(result);
    }

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

}
