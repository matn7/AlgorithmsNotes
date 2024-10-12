package august_2024;

public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 5, 6, 9, 10};

        System.out.println(bSearch(arr, 9));
        System.out.println(bSearch(arr, 1));
        System.out.println(bSearch(arr, 13));
        System.out.println();
        System.out.println(bSearchRec(arr, 9));
        System.out.println(bSearchRec(arr, 1));
        System.out.println(bSearchRec(arr, 13));
    }

    public static int bSearch(int[] arr, int target) {
        //        0  1  2  3  4  5   6
        // arr = [0, 1, 2, 5, 6, 9, 10]
        //                 *
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int mid = end - (end - start) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1;
    }

    public static int bSearchRec(int[] arr, int target) {
        return bSearchRecHelper(arr, target, 0, arr.length - 1);
    }

    private static int bSearchRecHelper(int[] arr, int target, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = end - (end - start) / 2;
        if (arr[mid] == target) {
            return mid;
        } else if (arr[mid] < target) {
            return bSearchRecHelper(arr, target, mid + 1, end);
        } else {
            return bSearchRecHelper(arr, target, start, mid - 1);
        }

    }

}
