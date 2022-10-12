package udemy.faang;

public class GetKthLargest {

    public static void main(String[] args) {
        int[] array = {5, 3, 1, 6, 4, 2};
        GetKthLargest getKthLargest = new GetKthLargest();
        getKthLargest.getKthLargest(array, 2);
    }

    // O(nlog(n)) time | O(log(n)) space
    public int getKthLargest(int[] array, int k) {
        int indexToFind = array.length - k;
        quickSort(array, 0, array.length - 1);
        return array[indexToFind];
    }

    private void quickSort(int[] array, int left, int right) {
        if (left < right) {
            int partitionIdx = partition(array, left, right);
            quickSort(array, left, partitionIdx - 1);
            quickSort(array, partitionIdx + 1, right);
        }
    }

    private int partition(int[] array, int left, int right) {
        int pivot = array[right];
        int partitionIdx = left;
        for (int j = left; j < right; j++) {
            if (array[j] < pivot) {
                swap(array, partitionIdx, j);
                partitionIdx++;
            }
        }
        swap(array, partitionIdx, right);
        return partitionIdx;
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
