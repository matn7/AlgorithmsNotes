package whiteboard;

import java.util.HashMap;
import java.util.Map;

public class HasPairWithSum {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 9};
        int[] arr2 = {1, 2, 4, 4};

        HasPairWithSum hasPairWithSum = new HasPairWithSum();
        hasPairWithSum.hasPairWithSum(arr2, 8);
    }

    public boolean hasPairWithSum(int[] array, int sum) {
        Map<Integer, Boolean> comp = new HashMap<>();
        for (int value : array) {
            if (comp.containsKey(value)) {
                return true;
            }
            comp.put(sum - value, Boolean.TRUE);
        }
        return false;
    }

}
