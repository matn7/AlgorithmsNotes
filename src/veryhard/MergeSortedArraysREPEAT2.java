package veryhard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class MergeSortedArraysREPEAT2 {

    public static void main(String[] args) {
        List<List<Integer>> arrays = new ArrayList<>();
        arrays.add(Arrays.asList(1, 5, 9, 21));
        arrays.add(Arrays.asList(-1, 0));
        arrays.add(Arrays.asList(-124, 81, 121));
        arrays.add(Arrays.asList(3, 6, 12, 20, 150));

        List<Integer> integers = mergeSortedArrays(arrays);

        System.out.println();
    }
    // OK - repeated 19/02/2022
    // O(nlog(k) + k) time | O(n + k) space
    public static List<Integer> mergeSortedArrays(List<List<Integer>> arrays) {
        // [                            arrayIdx
        //    [   1,  5,   9, 21],          0
        //    [  -1,  0],                   1
        //    [-123, 81, 121],              2
        //    [   3,  6,  12, 20, 150]      3       *
        //  ]     *

        List<Integer> sortedList = new ArrayList<>();
        PriorityQueue<Element> minHeap = new PriorityQueue<>();

        for (int arrayIdx = 0; arrayIdx < arrays.size(); arrayIdx++) {
            minHeap.add(new Element(arrayIdx, 0, arrays.get(arrayIdx).get(0)));
        }

        // [                            arrayIdx
        //    [   1*,  5*,   9*, 21*],          0
        //    [  -1*,  0*],                   1      *
        //    [-123*, 81*, 121*],              2
        //    [   3*,  6*,  12*, 20*, 150*]      3
        //  ]     *

        // minHeap =
        //
        //
        //

        while (!minHeap.isEmpty()) {
            Element smallestValue = minHeap.poll(); //  (3, 4, 150)
            int arrayIdx = smallestValue.arrayIdx; // 3
            int elementIdx = smallestValue.elementIdx; // 4
            int num = smallestValue.num; // 150
            sortedList.add(num);
            if (elementIdx == arrays.get(arrayIdx).size() - 1) { // 4 == 4
                continue;
            }
            //
            minHeap.add(new Element(arrayIdx, elementIdx + 1, arrays.get(arrayIdx).get(elementIdx + 1)));
        }
        return sortedList; // [-123, -1, 0, 1, 3, 5, 6, 9, 12, 20, 21, 81, 121, 150]
    }

    static class Element implements Comparable<Element> {
        int arrayIdx;
        int elementIdx;
        int num;

        public Element(int arrayIdx, int elementIdx, int num) {
            this.arrayIdx = arrayIdx;
            this.elementIdx = elementIdx;
            this.num = num;
        }

        @Override
        public int compareTo(Element o) {
            return num - o.num;
        }
    }

//    // O(nk) time | O(n + k) space
//    public static List<Integer> mergeSortedArrays(List<List<Integer>> arrays) {
//        List<Integer> sortedList = new ArrayList<>();
//        int[] elementIdxs = new int[arrays.size()]; // k
//        while (true) {
//            List<Element> smallestItems = new ArrayList<>();
//            for (int arrayIdx = 0; arrayIdx < arrays.size(); arrayIdx++) {
//                List<Integer> relevantArray = arrays.get(arrayIdx);
//                int elementIdx = elementIdxs[arrayIdx];
//                if (elementIdx == relevantArray.size()) {
//                    continue;
//                }
//                smallestItems.add(new Element(arrayIdx, relevantArray.get(elementIdx)));
//            }
//            if (smallestItems.isEmpty()) {
//                break;
//            }
//            Element nextItem = getMinValue(smallestItems);
//            sortedList.add(nextItem.num);
//            elementIdxs[nextItem.arrayIdx] += 1;
//        }
//        return sortedList;
//    }
//
//    private static Element getMinValue(List<Element> items) {
//        int minValueIdx = 0;
//        for (int i = 1; i < items.size(); i++) {
//            if (items.get(i).num < items.get(minValueIdx).num) {
//                minValueIdx = i;
//            }
//        }
//        return items.get(minValueIdx);
//    }
//
//    static class Element {
//        int arrayIdx;
//        int num;
//
//        public Element(int arrayIdx, int num) {
//            this.arrayIdx = arrayIdx;
//            this.num = num;
//        }
//    }

}
