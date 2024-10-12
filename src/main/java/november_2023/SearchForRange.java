package november_2023;

public class SearchForRange {

    public static void main(String[] args) {
        int[] array = {0, 1, 21, 33, 45, 45, 45, 45, 45, 45, 61, 71, 73};
        int target = 45;

        searchForRange(array, target);
    }

    // O(log(n)) time | O(1) space
    public static int[] searchForRange(int[] array, int target) {
        // Write your code here.
        int leftIdx = searchForRangeHelper(array, target, true);
        int rightIdx = searchForRangeHelper(array, target, false);
        if (leftIdx == -1) {
            return new int[] {-1, -1};
        }
        return new int[] {leftIdx, rightIdx};
    }

    private static int searchForRangeHelper(int[] array, int target, boolean goLeft) {
        // [0, 1, 21, 33, 45, 45, 45, 45, 45, 45, 61, 71, 73]
        int start = 0;
        int end = array.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (array[mid] == target) {
                if (goLeft) {
                    if (mid == 0 || array[mid - 1] != target) {
                        return mid;
                    } else {
                        end = mid - 1;
                    }
                } else {
                    if (mid == array.length - 1 || array[mid + 1] != target) {
                        return mid;
                    } else {
                        start = mid + 1;
                    }
                }
            } else if (array[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
