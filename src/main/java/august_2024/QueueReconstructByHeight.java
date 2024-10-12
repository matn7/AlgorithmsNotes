package august_2024;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QueueReconstructByHeight {

    public static void main(String[] args) {
        List<List<Integer>> input = new ArrayList<>();
        input.add(new ArrayList<>(Arrays.asList(7, 0)));
        input.add(new ArrayList<>(Arrays.asList(4, 4)));
        input.add(new ArrayList<>(Arrays.asList(7, 1)));
        input.add(new ArrayList<>(Arrays.asList(5, 2)));
        input.add(new ArrayList<>(Arrays.asList(5, 0)));
        input.add(new ArrayList<>(Arrays.asList(6, 1)));

        reconstructQueue(input);
    }

    // O(nlog(n)) time | O(n) space
    public static List<List<Integer>> reconstructQueue(List<List<Integer>> input) {
        List<List<Integer>> result = new ArrayList<>();

        input.sort((a, b) -> {
            if (a.get(0).equals(b.get(0))) {
                return a.get(1).compareTo(b.get(1));
            }
            return b.get(0).compareTo(a.get(0));
        });

        for (List<Integer> element : input) {
            result.add(element.get(1), element);
        }

        return result;
    }

}
