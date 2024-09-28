package august_2024;

import java.util.HashMap;
import java.util.Map;

public class Multitasking {

    public static void main(String[] args) {
        int[] tasks = {1, 1, 2, 1};
        int cooldown = 2;
    }

    public static int findTime(int[] tasks, int cooldown) {
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
