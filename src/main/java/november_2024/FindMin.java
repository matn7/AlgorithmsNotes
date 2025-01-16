package november_2024;

public class FindMin {

    public static void main(String[] args) {
//        int[] nums = {3, 4, 5, 1, 2};
//        int[] nums = {5, 1, 2, 3, 4};
//        int[] nums = {4,5,6,7,0,1,2};
        int[] nums = {11,13,15,17};

        FindMin findMin = new FindMin();
        int min = findMin.findMin(nums);
        System.out.println(min);
    }

    public int findMin(int[] nums) {

        int l = 0;
        int r = nums.length - 1;

        int res = Integer.MAX_VALUE;
        while (l <= r) {
            int m = l + (r - l) / 2;
            int numL = nums[l];
            int numR = nums[r];
            int numM = nums[m];
            res = Math.min(res, numM);
            if (numM >= numL) {
                // left sorted
                if (numM >= numR) {
                    // min value on the right
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            } else {
                // left not sorted
                if (numM <= numR) {
                    // right sorted - but left not so keep looking on left side
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            }
        }
        return res;
    }

    int findMin2(int[] nums) {
        int res = nums[0];
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            if (nums[l] < nums[r]) {
                res = Math.min(res, nums[l]);
                break;
            }
            int m = (l + r) / 2;
            res = Math.min(res, nums[m]);
            if (nums[m] >= nums[l]) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return res;
    }

}
