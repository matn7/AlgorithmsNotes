package october_2024;

public class SortedArrToBst {

    public static void main(String[] args) {
        int[] nums = {-10, -3, 0, 5, 9};

        SortedArrToBst sorted = new SortedArrToBst();
        TreeNode result = sorted.sortedArrayToBST2(nums);
        System.out.println(result);

    }

    // O(nlog(n)) time | O(n) space
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        int midIdx = nums.length / 2;
        int val = nums[midIdx];
        int[] smaller = new int[midIdx];
        int[] larger = new int[nums.length - midIdx - 1];
        for (int i = 0; i < midIdx; i++) {
            smaller[i] = nums[i];
        }
        int counter = 0;
        for (int i = midIdx + 1; i < nums.length; i++) {
            larger[counter] = nums[i];
            counter++;
        }
        TreeNode newNode = new TreeNode(val);
        newNode.left = sortedArrayToBST(smaller);
        newNode.right = sortedArrayToBST(larger);
        return newNode;
    }

    // O(n) time | O(log(n)) space
    public TreeNode sortedArrayToBST2(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    private TreeNode helper(int[] nums, int startIdx, int endIdx) {
        if (startIdx > endIdx) {
            return null;
        }
        int midIdx = (startIdx + endIdx) / 2;
        int val = nums[midIdx];
        TreeNode newNode = new TreeNode(val);
        newNode.left = helper(nums, startIdx, midIdx - 1);
        newNode.right = helper(nums, midIdx + 1, endIdx);
        return newNode;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

}
