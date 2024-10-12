package problems.other;

public class OptimizedListSum {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};

        ListFastSum listFastSum = new ListFastSum();
        listFastSum.init(nums);
        int result = listFastSum.sum(2, 5);
        System.out.println(result);
    }

}

class ListFastSum {
    int[] pre;

    // O(n) time | O(n) space
    public void init(int[] nums) {
        pre = new int[nums.length + 1];
        pre[0] = 0;

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            sum += num;
            pre[i + 1] = sum;
        }
    }

    // O(1) time | O(1) space
    public int sum(int start, int end) {
        return pre[end] - pre[start];
    }
}
