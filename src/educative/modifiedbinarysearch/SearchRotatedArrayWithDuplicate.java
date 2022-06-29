package educative.modifiedbinarysearch;

public class SearchRotatedArrayWithDuplicate {

    public static void main(String[] args) {
        System.out.println(SearchRotatedArrayWithDuplicate.search(new int[] { 3, 7, 3, 3, 3 }, 7));
    }

    // O(n) time | O(1) space
    public static int search(int[] arr, int key) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == key) {
                return mid;
            }

            if ((arr[start] == arr[mid]) && (arr[end] == arr[mid])) {
                ++start;
                --end;
            } else if (arr[start] <= arr[mid]) { // left side is sorted in ascending order
                if (key >= arr[start] && key < arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (key > arr[mid] && key <= arr[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }

        return -1;
    }

}
