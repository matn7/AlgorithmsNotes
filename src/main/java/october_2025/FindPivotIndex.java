package october_2025;

public class FindPivotIndex {

    public static void main(String[] args) {
//        int[] nums = {1,7,3,6,5,6};
        int[] nums = {0, 1};

        FindPivotIndex findPivotIndex = new FindPivotIndex();
        int result = findPivotIndex.pivotIndex(nums);
        System.out.println(result);
    }

    public int pivotIndex(int[] nums) {
        int[] prefix = new int[nums.length];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            prefix[i] = sum;
        }
        for (int i = 0; i < nums.length; i++) {
            int left;
            int right;
            if (i == 0) {
                left = 0;
                right = prefix[prefix.length - 1] - prefix[i];
            } else if (i == nums.length - 1) {
                left = prefix[i - 1];
                right = 0;
            } else {
                left = prefix[i - 1];
                right = prefix[prefix.length - 1] - prefix[i];
            }
            if (left == right) {
                return i;
            }
        }
        return -1;
    }

}
