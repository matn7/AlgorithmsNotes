package october_2024;

import java.util.Stack;

public class DailyTemperature {

    public static void main(String[] args) {
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};

        DailyTemperature dailyTemperature = new DailyTemperature();
        int[] ints = dailyTemperature.dailyTemperatures(temperatures);
        System.out.println(ints);
    }

    // O(n) time | O(n) space
    public int[] dailyTemperatures(int[] temperatures) {
        // [73, 74, 75, 71, 69, 72, 76, 73]
        //       *
        int[] output = new int[temperatures.length];

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < temperatures.length; i++) {
            if (stack.isEmpty()) {
                stack.add(i);
            } else {
                int curr = temperatures[i];
                while (!stack.isEmpty() && curr > temperatures[stack.peek()]) { // 73 >= 76
                    int idx = stack.pop();
                    output[idx] = i - idx;
                }
                stack.push(i);
            }
        }

        return output;
    }

}
