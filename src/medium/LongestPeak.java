package medium;

public class LongestPeak {

    public static void main(String[] args) {
//        int[] array = new int[] {1,2,3,3,4,0,10,6,5,-1,-3,2,3};
        int[] array = new int[] {1, 2, 3, 4, 5, 1};

        longestPeak(array);
    }

    // OK - repeated 17/02/2022
    // O(n) time | O(1) space
    public static int longestPeak(int[] array) {
        int longestPeakLength = 0;
        int i = 1;
        //          0  1  2  3  4  5   6  7  8   9  10  11 12
        // array = [1, 2, 3, 3, 4, 0, 10, 6, 5, -1, -3, 2, 3]
        //                                                 i
        while (i < array.length - 1) {
            boolean isPeak = array[i] > array[i - 1] && array[i] > array[i + 1];
            if (!isPeak) {
                i++;
                continue;
            }
            int leftIdx = i - 2;
            while (leftIdx >= 0 && array[leftIdx] < array[leftIdx + 1]) {
                leftIdx--;
            }
            int rightIdx = i + 2;
            while (rightIdx < array.length && array[rightIdx] < array[rightIdx - 1]) {
                rightIdx++;
            }
            int currentPeakLength = rightIdx - leftIdx - 1; // 11 - 4 - 1 = 6
            if (currentPeakLength > longestPeakLength) { // 6 > 3
                longestPeakLength = currentPeakLength; // 6
            }
            i = rightIdx;
        }
        return longestPeakLength; // 6
    }

    // O(n) time | O(1) space
    public static int longestPeak2(int[] array) {
        // Write your code here.
        int maxPeak = 0;
        for (int i = 1; i < array.length - 1; i++) {
            if (array[i] > array[i-1] && array[i] > array[i+1]) {
                int j = i;
                int peak = 1;
                System.out.println(array[i]);
                while (j >= 1 && array[j] > array[j-1]) {
                    j--;
                    peak++;
                }
                j = i;
                while (j < array.length - 1 && array[j] > array[j+1]) {
                    j++;
                    peak++;
                }

                if (peak > maxPeak) {
                    maxPeak = peak;
                }
                i = j;
                System.out.println(peak);
                System.out.println("=====");
            }
        }
        return maxPeak;
    }

}
