package medium;

import java.util.*;

public class TaskAssignmentREPEAT {

    public static void main(String[] args) {
        ArrayList<Integer> tasks = new ArrayList<>(Arrays.asList(1, 3, 5, 3, 1, 4));

        TaskAssignmentREPEAT task = new TaskAssignmentREPEAT();
        task.taskAssignment(3, tasks);
    }

    // O(nlog(n)) time | O(n) space
    // OK - repeated 08/02/2022
    public ArrayList<ArrayList<Integer>> taskAssignment(int k, ArrayList<Integer> tasks) {
        // Write your code here.
        ArrayList<ArrayList<Integer>> pairedTasks = new ArrayList<>();
        // Map element and in which index is stored
        // // {1: [0, 4], 3: [1, 3], 5: [2], 4: [5]}
        Map<Integer, ArrayList<Integer>> taskDurationsToIndices = getTaskDurationsToIndices(tasks);

        ArrayList<Integer> sortedTasks = new ArrayList<>(tasks);
        //  *  *           *
        // [1, 1, 3, 3, 4, 5]
        Collections.sort(sortedTasks);

        //  0  1  2  3  4  5
        // [1, 3, 5, 3, 1, 4]
        //  *  *  *  *  *  *

        for (int idx = 0; idx < k; idx++) { // 1
            Integer task1Duration = sortedTasks.get(idx); // 3
            ArrayList<Integer> indicesWithTaskDuration = taskDurationsToIndices.get(task1Duration); // [1, 3]
            Integer task1Index = indicesWithTaskDuration.remove(indicesWithTaskDuration.size() - 1); // 3

            int task2SortedIndex = tasks.size() - 1 - idx; // 3
            Integer task2Duration = sortedTasks.get(task2SortedIndex); // 3
            ArrayList<Integer> indicesWithTask2Duration = taskDurationsToIndices.get(task2Duration); // [1]
            Integer task2Index = indicesWithTask2Duration.remove(indicesWithTask2Duration.size() - 1); // 1

            pairedTasks.add(new ArrayList<>(Arrays.asList(task1Index, task2Index))); // [4, 2], [0, 5], [3, 1]
        }

        return pairedTasks;
    }

    private Map<Integer, ArrayList<Integer>>  getTaskDurationsToIndices(ArrayList<Integer> tasks) {
        // tasks = [1, 3, 5, 3, 1, 4]
        Map<Integer, ArrayList<Integer>> taskDurationsToIndices = new HashMap<>();

        for (int idx = 0; idx < tasks.size(); idx++) {
            int taskDuration = tasks.get(idx); // 1
            if (taskDurationsToIndices.containsKey(taskDuration)) {
                ArrayList<Integer> tasksList = taskDurationsToIndices.get(taskDuration);
                tasksList.add(idx);
                taskDurationsToIndices.remove(taskDuration);
                taskDurationsToIndices.put(taskDuration, tasksList);
            } else {
                taskDurationsToIndices.put(taskDuration, new ArrayList<>(Arrays.asList(idx)));
            }
        }
        // {1: [0, 4], 3: [1, 3], 5: [2], 4: [5]}
        return taskDurationsToIndices;
    }
}
