package udemy.bigonotation;

public class BubbleSort {

    // O(n^2) time | O(1) space
    // A stable sort
    // O(n^2) comparisons
    // O(n^2) swaps
    // An adaptive
    public static void bubbleSort(int[] listToSort) {
        for (int i = 0; i < listToSort.length; i++) {
            boolean swapped = false;
            for (int j = listToSort.length - 1; j > i; j--) {
                if (listToSort[j] < listToSort[j - 1]) {
                    swap(listToSort, j, j - 1);
                    swapped = true;
                }
            }
            print(listToSort);
            if (!swapped) {
                break;
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
