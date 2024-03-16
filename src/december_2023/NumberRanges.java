package december_2023;

public class NumberRanges {

    public static void main(String[] args) {
        int[] nums = {1, 3, 3, 5, 7, 8, 9, 9, 9, 9, 9, 9, 9, 11, 15};
        int target = 9;

//        ranges(nums, target);
        getRange(nums, target);
    }

    // O(log(n)) time | O(1) space
    public static int[] ranges(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = getRange(nums, target, true);
        result[1] = getRange(nums, target, false);
        if (result[0] == -1 || result[1] == -1) {
            return new int[] {-1, -1};
        }
        return result;
    }

    private static int getRange(int[] nums, int target, boolean goLeft) {
        int start = 0;
        int end = nums.length - 1;

        //  0  1  2  3  4  5  6  7   8
        // [1, 3, 3, 5, 7, 8, 9, 9, 15]
        //                    *
        //                 s
        //                           e

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                if (goLeft) {
                    if (mid == 0) {
                        return mid;
                    }
                    if (nums[mid - 1] != target) {
                        return mid;
                    } else {
                        end = mid - 1;
                    }
                } else {
                    if (mid == nums.length - 1) {
                        return mid;
                    }
                    if (nums[mid + 1] != target) {
                        return mid;
                    } else {
                        start = mid + 1;
                    }
                }
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    // O(log(n)) time | O(log(n)) space
    public static int[] getRange(int[] arr, int target) {
        int first = binarySearch(arr, 0, arr.length - 1, target, true);
        int last = binarySearch(arr, 0, arr.length - 1, target, false);
        return new int[] {first, last};
    }

    private static int binarySearch(int[] arr, int low, int high, int target, boolean findFirst) {
        if (high < low) {
            return -1;
        }
        int mid = low + (high - low) / 2;
        if (findFirst) {
            if ((mid == 0 || target > arr[mid - 1]) && arr[mid] == target) {
                return mid;
            }
            if (target > arr[mid]) {
                return binarySearch(arr, mid + 1, high, target, findFirst);
            } else {
                return binarySearch(arr, low, mid - 1, target, findFirst);
            }
        } else {
            if ((mid == arr.length - 1 || target < arr[mid + 1]) && arr[mid] == target) {
                return mid;
            }
            if (target < arr[mid]) {
                return binarySearch(arr, low, mid - 1, target, findFirst);
            } else {
                return binarySearch(arr, mid + 1, high, target, findFirst);
            }
        }
    }

}
