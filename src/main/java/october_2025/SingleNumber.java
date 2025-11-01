package october_2025;

public class SingleNumber {

    public static void main(String[] args) {
        int[] nums = {4,1,2,1,2};

        SingleNumber singleNumber = new SingleNumber();
        int result = singleNumber.singleNumber(nums);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }

}
