package october_2023;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class SunsetView {

    public static void main(String[] args) {
        int[] buildings = {3, 5, 4, 4, 3, 1, 3, 2};
        String direction = "WEST";

        sunsetView(buildings, direction);

    }

    // O(n) time | O(n) space
    public static List<Integer> sunsetView(int[] buildings, String direction) {
        List<Integer> result = new ArrayList<>();
        Stack<Integer> idxStack = new Stack<>();
        // WEST                EAST
        // [3, 5, 4, 4, 3, 1, 3, 2]
        //  0  1  2  3  4  5  6  7
        //                 *

        if (direction.equals("EAST")) {
            for (int i = 0; i < buildings.length; i++) {
                int curr = buildings[i];
                while (!idxStack.isEmpty() && buildings[idxStack.peek()] <= curr) {
                    idxStack.pop();
                }
                idxStack.push(i);
            }
        } else {
            for (int i = buildings.length - 1; i >= 0; i--) {
                int curr = buildings[i];
                while (!idxStack.isEmpty() && buildings[idxStack.peek()] <= curr) {
                    idxStack.pop();
                }
                idxStack.push(i);
            }
        }

        while (!idxStack.isEmpty()) {
            result.add(idxStack.pop());
        }


        if (direction.equals("EAST")) {
            Collections.reverse(result);
        }

        return result;
    }

}
