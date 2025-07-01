package june_2025;

import java.util.Stack;

public class DailyTemperatures {

    public static void main(String[] args) {
        int[] temperatures = {73,74,75,71,69,72,76,73};

        DailyTemperatures dailyTemperatures = new DailyTemperatures();
        int[] result = dailyTemperatures.dailyTemperatures(temperatures);
        // [1,1,4,2,1,1,0,0]
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> idxStack = new Stack<>();
        int[] result = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            while (!idxStack.isEmpty() && temperatures[i] > temperatures[idxStack.peek()]) {
                int idx = idxStack.pop();
                result[idx] = i - idx;
            }
            idxStack.push(i);
        }

        return result;
    }

}
