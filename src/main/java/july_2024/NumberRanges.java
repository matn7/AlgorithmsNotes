package july_2024;

public class NumberRanges {

    public static void main(String[] args) {
        int[] arr = {1, 3, 3, 5, 7, 8, 9, 9, 15};
        int target = 9;

//        int[] arr = {1, 3, 5};
//        int target = 4;

//        int[] arr = {};
//        int target = 9;

        numberRanges(arr, target);
        numberRangesRec(arr, target);
    }

    // O(log(n) time | O(1) space
    public static int[] numberRanges(int[] arr, int target) {
        if (arr.length == 0) {
            return new int[] {-1, -1};
        }
        int leftIdx = getIdx(arr, target, true);
        int rightIdx = getIdx(arr, target, false);

        return new int[] {leftIdx, rightIdx};
    }

    private static int getIdx(int[] arr, int target, boolean searchLeft) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int mid = end - (end - start) / 2;
            if (arr[mid] == target) {
                if (searchLeft) {
                    if (mid == 0 || arr[mid - 1] != target) {
                        return mid;
                    } else {
                        end = mid - 1;
                    }
                } else {
                    if (mid == arr.length - 1 || arr[mid + 1] != target) {
                        return mid;
                    } else {
                        start = mid + 1;
                    }
                }
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    // O(log(n) time | O(log(n)) space
    public static int[] numberRangesRec(int[] arr, int target) {
        if (arr.length == 0) {
            return new int[] {-1, -1};
        }
        int leftIdx = getIdxRec(arr, target, 0, arr.length - 1, true);
        int rightIdx = getIdxRec(arr, target, 0, arr.length - 1, false);

        return new int[] {leftIdx, rightIdx};
    }

    private static int getIdxRec(int[] arr, int target, int start, int end, boolean searchLeft) {
        if (start > end) {
            return -1;
        }

        int mid = end - (end - start) / 2;
        if (arr[mid] == target) {
            if (searchLeft) {
                if (mid == 0 || arr[mid - 1] != target) {
                    return mid;
                } else {
                    return getIdxRec(arr, target, start, mid - 1, searchLeft);
                }
            } else {
                if (mid == arr.length - 1 || arr[mid + 1] != target) {
                    return mid;
                } else {
                    start = mid + 1;
                    return getIdxRec(arr, target, mid + 1, end, searchLeft);
                }
            }
        } else if (arr[mid] < target) {
            start = mid + 1;
            return getIdxRec(arr, target, mid + 1, end, searchLeft);
        } else {
            return getIdxRec(arr, target, start, mid - 1, searchLeft);
        }
    }

}
