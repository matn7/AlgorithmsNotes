package july_2024;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QueueReconstructByHeight {

    public static void main(String[] args) {
        List<List<Integer>> input = new ArrayList<>();
        input.add(Arrays.asList(7, 0));
        input.add(Arrays.asList(4, 4));
        input.add(Arrays.asList(7, 1));
        input.add(Arrays.asList(5, 2));
        input.add(Arrays.asList(5, 0));
        input.add(Arrays.asList(6, 1));

        List<List<Integer>> result = reconstructQueue(input);
        System.out.println(result);
    }

    // O(nlog(n)) time | O(log(n)) space
    public static List<List<Integer>> reconstructQueue(List<List<Integer>> input) {
        input.sort((p1, p2) -> {
            if (p2.get(0) - p1.get(0) == 0) {
                return p1.get(1).compareTo(p2.get(1));
            } else {
                return p2.get(0).compareTo(p1.get(0));
            }
        });
        List<List<Integer>> result = new ArrayList<>();
        for (List<Integer> person : input) {
            result.add(person.get(1), person);
        }
        return result;
    }

}
