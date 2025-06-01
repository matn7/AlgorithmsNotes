package may_2025;

import java.util.Arrays;
import java.util.Stack;

public class CarFleet {

    public static void main(String[] args) {
        int target = 12;
        int[] position = {10, 8, 0, 5, 3};
        int[] speed = {2, 4, 1, 1, 3};

        CarFleet carFleet = new CarFleet();
        int result = carFleet.carFleet(target, position, speed);
        System.out.println(result);
    }

    // O(n log(n))) time | O(n) space
    public int carFleet(int target, int[] position, int[] speed) {
        if (position.length == 0) {
            return 0;
        }
        int[][] car = new int[position.length][2];
        for (int i = 0; i < position.length; i++) {
            car[i] = new int[] {position[i], speed[i]};
        }

        Arrays.sort(car, (a, b) -> a[0] - b[0]);

        Stack<Double> stack = new Stack<>();
        double t = (double) (target - car[car.length - 1][0]) / car[car.length - 1][1];
        stack.push(t);

        for (int i = car.length - 2; i >= 0; i--) {
            t = (double) (target - car[i][0]) / car[i][1];
            if (t > stack.peek()) {
                stack.push(t);
            }
        }

        return stack.size();
    }

}
