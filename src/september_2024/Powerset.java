package september_2024;

import java.util.ArrayList;
import java.util.List;

public class Powerset {

    public static void main(String[] args) {
        List<Integer> input = new ArrayList<>();
        input.add(1);
        input.add(2);
        input.add(3);

        List<List<Integer>> powersets = powersets(input);
        System.out.println(powersets);
    }

    // O(2^n) time | O(2^n) space
    public static List<List<Integer>> powersets(List<Integer> input) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());

        for (int i = 0; i < input.size(); i++) {
            int size = result.size();
            for (int j = 0; j < size; j++) {
                List<Integer> integers = new ArrayList<>(result.get(j));
                integers.add(input.get(i));
                result.add(integers);
            }
        }

        return result;

    }

}
