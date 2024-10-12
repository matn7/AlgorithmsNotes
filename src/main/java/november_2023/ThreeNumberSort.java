package november_2023;

public class ThreeNumberSort {

    public static void main(String[] args) {
        int[] arr = {1, 0, 0, -1, -1, 0, 1, 1};
        int[] order = {0, 1, -1};

        threeNumberSort(arr, order);
    }

    // O(n) time | O(1) space
    public static int[] threeNumberSort(int[] arr, int[] order) {
        if (arr.length == 0) {
            return arr;
        }

        //         f
        // [ 0, 0, 0,  1,  1, 1, -1, -1]
        //                    *
        //                    l

        int firstIdx = 0;
        int lastIdx = arr.length - 1;
        int firstNum = order[0];  // 0
        int lastNum = order[order.length - 1];    // -1
        int idx = 0;

        while (idx <= lastIdx) {
            if (arr[idx] == firstNum) {  // 0 == 0
                swap(arr, idx, firstIdx);
                firstIdx++;
                idx++;
            } else if (arr[idx] == lastNum) {
                swap(arr, idx, lastIdx);
                lastIdx--;
            } else {
                idx++;
            }
        }
        return arr;
    }
    
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
