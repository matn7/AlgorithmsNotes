package whiteboard;

public class InsertionSortRand {

    public static void main(String[] args) {
        int[] array = {8, 5, 2, 9, 5, 6, 3};

        insertionSort(array);
    }

    public static int[] insertionSort(int[] array) {
        // Write your code here.
        if (array.length <= 1) {
            return array;
        }
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (array[j] < array[j - 1]) {
                    swap(array, j , j - 1);
                } else {
                    break;
                }
            }
        }
        return array;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
