package october_2023;

import java.util.*;

public class MergeSortedArray {

    public static void main(String[] args) {
        List<Integer> first = Arrays.asList(1, 5, 9, 21);
        List<Integer> second = Arrays.asList(-1, 0);
        List<Integer> third = Arrays.asList(-124, 81, 121);
        List<Integer> fourth = Arrays.asList(3, 6, 12, 20, 150);

        List<List<Integer>> arrays = new ArrayList<>();
        arrays.add(first);
        arrays.add(second);
        arrays.add(third);
        arrays.add(fourth);

        mergeSortedArray(arrays);
    }

    // O(nlog(k)) time | O(n + k) space
    public static List<Integer> mergeSortedArray(List<List<Integer>> arrays) {
        List<Integer> result = new ArrayList<>();

        PriorityQueue<ElementInfo> queue = new PriorityQueue<>();
        for (int i = 0; i < arrays.size(); i++) {
            queue.add(new ElementInfo(i, 1, arrays.get(i).get(0)));
        }

        while (!queue.isEmpty()) {
            ElementInfo topElement = queue.poll();
            int idx = topElement.idx;
            int elemPosition = topElement.elemPosition;
            int value = topElement.value;
            result.add(value);
            if (arrays.get(idx).size() > elemPosition) {
                int newPosition = elemPosition + 1;
                queue.add(new ElementInfo(idx, newPosition, arrays.get(idx).get(elemPosition)));
            }
        }


        return result;
    }

    static class ElementInfo implements Comparable<ElementInfo> {
        int idx;
        int elemPosition;
        int value;

        public ElementInfo(int idx, int elemPosition, int value) {
            this.idx = idx;
            this.elemPosition = elemPosition;
            this.value = value;
        }

        @Override
        public int compareTo(ElementInfo o) {
            return this.value - o.value;
        }
    }

}
