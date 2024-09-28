package problems.hard;

public class SearchForRange {

    public static void main(String[] args) {
        int[] array = {0, 1, 21, 33, 45, 45, 45, 45, 45, 45, 61, 71, 73};
        int target = 45;

        searchForRange(array, target);
    }

    // O(log(n)) time | O(1) space
    // OK - repeated 30/01/2022
    public static int[] searchForRange(int[] array, int target) {
        // Write your code here.
        // finalRange = [4, 9]
        int[] finalRange = {-1, -1};

        alteredBinarySearch(array, target, 0, array.length - 1, finalRange, true);
        alteredBinarySearch(array, target, 0, array.length - 1, finalRange, false);

        return finalRange;
    }

    private static void alteredBinarySearch(int[] array, int target, int left, int right, int[] finalRange,
                                            boolean goLeft) {
        // left = 0
        // right = 12
        //          0  1   2   3   4   5   6   7   8   9  10  11  12
        // array = [0, 1, 21, 33, 45, 45, 45, 45, 45, 45, 61, 71, 73]
        while (left <= right) {
            int mid = (left + right) / 2; // (7 + 12) / 2 = 9
            if (array[mid] < target) { // 45 < 45
                left = mid + 1;
            } else if (array[mid] > target) { // 45 > 45
                right = mid - 1;
            } else {
                if (goLeft) {
                    if (mid == 0 || array[mid - 1] != target) {
                        finalRange[0] = mid;
                        return;
                    } else {
                        right = mid - 1;
                    }
                } else {
                    if (mid == array.length - 1 || array[mid + 1] != target) {
                        finalRange[1] = mid;
                        return;
                    } else {
                        left = mid + 1;
                    }
                }
            }
        }
    }

    // O(log(n)) time | O(log(n)) space
    public static int[] searchForRangeRec(int[] array, int target) {
        // Write your code here.
        // array = [0, 1, 21, 33, 45, 45, 45, 45, 45, 45, 61, 71, 73]
        // finalRange = [4, 9]
        int[] finalRange = {-1, -1};

        alteredBinarySearchRec(array, target, 0, array.length - 1, finalRange, true); // left extreme
        alteredBinarySearchRec(array, target, 0, array.length - 1, finalRange, false); // right extreme

        return finalRange;
    }

    private static void alteredBinarySearchRec(int[] array, int target, int left, int right, int[] finalRange,
                                            boolean goLeft) {
        if (left > right) {
            return;
        }
        // goLeft = false
        // left = 7
        // right = 12
        // target = 45
        //          0  1   2   3   4   5   6   7   8   9  10  11  12
        // array = [0, 1, 21, 33, 45, 45, 45, 45, 45, 45, 61, 71, 73]
        int mid = (left + right) / 2; // (7 + 12) / 2 = 9
        if (array[mid] < target) { // 45 < 45
            alteredBinarySearchRec(array, target, mid + 1, right, finalRange, goLeft);
        } else if (array[mid] > target) { // 45 > 45
            alteredBinarySearchRec(array, target, left, mid - 1, finalRange, goLeft);
        } else {
            if (goLeft) {
                if (mid == 0 || array[mid - 1] != target) {
                    finalRange[0] = mid; // 4
                } else {
                    alteredBinarySearchRec(array, target, left, mid - 1, finalRange, goLeft);
                }
            } else {
                if (mid == array.length - 1 || array[mid + 1] != target) {
                    finalRange[1] = mid; // 9
                } else {
                    alteredBinarySearchRec(array, target, mid + 1, right, finalRange, goLeft);
                }
            }
        }
    }

}
