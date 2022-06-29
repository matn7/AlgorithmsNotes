package educative.modifiedbinarysearch;

public class FindRange {

    // O(log(n)) time | O(1) space
    public static int[] findRange(int[] arr, int key) {
        int[] result = new int[] { -1, -1 };
        result[0] = search(arr, key, false);
        if (result[0] != -1) {
            result[1] = search(arr, key, true);
        }
        return result;
    }

    private static int search(int[] arr, int key, boolean findMaxIndex) {
        int keyIndex = -1;
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (key < arr[mid]) {
                end = mid - 1;
            } else if (key > arr[mid]) {
                start = mid + 1;
            } else {
                keyIndex = mid;
                if (findMaxIndex) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return keyIndex;
    }

}
