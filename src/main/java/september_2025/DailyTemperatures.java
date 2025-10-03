package september_2025;

import java.util.ArrayDeque;

public class DailyTemperatures {

    public static void main(String[] args) {
        int[] temperatures = {73,74,75,71,69,72,76,73};

        DailyTemperatures dailyTemperatures = new DailyTemperatures();
        int[] result = dailyTemperatures.dailyTemperatures(temperatures);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int idx = 0; idx < temperatures.length; idx++) {
            int curr = temperatures[idx];
            while (!stack.isEmpty() && temperatures[stack.getFirst()] < curr) {
                int i = stack.removeFirst();
                result[i] = idx - i;
            }
            stack.addFirst(idx);
        }
        return result;
    }

}
