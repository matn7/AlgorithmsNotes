package udemy.leetcode;

public class FloorOfNumber {

    public static void main(String[] args) {
        // ceiling = smallest elem greater than or equal to target elem
        // arr = [2, 3, 5, 7, 9, 14, 16, 18]    target = 15
        int[] arr = {2, 3, 5, 7, 9, 14, 16, 18};
        int target = 15;

        FloorOfNumber floorOfNumber = new FloorOfNumber();
        int answer = floorOfNumber.floor(arr, target);
        System.out.println(answer);
    }

    // O(n) time | O(1) space
    public int floor(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        if (target > arr[arr.length - 1]) {
            return -1;
        }

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return end;
    }
}
