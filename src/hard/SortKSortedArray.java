package hard;

import java.util.*;

public class SortKSortedArray {

    public static void main(String[] args) {

        SortKSortedArray sort = new SortKSortedArray();
//        int[] array = {3, 2, 1, 5, 4, 7, 6, 5};
        int[] array2 = {-1, -3, -4, 2, 1, 3};

        sort.sortKSortedArray(array2, 2);

    }

    public int[] sortKSortedArray(int[] array, int k) {
        if (k == 0 || array.length == 0) {
            return array; // list already sorted
        }
        if (k > array.length) {
            k = array.length;
        }
        // Write your code here.
        List<List<Integer>> lists = populateArrays(array, k);
        int allElements = array.length;

        PriorityQueue<Element> minHeap = new PriorityQueue<>();

        // populate with first element from each list
        for (int i = 0; i < k; i++) {
            minHeap.add(new Element(lists.get(i).remove(0), i));
        }

        int[] sorted = new int[array.length];
        int counter = 0;
        while (counter < allElements) {
            Element currentMinElement = minHeap.poll();
            sorted[counter] = currentMinElement.getValue();
            int arrayIdentifier = currentMinElement.getArrayIdentifier(); // 0: A, 1: B, 2: C
            if (!lists.get(arrayIdentifier).isEmpty()) {
                minHeap.add(new Element(lists.get(arrayIdentifier).remove(0), arrayIdentifier));
            }
            counter++;
        }

        return sorted;
    }

    private List<List<Integer>> populateArrays(int[] array, int k) {
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            lists.add(i, new ArrayList<>());
        }
        int counter = 0;
        for (int i = 0; i < array.length; i++) {
            lists.get(counter).add(array[i]);
            counter++;
            if (counter % k == 0) {
                counter = 0;
            }
        }
        for (int i = 0; i < lists.size(); i++) {
            Collections.sort(lists.get(i));
        }
        return lists;
    }

    private static class Element implements Comparable<Element> {
        private int value;
        private int arrayIdentifier;

        public Element(int value, int arrayIdentifier) {
            this.value = value;
            this.arrayIdentifier = arrayIdentifier;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public int getArrayIdentifier() {
            return arrayIdentifier;
        }

        public void setArrayIdentifier(int arrayIdentifier) {
            this.arrayIdentifier = arrayIdentifier;
        }

        @Override
        public int compareTo(Element element) {
            return value - element.value;
        }
    }

}
