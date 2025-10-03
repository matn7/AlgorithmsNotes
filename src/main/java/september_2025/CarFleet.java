package september_2025;

import java.util.ArrayDeque;
import java.util.Arrays;

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
        int[][] input = new int[position.length][2];
        for (int i = 0; i < position.length; i++) {
            input[i] = new int[] {position[i], speed[i]};
        }

        Arrays.sort(input, (a, b) -> a[0] - b[0]);

        ArrayDeque<Double> stack = new ArrayDeque<>();

        for (int i = position.length - 1; i >= 0; i--) {
            int[] element = input[i];
            double time = (double) (target - element[0]) / element[1];
            if (stack.isEmpty() || time > stack.getFirst()) {
                stack.addFirst(time);
            }
        }
        return stack.size();
    }


}
