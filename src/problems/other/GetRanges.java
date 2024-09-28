package problems.other;

public class GetRanges {

    public static void main(String[] args) {
        int[] nums = {1, 3, 3, 5, 7, 8, 9, 9, 9, 15};
        int target = 9;

        GetRanges getRanges = new GetRanges();
        int[] result = getRanges.getRange(nums, target);
        System.out.println();
    }

    public int[] getRange(int[] arr, int target) {
        int first = binarySearchIterative(arr, 0, arr.length - 1, target, true);
        int last = binarySearchIterative(arr, 0, arr.length - 1, target, false);
        return new int[] {first, last};
    }

    // O(log(n)) time | O(log(n)) space
    private int binarySearch(int[] arr, int low, int high, int target, boolean findFirst) {
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

    // O(log(n)) time | O(1) space
    private int binarySearchIterative(int[] arr, int low, int high, int target, boolean findFirst) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (findFirst) {
                if ((mid == 0 || target > arr[mid - 1]) && arr[mid] == target) {
                    return mid;
                }
                if (target > arr[mid]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            } else {
                if ((mid == arr.length - 1 || target < arr[mid + 1]) && arr[mid] == target) {
                    return mid;
                }
                if (target < arr[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }


    public int[] getRangesMy(int[] nums, int target) {
        int leftRange = getRangeMy(nums, target, true);
        int rightRange = getRangeMy(nums, target, false);

        return new int[] {leftRange, rightRange};
    }

    private int getRangeMy(int[] nums, int target, boolean goLeft) {
        int start = 0;
        int end = nums.length;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                if (goLeft) {
                    if (mid == 0 || nums[mid - 1] != target) {
                        return mid;
                    } else {
                        end = mid - 1;
                    }
                } else {
                    if (mid == nums.length - 1 || nums[mid + 1] != target) {
                        return mid;
                    } else {
                        start = mid + 1;
                    }
                }

            } else if (nums[mid] < target) {
                // 0  1  2  3  4  5  6  7   8
                //             *  s  *      e
                // 1, 3, 3, 5, 7, 9, 9, 9, 15
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

}
