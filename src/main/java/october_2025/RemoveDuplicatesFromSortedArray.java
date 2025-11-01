package october_2025;

public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};

        RemoveDuplicatesFromSortedArray removeDuplicatesFromSortedArray = new RemoveDuplicatesFromSortedArray();
        int result = removeDuplicatesFromSortedArray.removeDuplicates(nums);
        System.out.println(result);

    }

    // O(n) time | O(1) space
    public int removeDuplicates(int[] nums) {
        int l = 0;
        int r = 0;

        while (r < nums.length) {
            nums[l] = nums[r];
            while (r < nums.length && nums[r] == nums[l]) {
                r++;
            }
            l++;
        }
        return l;
    }

}
