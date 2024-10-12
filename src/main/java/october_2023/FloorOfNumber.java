package october_2023;

public class FloorOfNumber {

    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 7, 9, 14, 16, 18};
        int target = 15;

        System.out.println(floorOfNumber(arr, target));
    }

    // O(log(n)) time | O(1) space
    public static int floorOfNumber(int[] arr, int target) {

        int start = 0;
        int end = arr.length - 1;

        if (target > arr[arr.length - 1]) {
            return -1;
        }

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                return target;
            } else if (arr[mid] > target) { // 9 > 15
                // [2, 3, 5, 7, 9, 14, 16, 18]  9 > 15
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return end;

    }

}
