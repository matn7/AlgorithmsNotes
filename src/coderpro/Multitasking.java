package coderpro;

import java.util.HashMap;
import java.util.Map;

public class Multitasking {

    public static void main(String[] args) {
        int[] tasks = {1, 1, 2, 1};
        int c = 2;

        Multitasking multitasking = new Multitasking();
        int result = multitasking.findTime(tasks, c);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public int findTime(int[] tasks, int cooldown) {
        Map<Integer, Integer> lastPos = new HashMap<>();
        int current = 0;

        for (int task : tasks) {
            if (lastPos.containsKey(task)) {
                if (current - lastPos.get(task) <= cooldown) {
                    current = cooldown + lastPos.get(task) + 1;
                }
            }
            lastPos.put(task, current);
            current++;
        }
        return current;
    }

}
