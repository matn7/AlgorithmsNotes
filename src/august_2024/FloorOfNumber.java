package august_2024;

public class FloorOfNumber {

    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 7, 9, 14, 16, 18};
        int target = 15;

        int result = floorOfNumber(arr, target);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public static int floorOfNumber(int[] arr, int target) {

        //        0  1  2  3  4   5   6   7
        // arr = [2, 3, 5, 7, 9, 14, 16, 18]
        //        s                       e
        //                 m
        if (target > arr[arr.length - 1]) {
            return -1;
        }
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return end;
    }

}
