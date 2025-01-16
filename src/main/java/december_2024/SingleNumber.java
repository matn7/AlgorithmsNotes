package december_2024;

public class SingleNumber {

    public static void main(String[] args) {
        int[] nums = {4, 1, 2, 1, 2};

        SingleNumber singleNumber = new SingleNumber();
        int result = singleNumber.singleNumber(nums);
        System.out.println(result);
    }

    public int singleNumber(int[] nums) {
        int num = 0;
        for (int n : nums) {
            num ^= n;
        }
        return num;
    }

}
