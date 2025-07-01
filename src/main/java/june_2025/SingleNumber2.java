package june_2025;

public class SingleNumber2 {

    public static void main(String[] args) {
        int[] nums = {4,1,2,1,2};

        SingleNumber2 singleNumber2 = new SingleNumber2();
        int result = singleNumber2.singleNumber(nums);
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
