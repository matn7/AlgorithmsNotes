package september_2025;

public class FindMinInRotatedSortedArray {

    public static void main(String[] args) {
//        int[] nums = {4,5,6,7,0,1,2};

//        int[] nums = {11,13,15,17};

        int[] nums = {3,4,5,1,2};

//        int[] nums = {5,1,2,3,4};

        FindMinInRotatedSortedArray findMinInRotatedSortedArray = new FindMinInRotatedSortedArray();
        int result = findMinInRotatedSortedArray.findMin(nums);
        System.out.println(result);
    }

    // O(log(n)) time | O(1) space
    public int findMin(int[] nums) {
        // [5, 1, 2, 3, 4]
        //  l     *     r

        int l = 0;
        int r = nums.length - 1;
        int minVal = nums[0];

        while (l <= r) {
            if (nums[l] <= nums[r]) {
                // sorted range
                minVal = Math.min(minVal, nums[l]);
                break;
            }
            int m = (l + r) / 2;
            minVal = Math.min(minVal, nums[m]); // ()
            if (nums[m] <= nums[r]) {
                // right sorted m, is min in this case
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return minVal;
    }

}
