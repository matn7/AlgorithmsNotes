package udemy.bigonotation;

public class QuickSort {

    public static void quickSort(int[] listToSort, int low, int high) {
        if (low >= high) {
            return;
        }
        int pivotIndex = partition(listToSort, low, high);
        quickSort(listToSort, low, pivotIndex - 1);
        quickSort(listToSort, pivotIndex + 1, high);
    }

    // low and high specify indices which determines what partition of the list we're working on
    public static int partition(int[] listToSort, int low, int high) {
        // choose a pivot to partition the list
        int pivot = listToSort[low];
        int l = low;
        int h = high;
        while (l < h) {
            // moving from either end of the list towards the center we compare the elements to the pivot
            // elements larger than the pivot are swapped to after the pivot and smaller elements move before the pivot
            while (listToSort[l] <= pivot && l < h) {
                l++;
            }
            while (listToSort[h] > pivot) {
                h--;
            }
            if (l < h) {
                swap(listToSort, l, h);
            }
        }
        swap(listToSort, low, h);

        System.out.println("Pivot: " + pivot);
        print(listToSort);
        return h;
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
