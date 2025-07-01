package june_2025;

public class RemoveDuplicatesII {

    public static void main(String[] args) {
//        int[] nums = {1, 1, 1, 2, 2, 3};
        int[] nums = {0,0,1,1,1,1,2,3,3};

        RemoveDuplicatesII removeDuplicatesII = new RemoveDuplicatesII();
        int result = removeDuplicatesII.removeDuplicates(nums);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public int removeDuplicates(int[] nums) {
        int idx = 0;
        int pos = 0;
        while (idx < nums.length) {
            int curr = nums[idx];
            int count = 0;
            while (idx < nums.length && curr == nums[idx]) {
                idx++;
                count++;
            }

            int nextStart = Math.min(pos + 2, pos + count);
            for (int i = pos; i < nextStart; i++) {
                nums[i] = curr;
            }
            pos = nextStart;
        }
        return pos;
    }

}
