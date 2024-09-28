package problems.other;

public class SortedSquareNumbers {

    public static void main(String[] args) {
        int[] nums = {-5, -3, -1, 0, 1, 4, 5};

        SortedSquareNumbers sortedSquareNumbers = new SortedSquareNumbers();
        sortedSquareNumbers.sortedSquared(nums);
    }

    // talk about problems.other alternative not optimal solutions

    // O(n) time | O(1) space
    public int[] sortedSquared(int[] nums) {
        int[] result = new int[nums.length];
        int index = nums.length - 1;
        int start = 0;
        int end = nums.length - 1;

        // -5, -3, -1, 0, 1, 4, 5
        //          s     e

        // [0, 1, 1, 9, 16, 25, 25]
        //        i
        while (start <= end) {
            int startNum = nums[start] * nums[start]; // 9
            int endNum = nums[end] * nums[end]; // 1
            if (endNum > startNum) {
                result[index] = endNum;
                end--;
            } else {
                result[index] = startNum;
                start++;
            }
            index--;
        }

        return result;
    }

}

