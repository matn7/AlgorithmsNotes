package star;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Program {

    public static void main(String[] args) {
        List<Integer> array = new ArrayList<>();

        int[] input = {1, 3, 6, 9, 4, 7, 8, 2, 0, 10};
        for (int i : input) {
            array.add(i);
        }
        Set<Integer[]> result = new HashSet<>();

        for (int i = 0; i < Runtime.getRuntime().availableProcessors(); i++) {
            new Thread(new Calculator(result, array)).start();
        }

        System.out.println();
    }

    static class Calculator implements Runnable {

        Set<Integer[]> result;
        List<Integer> array;

        public Calculator(Set<Integer[]> result, List<Integer> array) {
            this.result = result;
            this.array = array;
        }

        @Override
        public void run() {
            for (int i = 0; i < array.size(); i++) {
                for (int j = i + 1; j < array.size(); j++) {
                    if (array.get(i) + array.get(j) == 10) {
                        result.add(new Integer[]{array.get(i), array.get(j)});
                    }
                }
            }
        }
    }

}


