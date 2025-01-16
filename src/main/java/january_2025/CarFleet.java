package january_2025;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class CarFleet {

    public static void main(String[] args) {
//        int target = 12;
//        int[] position = {10, 8, 0, 5, 3};
//        int[] speed = {2, 4, 1, 1, 3};

        int target = 10;
        int[] position = {6, 8};
        int[] speed = {3, 2};

        CarFleet carFleet = new CarFleet();
        int result = carFleet.carFleet(target, position, speed);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] cars = new int[position.length][2];
        for (int i = 0; i < position.length; i++) {
            cars[i] = new int[] {position[i], speed[i]};
        }
        Arrays.sort(cars, Comparator.comparingInt(c -> c[0]));
        Stack<Double> stack = new Stack<>();
        for (int i = cars.length - 1; i >= 0; i--) {
            int[] car = cars[i];
            int pos = car[0];
            int spd = car[1];
            double time = 1.0 * (target - pos) / spd;
            if (stack.isEmpty()) {
                stack.push(time);
            } else {
                double top = stack.peek();
                if (time > top) {
                    stack.push(time);
                }
            }
        }
        return stack.size();
    }

}
