package whiteboard;

public class ThreeNumberSort {

    public static void main(String[] args) {
        int[] array = {1, 0, 0, -1, -1, 0, 1, 1};
        int[] order = {0, 1, -1};

        ThreeNumberSort tns = new ThreeNumberSort();
        tns.threeNumberSort(array, order);
    }

    // O(n) time | O(1) space
    public int[] threeNumberSort(int[] array, int[] order) {
        // Write your code here.
        int start = 0;
        int end = array.length - 1;
        int idx = 0;
        while (idx <= end) {
            if (array[idx] == order[0]) {
                swap(array, start, idx);
                start++;
                idx++;
            } else if (array[idx] == order[2]) {
                swap(array, end, idx);
                end--;
            } else {
                idx++;
            }
        }
        return array;
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
