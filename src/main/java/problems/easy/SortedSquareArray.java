package problems.easy;

public class SortedSquareArray {

    public static void main(String[] args) {
        SortedSquareArray sortedSquareArray = new SortedSquareArray();
        int[] array = {-7, -5, -4, 3, 6, 8, 9};

        sortedSquareArray.sortedSquaredArray(array);
    }

    // O(n) time | O(n) space
    public int[] sortedSquaredArray(int[] array) {
        int start = 0;
        int end = array.length - 1;

        int[] result = new int[array.length];
        for (int i = array.length - 1; i >= 0; i--) {
            if (Math.abs(array[start]) > Math.abs(array[end])) {
                result[i] = array[start] * array[start];
                start++;
            } else {
                result[i] = array[end] * array[end];
                end--;
            }
        }
        return result;
    }
}
