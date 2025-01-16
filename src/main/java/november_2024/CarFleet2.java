package november_2024;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class CarFleet2 {

    public static void main(String[] args) {
//        int target = 12;
//        int[] position = {10,8,0,5,3};
//        int[] speed = {2,4,1,1,3};

//        int target = 10;
//        int[] position = {6, 8};
//        int[] speed = {3, 2};

        int target = 10;
        int[] position = {8,3,7,4,6,5};
        int[] speed = {4,4,4,4,4,4};

        CarFleet2 carFleet2 = new CarFleet2();
        int result = carFleet2.carFleet(target, position, speed);
        System.out.println(result);
    }

    public int carFleet(int target, int[] position, int[] speed) {
        List<int[]> fleet = new ArrayList<>();
        for (int i = 0; i < position.length; i++) {
            fleet.add(new int[] {position[i], speed[i]});
        }

        fleet.sort(Comparator.comparing(a -> a[0]));

        List<Double> times = new ArrayList<>();
        for (int i = fleet.size() - 1; i >= 0; i--) {
            int[] currentCar = fleet.get(i);
            double time = 1.0 * (target - currentCar[0]) / currentCar[1];
            if (times.isEmpty() || time > times.get(times.size() - 1)) {
                times.add(time);
            }
        }

        return times.size();
    }

}
