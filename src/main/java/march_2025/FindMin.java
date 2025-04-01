package march_2025;

public class FindMin {

    public static void main(String[] args) {
//        int[] nums = {3, 4, 5, 1, 2};
//        int[] nums = {4,5,6,7,0,1,2};
//        int[] nums = {11,13,15,17};
//        int[] nums = {3, 1, 2};
//        int[] nums = {1};
        int[] nums = {5, 1, 2, 3, 4};

        FindMin findMin = new FindMin();
        int result = findMin.findMin(nums);
        System.out.println(result);
    }

    public int findMin(int[] nums) {
        int L = 0;
        int R = nums.length - 1;

        while (L <= R) {
            int M = (L + R) / 2;
            if (nums[L] <= nums[M]) {
                // left sorted
                if (nums[L] <= nums[R]) {
                    return nums[L];
                } else {
                    L = M + 1;
                }
            } else {
                // right sorted
                if (nums[M] <= nums[R]) {
                    if (M > 0 && nums[M - 1] <= nums[M]) {
                        R = M - 1;
                    } else {
                        return nums[M];
                    }
                } else {
                    R = M - 1;
                }
            }
        }
        return -1;
    }

}
