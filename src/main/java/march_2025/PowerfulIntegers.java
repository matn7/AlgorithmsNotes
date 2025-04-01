package march_2025;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PowerfulIntegers {

    public static void main(String[] args) {
        int x = 2;
        int y = 91;
        int bound = 996;

        PowerfulIntegers powerfulIntegers = new PowerfulIntegers();
        List<Integer> result = powerfulIntegers.powerfulIntegers(x, y, bound);
        System.out.println(result);
    }

    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> result = new HashSet<>();
        int a = x == 1 ? 1 : bound / x;
        int b = y == 1 ? 1 : bound / y;
        for (int i = 0; i <= a; i++) {
            for (int j = 0; j <= b; j++) {
                long test = (int) Math.pow(x, i) + (int) Math.pow(y, j);
                if (test >= Integer.MAX_VALUE || test <= Integer.MIN_VALUE) {
                    break;
                }
                int num = (int) Math.pow(x, i) + (int) Math.pow(y, j);
                if (num <= bound) {
                    result.add(num);
                } else {
                    break;
                }
            }
        }
        return new ArrayList<>(result);
    }

}
