package november_2024;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

public class CarFleet {

    public static void main(String[] args) {
        CarFleet carFleet = new CarFleet();
        int[] position = {10,8,0,5,3};
        int[] speed = {2,4,1,1,3};
        int target = 12;

        int result = carFleet.carFleet(target, position, speed);
        System.out.println(result);

    }

    public int carFleet(int target, int[] position, int[] speed) {
        List<int[]> pairs = new ArrayList<>();
        for (int i = 0; i < position.length; i++) {
            pairs.add(new int[] {position[i], speed[i]});
        }

        pairs.sort(Comparator.comparing(a -> a[0]));
        List<Double> stack = new ArrayList<>();
        for (int i = pairs.size() - 1; i >= 0; i--) {
            int p = pairs.get(i)[0];
            int s = pairs.get(i)[1];
            stack.add(1.0 * (target - p) / s);
            if (stack.size() >= 2 && stack.get(stack.size() - 1) <= stack.get(stack.size() - 2)) {
                stack.remove(stack.size() - 1);
            }
        }
        return stack.size();
    }

}
