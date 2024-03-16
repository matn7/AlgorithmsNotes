package january_2024;

public class SortedSquareNumbers {

    public static void main(String[] args) {
        int[] nums = {-5, -3, -1, 0, 1, 4, 5};

        int[] result = sortedSquares(nums);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public static int[] sortedSquares(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        int index = nums.length - 1;
        int[] result = new int[nums.length];
        // [5, -3, -1, 0, 1, 4, 5]
        //  s                   e

        while (start < end) {
            int startSquare = nums[start] * nums[start]; // 25
            int endSquare = nums[end] * nums[end]; // 25
            if (endSquare > startSquare) {
                result[index] = endSquare;
                end--;
            } else {
                result[index] = startSquare;
                start++;
            }
            index--;
        }
        return result;
    }

}
