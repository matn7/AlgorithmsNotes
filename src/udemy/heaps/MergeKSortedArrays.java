package udemy.heaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeKSortedArrays {

    public static void main(String[] args) throws Heap.HeapFullException, Heap.HeapEmptyException {
        List<Integer> A = new ArrayList<>();
        List<Integer> B = new ArrayList<>();
        List<Integer> C = new ArrayList<>();
        int[] a = {5, 6, 7, 9, 10};
        int[] b = {2, 3, 13, 15, 17, 20};
        int[] c = {1, 8};
        for (int elem : a) {
            A.add(elem);
        }
        for (int elem : b) {
            B.add(elem);
        }
        for (int elem : c) {
            C.add(elem);
        }

        mergeKSortedArrays(A, B, C);
    }

    public static void mergeKSortedLists(int totalElements, List<Integer>... lists) throws Heap.HeapFullException, Heap.HeapEmptyException {
        MinHeap<Element> minHeap = new MinHeap<>(Element.class, lists.length);

        List<Integer> sortedList = new ArrayList<>();
        for (int i = 0; i < lists.length; i++) {
            List<Integer> list = lists[i];
            if (!list.isEmpty()) {
                minHeap.insert(new Element(list.remove(0), i));
            }
        }

        while (sortedList.size() < totalElements) {
            Element element = minHeap.removeHighestPriority();
            sortedList.add(element.getValue());

            List<Integer> list = lists[element.getId()];
            if (!list.isEmpty()) {
                minHeap.insert(new Element(list.remove(0), element.getId()));
            }
        }
    }

    // O(nlog(k) + k) time | O(n + k) space
    public static List<Integer> mergeKSortedArrays(List<Integer>... lists) throws Heap.HeapFullException, Heap.HeapEmptyException {
        List<Integer> result = new ArrayList<>();
        int k = lists.length;
        MinHeap<Element> heap = new MinHeap<>(Element.class, k);

        List<List<Integer>> listsArray = new ArrayList<>();
        listsArray.addAll(Arrays.asList(lists));

        for (int i = 0; i < listsArray.size(); i++) {
            heap.insert(new Element(listsArray.get(i).remove(0), i));
        }

        while (!heap.isEmpty()) {
            Element top = heap.removeHighestPriority();
            result.add(top.value);
            int id = top.id;
            if (!listsArray.get(id).isEmpty()) {
                heap.insert(new Element(listsArray.get(id).remove(0), id));
            }
        }

        return result;

    }

    static class Element implements Comparable<Element> {
        private int value;
        private int id;

        public int getValue() {
            return value;
        }

        public int getId() {
            return id;
        }

        public Element(int value, int id) {
            this.value = value;
            this.id = id;
        }

        @Override
        public int compareTo(Element o) {
            return this.value - o.value;
        }
    }

}
