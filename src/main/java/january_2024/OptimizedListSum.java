package january_2024;

public class OptimizedListSum {

    int[] pre;

    public OptimizedListSum(int[] nums) {
        this.pre = new int[nums.length + 1];
        init(nums);
    }

    // O(n) time | O(n) space
    private void init(int[] nums) {
        int sum = 0;
        int counter = 1;
        for (int num : nums) {
            sum += num;
            pre[counter] = sum;
            counter++;
        }
    }

    // O(1) time | O(1) space
    public int sum(int start, int end) {
        return pre[end] - pre[start];
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        OptimizedListSum optimizedListSum = new OptimizedListSum(nums);
        int sum = optimizedListSum.sum(2, 5);
        System.out.println(sum);
    }


}
