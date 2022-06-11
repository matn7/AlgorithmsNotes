package veryhard;

import java.util.*;

public class MergeSortedArrays {
    public static void main(String[] args) {
        List<List<Integer>> arrays = new ArrayList<>();

        arrays.add(0, new ArrayList<>());
        arrays.add(1, new ArrayList<>());
        arrays.add(2, new ArrayList<>());
        arrays.add(3, new ArrayList<>());

        arrays.get(0).addAll(Arrays.asList(1, 5, 9, 21));
        arrays.get(1).addAll(Arrays.asList(-1, 0));
        arrays.get(2).addAll(Arrays.asList(-124, 81, 121));
        arrays.get(3).addAll(Arrays.asList(3, 6, 12, 20, 150));

        List<Integer> integers = mergeSortedArrays(arrays);

        System.out.println();

    }

    // O(nk) time | O(n+k) space
    public static List<Integer> mergeSortedArrays2(List<List<Integer>> arrays) {
        return null;
    }

    // O(nlog(k) + k) time (k to build minHeap) | O(n+k) space
    public static List<Integer> mergeSortedArrays(List<List<Integer>> arrays) {
        if (arrays.size() == 0) {
            return null; // list already sorted
        }

        int allElements = 0;
        for (int i = 0; i < arrays.size(); i++) {
            allElements += arrays.get(i).size();
        }

        PriorityQueue<Element> minHeap = new PriorityQueue<>();

        // populate with first element from each list
        for (int i = 0; i < arrays.size(); i++) {
            minHeap.add(new Element(arrays.get(i).remove(0), i));
        }

        List<Integer> sorted = new ArrayList<>();
        int counter = 0;
        while (counter < allElements) {
            Element currentMinElement = minHeap.poll();
            sorted.add(currentMinElement.getValue());
            int arrayIdentifier = currentMinElement.getArrayIdentifier(); // 0: A, 1: B, 2: C
            if (!arrays.get(arrayIdentifier).isEmpty()) {
                minHeap.add(new Element(arrays.get(arrayIdentifier).remove(0), arrayIdentifier));
            }
            counter++;
        }

        return sorted;
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
