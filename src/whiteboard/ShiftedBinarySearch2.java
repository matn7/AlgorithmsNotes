package whiteboard;

public class ShiftedBinarySearch2 {

    public static void main(String[] args) {
        int[] array = {45, 61, 71, 72, 73, 0, 1, 21, 33, 37};

        shiftedBinarySearch(array, 33);
    }

    public static int shiftedBinarySearch(int[] array, int target) {
        // Write your code here.
        int start = 0;
        int end = array.length - 1;
        while (start < end) {
            int mid = (end + start) / 2;
            if (array[mid] == target) {
                return mid;
            } else if (array[start] < array[mid]) {
                // left subarray sorted
                if (array[start] == target) {
                    return start;
                } else if (array[start] > target) {
                    start = mid + 1;
                } else {
                    if (array[mid] > target) {
                        end = mid - 1;
                    } else {
                        start = mid + 1;
                    }
                }
            } else {
                if (array[end] == target) {
                    return end;
                } else if (array[end] < target) {
                    end = mid - 1;
                } else {
                    if (array[mid] > target) {
                        end = mid - 1;
                    } else {
                        start = mid + 1;
                    }
                }
            }
        }
        return -1;
    }

}
