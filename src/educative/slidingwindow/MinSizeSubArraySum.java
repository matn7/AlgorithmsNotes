package educative.slidingwindow;

public class MinSizeSubArraySum {

    public static void main(String[] args) {
        int result = MinSizeSubArraySum.findMinSubArray(7, new int[] { 2, 1, 5, 2, 3, 2 });
        System.out.println("Smallest subarray length: " + result);
        result = MinSizeSubArraySum.findMinSubArray(8, new int[] { 3, 4, 1, 1, 6 });
        System.out.println("Smallest subarray length: " + result);
        result = MinSizeSubArraySum.findMinSubArray(8, new int[] { 2, 1, 5, 2, 3, 2});
        System.out.println("Smallest subarray length: " + result);
    }

    // O(n) time | O(1) space
    private static int findMinSubArray(int s, int[] a) {
        int n = a.length;

        int lengthOfSmallestSubArray = Integer.MAX_VALUE;
        int windowSum = 0;

        int windowStart = 0;
        for (int windowEnd = 0; windowEnd < n; windowEnd++) {
            windowSum += a[windowEnd];

            while (windowSum >= s) {
                lengthOfSmallestSubArray = Math.min(lengthOfSmallestSubArray, windowEnd - windowStart + 1);
                windowSum -= a[windowStart];
                windowStart++;
            }
        }

        return lengthOfSmallestSubArray == Integer.MAX_VALUE ? 0 : lengthOfSmallestSubArray;
    }

}
