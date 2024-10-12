package may_2024;

public class StartAndEndValues {

    public static void main(String[] args) {
        int[] array = {1, 3, 3, 5, 5, 5, 8, 8};
        int target = 5;

        int[] result = ranges(array, target);
        System.out.println(result);
    }

    // O(log(n)) time | O(1) space or O(log(n)) space
    public static int[] ranges(int[] array, int target) {
        if (array.length == 0) {
            return new int[] {-1, -1};
        }
//        int leftIdx = binarySearch(array, target, true);
//        int rightIdx = binarySearch(array, target, false);

        int leftIdx = binarySearchRec(array, target, 0, array.length - 1, true);
        int rightIdx = binarySearchRec(array, target, 0, array.length - 1, false);

        return new int[] {leftIdx, rightIdx};
    }

    private static int binarySearch(int[] array, int target, boolean scanLeft) {
        int start = 0;
        int end = array.length - 1;

        while (start <= end) {
            int mid = end - (end - start) / 2;
            if (array[mid] == target) {
                if (scanLeft) {
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

    private static int binarySearchRec(int[] array, int target, int start, int end, boolean scanLeft) {
        if (start > end) {
            return -1;
        }

        int mid = end - (end - start) / 2;
        if (array[mid] == target) {
            if (scanLeft) {
                if (mid == 0 || array[mid - 1] != target) {
                    return mid;
                } else {
                    return binarySearchRec(array, target, start, mid - 1, scanLeft);
                }
            } else {
                if (mid == array.length - 1 || array[mid + 1] != target) {
                    return mid;
                } else {
                    return binarySearchRec(array, target, mid + 1, end, scanLeft);
                }
            }
        } else if (array[mid] < target) {
            return binarySearchRec(array, target, mid + 1, end, scanLeft);
        } else {
            return binarySearchRec(array, target, start, mid - 1, scanLeft);
        }
    }

}
