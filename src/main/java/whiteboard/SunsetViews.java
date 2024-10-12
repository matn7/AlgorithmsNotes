package whiteboard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class SunsetViews {

    public static void main(String[] args) {
        int[] buildings = {3, 5, 4, 4, 3, 1, 3, 2};
        String direction = "EAST";

        SunsetViews sunsetViews = new SunsetViews();
        sunsetViews.sunsetViews(buildings, direction);
    }

    // O(n) time | O(n) space
    // #2: 13/07/2022
    public ArrayList<Integer> sunsetViews(int[] buildings, String direction) {
        // Write your code here.
        Stack<Integer> stack = new Stack<>();

        if (direction.equals("EAST")) {
            for (int i = buildings.length - 1; i >= 0; i--) {
                int curr = buildings[i];
                if (stack.isEmpty()) {
                    stack.push(i);
                    continue;
                }
                Integer top = buildings[stack.peek()];
                if (curr > top) {
                    stack.push(i);
                }
            }
        } else {
            for (int i = 0; i < buildings.length; i++) {
                int curr = buildings[i];
                if (stack.isEmpty()) {
                    stack.push(i);
                    continue;
                }
                Integer top = buildings[stack.peek()];
                if (curr > top) {
                    stack.push(i);
                }
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }
        if (!direction.equals("EAST")) {
            Collections.reverse(result);
        }

        return result;
    }

}
