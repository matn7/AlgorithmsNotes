package may_2024;

public class BinarySearch {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};

        int result = binarySearch(nums, 5);
        System.out.println(result);
    }

    // O(log(n)) time | O(1) space
    public static int binarySearch(int[] nums, int value) {

        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = end - (end - start) / 2; // (2end - end + start) / 2
//            int mid = (start + end) / 2;
            if (nums[mid] == value) {
                return mid;
            } else if (nums[mid] < value) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1;
    }

}
