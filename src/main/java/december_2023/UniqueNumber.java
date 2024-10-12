package december_2023;

public class UniqueNumber {

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 4, 1, 3, 2};

        int result = uniqueNumber(nums);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public static int uniqueNumber(int[] nums) {
        int num = 0;
        for (int n : nums) {
            num ^= n;
        }
        return num;
    }

}
