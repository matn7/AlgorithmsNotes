package may_2024;

public class ShiftedBinarySearch {

    public static void main(String[] args) {
        int[] arr = {45, 61, 71, 72, 73, 0, 1, 21, 33, 37};
        int target = 33;

        int result = shiftedBinarySearch(arr, target);
        System.out.println(result);
    }


    public static int shiftedBinarySearch(int[] arr, int target) {
        return shiftedBinarySearchHelper(arr, target, 0, arr.length - 1);
    }

    private static int shiftedBinarySearchHelper(int[] arr, int target, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = (start + end) / 2;
        if (arr[mid] == target) {
            return mid;
        } else if (arr[mid] > target) {
            if (arr[start] < arr[mid] && arr[start] > target) {
                return shiftedBinarySearchHelper(arr, target, mid + 1, end);
            } else {
                return shiftedBinarySearchHelper(arr, target, start, mid - 1);
            }
        } else {
            if (arr[end] > arr[mid] && arr[end] < target) {
                return shiftedBinarySearchHelper(arr, target, start, mid - 1);
            } else {
                return shiftedBinarySearchHelper(arr, target, mid + 1, end);
            }
        }
    }


}
