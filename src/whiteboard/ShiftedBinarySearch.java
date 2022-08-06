package whiteboard;

public class ShiftedBinarySearch {

    public static void main(String[] args) {
        int[] array = {61, 71, 72, 73, 0, 1, 21, 33, 37, 45};

        shiftedBinarySearch(array, 33);
    }

    // O(log(n)) time | O(1) space
    // rand: 28/07/2022
    public static int shiftedBinarySearch(int[] array, int target) {
        // Write your code here.
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (array[mid] == target) {
                return mid;
            } else if (array[left] < array[mid]) {
                if (array[left] == target) {
                    return left;
                } else if (array[left] > target) {
                    left = mid + 1;
                } else {
                    if (array[mid] > target) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }
            } else {
                if (array[right] == target) {
                  return right;
                } if (array[right] < target) {
                    right = mid - 1;
                } else {
                    if (array[mid] > target) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }
            }
        }
        return -1;
    }

}
