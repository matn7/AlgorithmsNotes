package february_2025;

public class RemoveDuplicatesII {

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 2, 3, 3};
    }

    public int removeDuplicates(int[] nums) {
        int L = 0;
        int R = 0;

        while (R < nums.length) {
            int count = 1;
            while (R + 1 < nums.length && nums[R] == nums[R + 1]) {
                R++;
                count++;
            }
            for (int i = 0; i < Math.min(2, count); i++) {
                nums[L] = nums[R];
                L++;
            }
            R++;
        }
        return L;
    }

}
