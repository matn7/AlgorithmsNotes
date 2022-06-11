package easy;

public class SortedSquareArray {

    public static void main(String[] args) {
        SortedSquareArray sortedSquareArray = new SortedSquareArray();
        int[] array = {-7, -5, -4, 3, 6, 8, 9};

        sortedSquareArray.sortedSquaredArray(array);
    }

    // OK - repeated 04/03/2022
    // [-7, -5, -4, 3, 6, 8, 9]
    // O(n) time | O(n) space
    public int[] sortedSquaredArray(int[] array) {
        int start = 0;
        int end = array.length - 1;

        //                      se
        // array  = [-7, -5, -4, 3, 6, 8, 9]
        int[] result = new int[array.length];
        // result = [ 9,  16,  25, 36, 49, 64, 81]
        for (int i = array.length - 1; i >= 0; i--) {
            if (Math.abs(array[start]) > Math.abs(array[end])) { // 3 > 3
                result[i] = array[start] * array[start];
                start++;
            } else {
                result[i] = array[end] * array[end]; // 64
                end--;
            }
        }
        return result; // [ 9,  16,  25, 36, 49, 64, 81]
    }


}
