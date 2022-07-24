package whiteboard;

public class LongestPeakRand {

    public static int longestPeak(int[] array) {
        // Write your code here.
        int maxLen = 0;
        for (int i = 1; i < array.length - 1; i++) {
            if (isPeak(array, i)) {
                int peakIdx = i;
                int currLen = 3;
                int leftIdx = peakIdx - 2;
                while (leftIdx >= 0 && array[leftIdx] < array[leftIdx + 1]) {
                    currLen++;
                    leftIdx--;
                }
                int rightIdx = peakIdx + 2;
                while (rightIdx < array.length && array[rightIdx] < array[rightIdx - 1]) {
                    currLen++;
                    rightIdx++;
                }
                if (currLen > maxLen) {
                    maxLen = currLen;
                }
                i = rightIdx - 1;
            }
        }
        return maxLen;
    }

    private static boolean isPeak(int[] array, int i) {
        return array[i] > array[i - 1] && array[i] > array[i + 1];
    }

}
