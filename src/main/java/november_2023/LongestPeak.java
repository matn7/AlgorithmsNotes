package november_2023;

public class LongestPeak {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 3, 4, 0, 10, 6, 5, -1, -3, 2, 3};

        int result = longestPeak(array);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public static int longestPeak(int[] array) {
        int maxPeak = Integer.MIN_VALUE;

        for (int i = 1; i < array.length - 1; i++) {
            if (isPeak(array, i)) {
                int currSize = 3;
                int toLeft = i - 2;
                while (toLeft >= 0 && array[toLeft] < array[toLeft + 1]) {
                    toLeft--;
                    currSize++;
                }

                int toRight = i + 2;
                while (toRight <= array.length - 1 && array[toRight] < array[toRight - 1]) {
                    toRight++;
                    currSize++;
                }

                maxPeak = Math.max(maxPeak, currSize);
                i = toRight - 1;
            }
        }

        return maxPeak == Integer.MIN_VALUE ? 0 : maxPeak;
    }

    private static boolean isPeak(int[] array, int idx) {
        return array[idx] > array[idx - 1] && array[idx] > array[idx + 1];
    }

}
