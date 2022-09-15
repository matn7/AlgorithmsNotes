package udemy.bigonotation;

public class InsertionSort {

    // O(n^2) time | O(1) space
    // A stable sort
    // O(n^2) comparisons
    // O(n^2) swaps
    // An adaptive
    public static void insertionSort(int[] listToSort) {
        for (int i = 0; i < listToSort.length - 1; i++) { // go up to the second to last element
            for (int j = i + 1; j > 0; j--) {
                if (listToSort[j] < listToSort[j - 1]) {
                    swap(listToSort, j, j - 1);
                } else {
                    break;
                }
                print(listToSort);
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
