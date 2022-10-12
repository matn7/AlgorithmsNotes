package udemy.faang;

public class QuickSelect {

    public static void main(String[] args) {
        int[] array = {5, 3, 1, 6, 4, 2};

        int k = 2;
        QuickSelect quickSelect = new QuickSelect();
        int kth = quickSelect.quickSelect(array, 0, array.length - 1, array.length - k);
        System.out.println();
    }

    // tail recursion
    // O(n^2) time (worst) | O(1) space
    // O(n) time (average) | O(1) space
    public int quickSelect(int[] array, int left, int right, int idxToFind) {
        if (left < right) {
            int partitionIdx = partition(array, left, right);
            if (partitionIdx == idxToFind) {
                return array[partitionIdx];
            } else if (idxToFind < partitionIdx) {
                return quickSelect(array, left, partitionIdx - 1, idxToFind);
            } else {
                return quickSelect(array, partitionIdx + 1, right, idxToFind);
            }
        }
        return -1;
    }

    private int partition(int[] array, int left, int right) {
        int pivotIdx = right;
        int i = left;
        for (int j = i; j < right; j++) {
            if (array[j] < array[pivotIdx]) {
                swap(array, i, j);
                i++;
            }
        }
        swap(array, i, right);
        return i;
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
