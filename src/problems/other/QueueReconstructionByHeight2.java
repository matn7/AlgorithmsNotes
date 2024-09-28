package problems.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QueueReconstructionByHeight2 {

    public static void main(String[] args) {
        List<List<Integer>> input = new ArrayList<>();
        input.add(new ArrayList<>(Arrays.asList(7, 0)));
        input.add(new ArrayList<>(Arrays.asList(4, 4)));
        input.add(new ArrayList<>(Arrays.asList(7, 1)));
        input.add(new ArrayList<>(Arrays.asList(5, 2)));
        input.add(new ArrayList<>(Arrays.asList(5, 0)));
        input.add(new ArrayList<>(Arrays.asList(6, 1)));

        QueueReconstructionByHeight2 queueReconstructionByHeight2 = new QueueReconstructionByHeight2();
        queueReconstructionByHeight2.reconstructQueue(input);

    }

    // O(nlog(n)) time | O(log(n)) space
    public List<List<Integer>> reconstructQueue(List<List<Integer>> input ) {
        // [[5,0], [7,0], [6,1], [7,1], [5,2], [4,4]]
        input.sort((p1, p2) -> {
            if (p2.get(0) - p1.get(0) == 0) {
                return p1.get(1).compareTo(p2.get(1));
            } else {
                return p2.get(0).compareTo(p1.get(0));
            }
        });

        List<List<Integer>> res = new ArrayList<>();
        for (List<Integer> person : input) {
            res.add(person.get(1), person);
        }

        return res;
    }


}
