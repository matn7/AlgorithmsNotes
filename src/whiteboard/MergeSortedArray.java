package whiteboard;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MergeSortedArray {

    // O(nlog(k) + k) time | O(n + k) space
    // n - total number of array elements
    // k - number of arrays
    public static List<Integer> mergeSortedArrays(List<List<Integer>> arrays) {
        // Write your code here.
        List<Integer> result = new ArrayList<>();
        PriorityQueue<Element> queue = new PriorityQueue<>();

        for (int idx = 0; idx < arrays.size(); idx++) {
            Integer currentValue = arrays.get(idx).remove(0);
            queue.add(new Element(currentValue, idx));
        }

        while (!queue.isEmpty()) {
            Element currentElement = queue.poll();
            int currentIdx = currentElement.idx;

            if (!arrays.get(currentIdx).isEmpty()) {
                Integer newElement = arrays.get(currentIdx).remove(0);
                queue.add(new Element(newElement, currentIdx));
            }
            result.add(currentElement.value);
        }

        return result;
    }

    static class Element implements Comparable<Element> {
        int value;
        int idx;

        public Element(int value, int idx) {
            this.value = value;
            this.idx = idx;
        }

        @Override
        public int compareTo(Element o) {
            return o.value - this.value;
        }
    }

}
