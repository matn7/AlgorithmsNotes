package january_2026;

public class FirstAndLastPos {

    public static void main(String[] args) {
//        int[] nums = {5, 7, 7, 8, 8, 10};
//        int target = 8;

        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 6;

        FirstAndLastPos firstAndLastPos = new FirstAndLastPos();
        int[] result = firstAndLastPos.searchRange(nums, target);
        System.out.println(result);
    }

    // O(log(n)) time | O(1) space
    public int[] searchRange(int[] nums, int target) {
        int left = findIndex(nums, target, true);
        if (left==-1) {
            return new int[]{-1, -1};
        }
        int right = findIndex(nums, target, false);

        return new int[]{left, right};
    }

    private int findIndex(int[] nums, int target, boolean searchLeft) {

        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int m = (l + r) / 2;
            if (target==nums[m]) {
                if (searchLeft) {
                    if (m==0 || nums[m - 1]!=target) {
                        return m;
                    } else {
                        r = m - 1;
                    }
                } else {
                    if (m==nums.length - 1 || nums[m + 1]!=target) {
                        return m;
                    } else {
                        l = m + 1;
                    }
                }
            } else if (target > nums[m]) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return -1;
    }

}
