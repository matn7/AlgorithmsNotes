package july_2025;

import java.util.Stack;

public class DailyTemperatures {

    public static void main(String[] args) {
//        int[] temperatures = {73,74,75,71,69,72,76,73};

//        int[] temperatures = {30,40,50,60};

        int[] temperatures = {30,60,90};

        DailyTemperatures dailyTemperatures = new DailyTemperatures();
        int[] result = dailyTemperatures.dailyTemperatures(temperatures);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            int temp = temperatures[i];
            while (!stack.isEmpty() && temperatures[stack.peek()] < temp) {
                int idx = stack.pop();
                result[idx] = i - idx;
            }
            stack.push(i);
        }
        return result;
    }


}
