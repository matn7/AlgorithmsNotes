package hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HeapSort {

    public static void main(String[] args) {
        int[] array = {8, 5, 2, 9, 5, 6, 3};
        heapSort(array);
    }

    public static int[] heapSort(int[] array) {
        // Write your code here.
        List<Integer> sorted = new ArrayList<>();
        List<Integer> listArray = new ArrayList<>();
        for (int element : array) {
            listArray.add(element);
        }

        while (!listArray.isEmpty()) {
            heapify(listArray, sorted);
        }

        int[] result = new int[sorted.size()];

        for (int i = 0; i < sorted.size(); i++) {
            result[i] = sorted.get(i);
        }

        return result;
    }

    private static void heapify(List<Integer> listArray, List<Integer> sorted) {
        for (int i = listArray.size() - 1; i >= 0; i--) {
            siftUp(i, listArray);
        }
        sorted.add(listArray.remove(0));
        System.out.println();
    }

    private static void siftUp(int currentIndex, List<Integer> listArray) {
        int parentIndex = parentIndex(currentIndex);

        if (listArray.get(currentIndex) < listArray.get(parentIndex)) {
            swap(listArray, currentIndex, parentIndex);
            siftUp(parentIndex, listArray);
        }
    }

    private static void swap(List<Integer> listArray, int i, int j) {
        int temp = listArray.get(i);
        listArray.set(i, listArray.get(j));
        listArray.set(j, temp);
    }

    private static int parentIndex(int index) {
        return (index - 1) / 2;
    }

}
