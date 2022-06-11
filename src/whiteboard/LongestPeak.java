package whiteboard;

public class LongestPeak {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 3, 4, 0, 10, 6, 5, -1, -3, 2, 3};

        int result = longestPeak(array);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public static int longestPeak(int[] array) {
        // Write your code here.
        int maxLen = 0;

        for (int idx = 1; idx < array.length - 1; idx++) {
            if (!isPeak(array, idx)) {
                continue;
            }

            int currIdx = idx;
            int currLen = 3;
            int toLeft = currIdx - 2;
            while (toLeft >= 0 && array[toLeft] < array[toLeft + 1]) {
                toLeft--;
                currLen++;
            }

            int toRight = currIdx + 2;
            while (toRight < array.length && array[toRight] < array[toRight - 1]) {
                toRight++;
                currLen++;
            }

            maxLen = Math.max(maxLen, currLen);
            idx = toRight - 1;
        }

        return maxLen;
    }

    private static boolean isPeak(int[] array, int idx) {
        int currVal = array[idx];
        int toLeft = array[idx - 1];
        int toRight = array[idx + 1];

        if (currVal > toLeft && currVal > toRight) {
            return true;
        }
        return false;
    }

}
