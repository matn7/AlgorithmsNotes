package march_2025;

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

    // O(nlog(n)) time | O(n) space
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] cars = new int[position.length][2];
        for (int i = 0; i < position.length; i++) {
            cars[i] = new int[] {position[i], speed[i]};
        }

        Arrays.sort(cars, (a, b) -> (a[0] - b[0]));

        Stack<Double> fleet = new Stack<>();

        for (int i = cars.length - 1; i >= 0; i--) {
            int[] car = cars[i];
            double time = 1.0 * (target - car[0]) / car[1];
            if (fleet.isEmpty() || fleet.peek() < time) {
                fleet.push(time);
            }
        }

        return fleet.size();
    }

}
