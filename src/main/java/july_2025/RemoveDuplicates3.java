package july_2025;

public class RemoveDuplicates3 {

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        RemoveDuplicates3 removeDuplicates3 = new RemoveDuplicates3();
        int result = removeDuplicates3.removeDuplicates(nums);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public int removeDuplicates(int[] nums) {
        int L = 0;
        int R = 0;

        while (R < nums.length) {
            nums[L] = nums[R];
            while (R < nums.length && nums[L] == nums[R]) {
                R++;
            }
            L++;
        }
        return L;
    }

}
