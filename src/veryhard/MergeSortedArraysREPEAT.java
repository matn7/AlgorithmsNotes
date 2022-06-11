package veryhard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class MergeSortedArraysREPEAT {
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
        // Write your code here.
        List<Integer> sortedList = new ArrayList<>();
        int[] elementIdxs = new int[arrays.size()];
        while (true) {
            List<Element> smallestItems = new ArrayList<>();
            for (int arrayIdx = 0; arrayIdx < arrays.size(); arrayIdx++) { // O(k)
                List<Integer> relevantArray = arrays.get(arrayIdx);
                int elementIdx = elementIdxs[arrayIdx];
                if (elementIdx == relevantArray.size()) {
                    continue;
                }
                smallestItems.add(new Element(arrayIdx, relevantArray.get(elementIdx)));
            }
            if (smallestItems.size() == 0) {
                break;
            }
            Element nextItem = getMinValue(smallestItems);
            sortedList.add(nextItem.number);
            elementIdxs[nextItem.arrayIdx] += 1;
        }
        return sortedList;
    }

    private static Element getMinValue(List<Element> items) {
        int minValueIdx = 0;
        for (int i = 1; i < items.size(); i++) {
            if (items.get(i).number < items.get(minValueIdx).number) {
                minValueIdx = i;
            }
        }
        return items.get(minValueIdx);
    }

    // O(nlog(k) + k) time (k to build minHeap) | O(n+k) space
    public static List<Integer> mergeSortedArrays(List<List<Integer>> arrays) {
        List<Integer> sortedList = new ArrayList<>();
        PriorityQueue<Element> minHeap = new PriorityQueue<>();
        // minHeap with k smallest items from list
        for (int arrayIdx = 0; arrayIdx < arrays.size(); arrayIdx++) {
            minHeap.add(new Element(arrayIdx, arrays.get(arrayIdx).remove(0)));
        }
        while (!minHeap.isEmpty()) {
            Element smallestItem = minHeap.poll();
            int arrayIdx = smallestItem.arrayIdx;
            int num = smallestItem.number;
            sortedList.add(num);
            if (!arrays.get(arrayIdx).isEmpty()) {
                minHeap.add(new Element(arrayIdx, arrays.get(arrayIdx).remove(0)));
            }
        }
        return sortedList;
    }

    static class Element implements Comparable<Element> {
        int arrayIdx;
        int number;

        public Element(int arrayIdx, int number) {
            this.arrayIdx = arrayIdx;
            this.number = number;
        }

        @Override
        public int compareTo(Element o) {
            return number - o.number;
        }
    }

}
