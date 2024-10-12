package star;

public class FindNonDuplicate {

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 4, 1, 3, 2};

        FindNonDuplicate findNonDuplicate = new FindNonDuplicate();
        int result = findNonDuplicate.findSingleNumber(nums);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public int findSingleNumber(int[] nums) {
        int unique = 0;

        for (int n : nums) {
            unique ^= n;
        }

        return unique;
    }

}
