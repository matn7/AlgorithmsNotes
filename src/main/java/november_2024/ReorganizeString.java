package november_2024;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ReorganizeString {

    public static void main(String[] args) {
        String s = "aaab";
//        String s = "aabbcca";

        ReorganizeString reorganizeString = new ReorganizeString();

        String result = reorganizeString.reorganizeString(s);
        System.out.println(result);
    }

    // ********
    // * STAR *
    // ********

    public String reorganizeString(String s) {
        Map<Character, Integer> counts = new HashMap<>();
        for (char c : s.toCharArray()) {
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Element> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for (Map.Entry<Character, Integer> element : counts.entrySet()) {
            queue.add(new Element(element.getKey(), element.getValue()));
        }

        StringBuilder builder = new StringBuilder();
        Element prev = null;
        // keep track of prev chars if the same as curr then return ""
        while (!queue.isEmpty() || prev != null) {
            if (prev != null && queue.isEmpty()) {
                return "";
            }
            Element poll = queue.poll();

            builder.append(poll.character);
            poll.frequency--;

            if (prev != null) {
                queue.add(prev);
                prev = null;
            }

            if (poll.frequency != 0) {
                prev = poll;
            }
        }

        return builder.toString();

    }

    static class Element implements Comparable<Element> {
        char character;
        int frequency;

        public Element(char character, int frequency) {
            this.character = character;
            this.frequency = frequency;
        }

        @Override
        public int compareTo(Element o) {
            return frequency - o.frequency;
        }
    }

}
