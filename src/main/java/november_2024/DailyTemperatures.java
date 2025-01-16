package november_2024;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DailyTemperatures {

    public static void main(String[] args) {
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};

        DailyTemperatures dailyTemperatures = new DailyTemperatures();
        int[] output = dailyTemperatures.dailyTemperatures(temperatures);
        System.out.println(output);
    }

    public int[] dailyTemperatures(int[] temperatures) {
        int[] output = new int[temperatures.length];

        List<Integer> stack = new ArrayList<>();

        for (int day = 0; day < temperatures.length; day++) {
            int currTemp = temperatures[day];
            while (!stack.isEmpty() && currTemp > temperatures[stack.get(stack.size() - 1)]) {
                int prevDay = stack.remove(stack.size() - 1);
                output[prevDay] = day - prevDay;
            }
            stack.add(day);
        }

        return output;
    }

}
