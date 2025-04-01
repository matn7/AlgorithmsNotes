package january_2025;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class CarFleet2 {

    public static void main(String[] args) {
//        int target = 12;
//        int[] position = {10, 8, 0, 5, 3};
//        int[] speed = {2, 4, 1, 1, 3};

        int target = 10;
        int[] position = {6, 8};
        int[] speed = {3, 2};

        CarFleet2 carFleet2 = new CarFleet2();
        int result = carFleet2.carFleet(target, position, speed);
        System.out.println(result);
    }

    // O(nlog(n)) time | O(n) space
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] cars = new int[position.length][2];
        for (int i = 0; i < position.length; i++) {
            cars[i] = new int[] {position[i], speed[i]};
        }
        Arrays.sort(cars, (a,b) -> Integer.compare(b[0], a[0]));
        int fleet = 1;
        double prevTime = (double) (target - cars[0][0]) / cars[0][1];
        for (int i = 1; i < cars.length; i++) {
            int[] car = cars[i];
            double curTime = (double) (target - car[0]) / car[1];
            if (prevTime < curTime) {
                fleet++;
                prevTime = curTime;
            }
        }

        return fleet;
    }

}
