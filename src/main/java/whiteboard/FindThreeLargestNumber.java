package whiteboard;

public class FindThreeLargestNumber {

    // O(n) time | O(1) space
    public static int[] findThreeLargestNumbers(int[] array) {
        // Write your code here.
        int[] result = {Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};

        for (int curr : array) {
            if (curr > result[2]) {
                result[0] = result[1];
                result[1] = result[2];
                result[2] = curr;
            } else if (curr > result[1]) {
                result[0] = result[1];
                result[1] = curr;
            } else if (curr > result[0]) {
                result[0] = curr;
            }
        }

        return result;
    }

}
