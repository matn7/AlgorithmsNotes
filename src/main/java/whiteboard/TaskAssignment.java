package whiteboard;

import java.util.*;

public class TaskAssignment {

    public static void main(String[] args) {
        TaskAssignment taskAssignment = new TaskAssignment();
        ArrayList<Integer> tasks = new ArrayList<>();
        int[] tasksArr = {1, 3, 5, 3, 1, 4};
        for (int task : tasksArr) {
            tasks.add(task);
        }

        taskAssignment.taskAssignment(3, tasks);
    }

    // O(nlog(n)) time | O(n) space
    // rand: 31/07/2022 | 21/08/2022
    public ArrayList<ArrayList<Integer>> taskAssignment(int k, ArrayList<Integer> tasks) {
        // Write your code here.
        Map<Integer, List<Integer>> durationMap = new HashMap<>();

        for (int i = 0; i < tasks.size(); i++) {
            int key = tasks.get(i);
            if (durationMap.containsKey(key)) {
                List<Integer> curr = durationMap.get(key);
                curr.add(i);
                durationMap.put(key, curr);
            } else {
                List<Integer> indexes = new ArrayList<>();
                indexes.add(i);
                durationMap.put(key, indexes);
            }
        }

        Collections.sort(tasks);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int start = 0;
        int end = tasks.size() - 1;
        while (start < end) {
            Integer first = tasks.get(start);
            Integer second = tasks.get(end);
            Integer firstIdx = durationMap.get(first).remove(0);
            Integer secondIdx = durationMap.get(second).remove(0);
            ArrayList<Integer> oneResult = new ArrayList<>();
            oneResult.add(firstIdx);
            oneResult.add(secondIdx);
            result.add(oneResult);
            start++;
            end--;
        }

        return result;
    }

}
