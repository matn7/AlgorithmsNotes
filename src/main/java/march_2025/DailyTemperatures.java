package march_2025;

import java.util.Stack;

public class DailyTemperatures {

    public static void main(String[] args) {
        int[] temperatures = {73,74,75,71,69,72,76,73};
        int[] res = {1,1,4,2,1,1,0,0};

        DailyTemperatures dailyTemperatures = new DailyTemperatures();
        int[] result = dailyTemperatures.dailyTemperatures(temperatures);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int[] result = new int[temperatures.length];

        for (int i = 1; i < temperatures.length; i++) {
            int curr = temperatures[i];
            while (!stack.isEmpty() && curr >= temperatures[stack.peek()]) {
                Integer index = stack.pop();
                result[index] = i - index;
            }
            stack.push(i);
        }

        return result;
    }

}
