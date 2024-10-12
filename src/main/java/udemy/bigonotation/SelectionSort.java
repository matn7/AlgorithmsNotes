package udemy.bigonotation;

public class SelectionSort {

    // O(n^2) time | O(1) space
    // Not a stable sort
    // O(n^2) comparisons
    // O(n) swaps
    // Not an adaptive
    public static void selectionSort(int[] listToSort) {
        for (int i = 0; i < listToSort.length; i++) {
            for (int j = i + 1; j < listToSort.length; j++) {
                if (listToSort[i] > listToSort[j]) {
                    swap(listToSort, i, j);
                    print(listToSort);
                }
            }
        }
    }

    public static void print(int[] listToSort) {
        for (int element : listToSort) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public static void swap(int[] listToSort, int iIndex, int jIndex) {
        int temp = listToSort[iIndex];
        listToSort[iIndex] = listToSort[jIndex];
        listToSort[jIndex] = temp;
    }

}
