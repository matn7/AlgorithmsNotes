package problems.medium;

import java.util.*;

public class TaskAssignment {

    public static void main(String[] args) {
        ArrayList<Integer> tasks = new ArrayList<>(Arrays.asList(1,3,5,3,1,4));
        TaskAssignment taskAssignment = new TaskAssignment();

        taskAssignment.taskAssignment(3, tasks);
    }

    // O(nlogn) time | O(n) space
    public ArrayList<ArrayList<Integer>> taskAssignment(int k, ArrayList<Integer> tasks) {
        // Write your code here.
        ArrayList<ArrayList<Integer>> pairedTask = new ArrayList<>();
        ArrayList<Integer> sortedTasks = new ArrayList<>(tasks);

        Map<Integer, List<Integer>> taskDurationsToIndicies = getTaskDurationsToIndicies(tasks);
        Collections.sort(sortedTasks);

        for (int idx = 0; idx < k; idx++) {
            Integer task1Duration = sortedTasks.get(idx);
            List<Integer> indiciesWithTaskDuration = taskDurationsToIndicies.get(task1Duration);
            Integer task1Idx = indiciesWithTaskDuration.remove(indiciesWithTaskDuration.size() - 1);

            int task2SortedIdx = tasks.size() - 1 - idx;
            Integer task2Duration = sortedTasks.get(task2SortedIdx);
            List<Integer> indiciesWithTask2Duration = taskDurationsToIndicies.get(task2Duration);
            Integer task2Idx = indiciesWithTask2Duration.remove(indiciesWithTask2Duration.size() - 1);

            pairedTask.add(new ArrayList<>(Arrays.asList(task1Idx, task2Idx)));
        }
        return pairedTask;
    }

    private Map<Integer, List<Integer>> getTaskDurationsToIndicies(ArrayList<Integer> tasks) {
        Map<Integer, List<Integer>> taskDurationsToIndicies = new HashMap<>();

        for (int idx = 0; idx < tasks.size(); idx++) {
            Integer taskDuration = tasks.get(idx);
            if (taskDurationsToIndicies.containsKey(taskDuration)) {
                List<Integer> durationIdxArray = taskDurationsToIndicies.get(taskDuration);
                durationIdxArray.add(idx);
                taskDurationsToIndicies.remove(taskDuration);
                taskDurationsToIndicies.put(taskDuration, durationIdxArray);
            } else {
                List<Integer> durationIdxArray = new ArrayList<>();
                durationIdxArray.add(idx);
                taskDurationsToIndicies.put(taskDuration, durationIdxArray);
            }
        }
        return taskDurationsToIndicies;
    }

}
