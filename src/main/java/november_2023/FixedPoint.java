package november_2023;

public class FixedPoint {

    public static void main(String[] args) {
        int[] nums = {-5, 1, 3, 4};
//        int[] nums = {1, 2, 3, 3, 99, 100, 102, 189, 286};

        int result = fixedPoint(nums);
        System.out.println(result);
    }

    // O(log(n)) time | O(1) space
    public static int fixedPoint(int[] nums) {

        int start = 0;
        int end = nums.length - 1;
        int number = Integer.MAX_VALUE;

        while (start <= end) {
            int mid = (end + start) / 2;
            if (nums[mid] == mid) {
                number = Math.min(number, mid);
                end = mid - 1;
            } else if (nums[mid] > mid) { // 99 > 4
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return number;
    }

}
