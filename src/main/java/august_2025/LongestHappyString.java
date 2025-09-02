package august_2025;

import java.util.PriorityQueue;

public class LongestHappyString {

    // O(n) time | O(1) space
    public String longestDiverseString(int a, int b, int c) {
        StringBuilder res = new StringBuilder();
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((x, y) -> y[0] - x[0]);
        if (a != 0) {
            maxHeap.add(new int[] {a, 'a'});
        }
        if (b != 0) {
            maxHeap.add(new int[] {b, 'b'});
        }
        if (c != 0) {
            maxHeap.add(new int[] {c, 'c'});
        }

        while (!maxHeap.isEmpty()) {
            int[] current = maxHeap.poll();
            int count = current[0];
            char ch = (char) current[1];
            if (res.length() > 1 && (res.charAt(res.length() - 1) == ch && res.charAt(res.length() - 2) == ch)) {
                if (maxHeap.isEmpty()) {
                    break;
                }
                int[] current2 = maxHeap.poll();
                int count2 = current2[0];
                char ch2 = (char) current2[1];
                res.append(ch2);
                count2--;
                if (count2 > 0) {
                    maxHeap.add(new int[] {count2, ch2});
                }
            } else {
                res.append(ch);
                count--;
            }
            if (count > 0) {
                maxHeap.add(new int[] {count, ch});
            }
        }
        return res.toString();
    }


}
