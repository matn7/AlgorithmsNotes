package udemy.faang;

public class BinarySearch {

    // O(log(n)) time | O(1) space
    public int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            int foundVal = array[mid];
            if (foundVal == target) {
                return mid;
            } else if (foundVal < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

}
