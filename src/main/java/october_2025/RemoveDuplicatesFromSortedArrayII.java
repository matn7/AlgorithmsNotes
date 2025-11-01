package october_2025;

public class RemoveDuplicatesFromSortedArrayII {

    public static void main(String[] args) {
//        int[] nums = {1,1,1,2,2,3};
        int[] nums = {0,0,1,1,1,1,2,3,3};
        RemoveDuplicatesFromSortedArrayII removeDuplicatesFromSortedArrayII = new RemoveDuplicatesFromSortedArrayII();
        int result = removeDuplicatesFromSortedArrayII.removeDuplicates(nums);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public int removeDuplicates(int[] nums) {
        int l = 0;
        int r = 0;

        while (r < nums.length) {
            int num = nums[r];
            int count = 0;
            while (r < nums.length && nums[r] == num) {
                count++;
                r++;
            }
            for (int i = 0; i < Math.min(2, count); i++) {
                nums[l] = num;
                l++;
            }
        }
        return l;
    }

}
