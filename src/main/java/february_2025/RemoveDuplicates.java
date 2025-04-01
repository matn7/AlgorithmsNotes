package february_2025;

public class RemoveDuplicates {

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        int result = removeDuplicates.removeDuplicates(nums);
        System.out.println(result);
    }

    public int removeDuplicates(int[] nums) {
        // 0,0,1,1,1,2,2,3,3,4
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
