package problems.other;

public class GetRanges2 {

    public static void main(String[] args) {
        //           0  1  2  3  4  5  6  7  8  9
        //                          *
        int[] arr = {1, 9, 9, 9, 9, 9, 9, 9, 9, 9, 15};
        //                          s  e
        int target = 9;

        GetRanges2 getRanges2 = new GetRanges2();
        int[] result = getRanges2.getRanges(arr, target);
        System.out.println(result);
    }

    // O(log(n)) time | O(1) space
    public int[] getRanges(int[] arr, int target) {
        int firstIdx = binarySearchRec(arr, target, true, 0, arr.length - 1);
        int secondIdx = binarySearchRec(arr, target, false, 0, arr.length - 1);

        return new int[] {firstIdx, secondIdx};
    }

    public int binarySearch(int[] array, int target, boolean goLeft) {
        int start = 0;
        int end = array.length - 1;

        while (start <= end) {
            int mid = end - (end - start) / 2;
            if (array[mid] == target) {
                // return mid;
                if (mid == 0 || mid == array.length - 1) {
                    return mid;
                }
                if (goLeft) {
                    if (array[mid - 1] != target) {
                        return mid - 1;
                    } else {
                        end = mid - 1;
                    }
                } else {
                    if (mid < array.length - 1 && array[mid + 1] != target) {
                        return mid + 1;
                    } else {
                        start = mid + 1;
                    }
                }
            } else if (array[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }


    // O(log(n)) time | O(log(n)) space
    public int binarySearchRec(int[] array, int target, boolean goLeft, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = end - (end - start) / 2;
        if (array[mid] == target) {
            // return mid;
            if (mid == 0 || mid == array.length - 1) {
                return mid;
            }
            if (goLeft) {
                if (array[mid - 1] != target) {
                    return mid - 1;
                } else {
                    return binarySearchRec(array, target, goLeft, start, mid - 1);
                }
            } else {
                if (mid < array.length - 1 && array[mid + 1] != target) {
                    return mid + 1;
                } else {
                    return binarySearchRec(array, target, goLeft, mid + 1, end);
                }
            }
        } else if (array[mid] > target) {
            return binarySearchRec(array, target, goLeft, start, mid - 1);
        } else {
            return binarySearchRec(array, target, goLeft, mid + 1, end);
        }
    }

}
