package whiteboard;

public class SortedSquaredArray {

    // O(n) time | O(n) space
    // #2: 07/07/2022
    public int[] sortedSquaredArray(int[] array) {
        // Write your code here.
        int[] result = new int[array.length];
        int k = result.length - 1;
        int start = 0;
        int end = array.length - 1;
        while (start <= end) {
            int startSquare = array[start] * array[start];
            int endSquare = array[end] * array[end];
            if (endSquare > startSquare) {
                result[k] = endSquare;
                end--;
            } else {
                result[k] = startSquare;
                start++;
            }
            k--;
        }
        return result;
    }

}
