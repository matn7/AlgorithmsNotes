package coderpro;

import java.util.*;

public class QueueReconstructionByHeight {

    public static void main(String[] args) {
        // input = [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
        List<List<Integer>> input = new ArrayList<>();
        input.add(new ArrayList<>(Arrays.asList(7, 0)));
        input.add(new ArrayList<>(Arrays.asList(4, 4)));
        input.add(new ArrayList<>(Arrays.asList(7, 1)));
        input.add(new ArrayList<>(Arrays.asList(5, 2)));
        input.add(new ArrayList<>(Arrays.asList(5, 0)));
        input.add(new ArrayList<>(Arrays.asList(6, 1)));

        QueueReconstructionByHeight queueReconstructionByHeight = new QueueReconstructionByHeight();
        List<List<Integer>> result = queueReconstructionByHeight.reconstructQueue(input);

        for (List<Integer> person : result) {
            System.out.print(person + ", ");
        }


    }

    // O(nlog(n)) time | O(log(n)) space
    public List<List<Integer>> reconstructQueue(List<List<Integer>> input) {

//        input.sort((a, b) -> b.get(0) - a.get(0));

        input.sort((p1, p2) -> {
            if (p2.get(0) - p1.get(0) == 0) {
                return p1.get(1).compareTo(p2.get(1));
            } else {
                return p2.get(0).compareTo(p1.get(0));
            }
        });

        // [[7, 0], [7, 1], [6, 1], [5, 0], [5, 2], [4, 4]]
        List<List<Integer>> res = new ArrayList<>();
        for (List<Integer> person : input) {
            res.add(person.get(1), person);
        }

        return res;
    }

}
