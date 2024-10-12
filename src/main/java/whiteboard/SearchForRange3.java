package whiteboard;

public class SearchForRange3 {

    public static void main(String[] args) {
        //                      |           | *
        //             0  1   2   3   4   5   6   7   8   9  10  11  12
        int[] array = {0, 1, 21, 33, 45, 45, 45, 45, 45, 45, 61, 71, 73};

        searchForRange(array, 45);
    }

    // O(log(n)) time | O(1) space
    public static int[] searchForRange(int[] array, int target) {
        // Write your code here.
//        int leftRange = searchForRangeHelper(array, target, true);
//        int rightRange = searchForRangeHelper(array, target, false);

        int leftRange = searchForRangeHelperRec(array, target, 0, array.length - 1, true);
        int rightRange = searchForRangeHelperRec(array, target, 0, array.length - 1, false);
        return new int[] {leftRange, rightRange};
    }

    private static int searchForRangeHelper(int[] array, int target, boolean leftRange) {
        int start = 0;
        int end = array.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (array[mid] == target) {
                if (mid == 0 || mid == array.length - 1) {
                    return mid;
                }
                if (leftRange) {
                    if (array[mid - 1] != target) {
                        return mid;
                    } else {
                        end = mid - 1;
                    }
                } else {
                    if (mid < array.length - 1 && array[mid + 1] != target) {
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

    private static int searchForRangeHelperRec(int[] array, int target, int start, int end, boolean leftRange) {
        if (start > end) {
            return -1;
        }
        int mid = (start + end) / 2;
        if (array[mid] == target) {
            if (mid == 0 || mid == array.length - 1) {
                return mid;
            }
            if (leftRange) {
                if (array[mid - 1] != target) {
                    return mid;
                } else {
                    return searchForRangeHelperRec(array, target, start, mid - 1, leftRange);
                }
            } else {
                if (mid < array.length - 1 && array[mid + 1] != target) {
                    return mid;
                } else {
                    return searchForRangeHelperRec(array, target, mid + 1, end, leftRange);
                }
            }
        } else if (array[mid] < target) {
            return searchForRangeHelperRec(array, target, mid + 1, end, leftRange);
        } else {
            return searchForRangeHelperRec(array, target, start, mid - 1, leftRange);
        }
    }

}
