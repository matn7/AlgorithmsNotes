package udemy.recursion;

public class BinarySearch {

    public static void main(String[] args) {
        int[] input = {11, 22, 33, 44, 55, 66, 77, 88, 99};
        int target = 177;

        int result = binarySearch(input, target, 0, input.length - 1);
        System.out.println();
    }

    // O(log(n)) time
    public static int binarySearch(int[] input, int target, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = start + (end - start) / 2;
        if (input[mid] == target) {
            return mid;
        } else if (input[mid] > target) {
            return binarySearch(input, target, start, mid - 1);
        } else {
            return binarySearch(input, target, mid + 1, end);
        }
    }

}
