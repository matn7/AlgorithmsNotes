package coderpro;

public class FindNonDuplicate2 {

    public static void main(String[] args) {
        //                        *
        int[] nums = {4, 3, 2, 4, 1, 3, 2, 1, 7};

        FindNonDuplicate2 findNonDuplicate2 = new FindNonDuplicate2();
        findNonDuplicate2.singleNumber(nums);
    }

    // O(n) time | O(1) space
    public int singleNumber(int[] nums) {
        int num = 0;

        // 0 0 0 1
        for (int n : nums) {
            num ^= n;
        }

        return num;
    }

}
