package october_2024;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class MinNumOfDaysToEatOranges {

    public static void main(String[] args) {
        int n = 16;

        MinNumOfDaysToEatOranges minNum = new MinNumOfDaysToEatOranges();
        int result = minNum.minDays(n);
        System.out.println(result);
    }

    public int minDays(int n) {
        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(0, 0);
        dp.put(1, 1);
        return dfs(n, dp);
    }

    private int dfs(int n, Map<Integer, Integer> dp) {
        if (dp.containsKey(n)) {
            return dp.get(n);
        }
        int one = 1 + (n % 2) + dfs(n / 2, dp);
        int two = 1 + (n % 3) + dfs(n / 3, dp);
        dp.put(n, Math.min(one, two));
        return dp.get(n);
    }

    // O(3^logx(n)) time
    public int minDays2(int n) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        int days = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer front = queue.poll();
                if (front == 0) {
                    return days;
                }
                queue.add(front - 1);
                if (front % 2 == 0) {
                    queue.add(front - (front / 2));
                }
                if (front % 3 == 0) {
                    queue.add(front - (2 * front / 3));
                }
            }
            days++;
        }
        return days;
    }
}
