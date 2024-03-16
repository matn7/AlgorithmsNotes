package star;

public class ConsecutiveBitOnes {

    public static void main(String[] args) {
        ConsecutiveBitOnes consecutiveBitOnes = new ConsecutiveBitOnes();
        int result = consecutiveBitOnes.consecutiveBitOnes(2678);
        System.out.println(result);
    }

    // O(log(n)) time | O(1) space
    public int consecutiveBitOnes(int num) {

        int max = 0;
        int BIT_MASK = 1;

        while (num > 0) {
            int test = num & BIT_MASK;
            int counter = 0;
            while (test == 1) {
                counter++;
                num = num >> 1;
                test = num & BIT_MASK;
            }
            max = Math.max(max, counter);
            num = num >> 1;
        }
        return max;
    }

}
