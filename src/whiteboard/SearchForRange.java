package whiteboard;

public class SearchForRange {

    public static void main(String[] args) {
        int[] array = {0, 1, 21, 33, 45, 45, 45, 45, 45, 45, 61, 71, 73};
        searchForRange(array, 45);
    }

    public static int[] searchForRange(int[] array, int target) {
        // Write your code here.
        int[] result = {-1, -1};

        checkRange(array, result, target, true);
        checkRange(array, result, target, false);

        return result;
    }

    // O(log(n)) time | O(1) space
    private static void checkRange(int[] array, int[] result, int target, boolean leftDirection) {
        int start = 0;
        int end = array.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            int midValue = array[mid];
            if (midValue == target) {
                if (leftDirection) {
                    if (mid == 0 || array[mid - 1] != target) {
                        result[0] = mid;
                        break;
                    } else {
                        end = mid - 1;
                    }
                } else {
                    if (mid == array.length - 1 || array[mid + 1] != target) {
                        result[1] = mid;
                        break;
                    } else {
                        start = mid + 1;
                    }
                }
            } else if (midValue > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
    }

}
