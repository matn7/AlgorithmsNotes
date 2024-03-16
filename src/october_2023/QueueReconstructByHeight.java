package october_2023;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class QueueReconstructByHeight {

    public static void main(String[] args) {
        List<List<Integer>> queue = new ArrayList<>();
        queue.add(Arrays.asList(7, 0));
        queue.add(Arrays.asList(4, 4));
        queue.add(Arrays.asList(7, 1));
        queue.add(Arrays.asList(5, 2));
        queue.add(Arrays.asList(5, 0));
        queue.add(Arrays.asList(6, 1));

        queueByHeight(queue);
    }

    // O(nlog(n)) time | O(log(n)) space
    public static List<List<Integer>>queueByHeight(List<List<Integer>> queue) {
        List<List<Integer>> result = new ArrayList<>();

        queue.sort((o1, o2) -> {
            if (o2.get(0) - o1.get(0) == 0) { // [7, 0], [7, 1]
                return o1.get(1).compareTo(o2.get(1));
            }
            return o2.get(0).compareTo(o1.get(0));
        });

        for (List<Integer> q : queue) {
            int idx = q.get(1);
            result.add(idx, q);
        }

        return result;
    }

}
