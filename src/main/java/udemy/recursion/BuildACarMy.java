package udemy.recursion;

import java.util.*;

public class BuildACarMy {

    // A, B, C, D, E, F, G, H

    // B depends on A
    // D depends on E
    // C depends on A, B, D
    // F depends on C

    // so as G, H has no dependencies it can be executed anytime

    // An acceptable order
    // E -> D -> A -> B -> C -> F
    public static void main(String[] args) {
        Map<String, List<String>> deps = new HashMap<>();
        deps.put("B", Arrays.asList("A"));
        deps.put("D", Arrays.asList("E"));
        deps.put("C", Arrays.asList("A", "B", "D"));
        deps.put("F", Arrays.asList("C"));

        List<String> tasks = Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H");

        List<String> result = taskDependencies(deps, tasks);
        System.out.println();
    }

    public static List<String> taskDependencies(Map<String, List<String>> deps, List<String> tasks) {
        List<String> result = new ArrayList<>();
        Map<String, Task> tasksMap = new HashMap<>();
        Map<String, List<Task>> dependentTo = new HashMap<>();
        for (String task : tasks) {
            tasksMap.put(task, new Task(task));
            dependentTo.put(task, new ArrayList<>());
        }

        for (Map.Entry<String, List<String>> dep : deps.entrySet()) {
            String currentKey = dep.getKey(); // B
            Task currentTask = tasksMap.get(currentKey); // (B, 0, [])
            List<String> dependentFrom = dep.getValue(); // [A]
            for (String task : dependentFrom) {
                prepareDependentToMap(dependentTo, currentTask, task);
                Task depTask = tasksMap.get(task); // (A, 0, [])
                currentTask.addDependency(depTask);
                currentTask.dep += 1;
            }
        }

        List<Task> noDepTasks = new ArrayList<>();
        for (Map.Entry<String, Task> task : tasksMap.entrySet()) {
            Task curr = task.getValue();
            if (curr.dep == 0) {
                noDepTasks.add(curr);
            }
        }

        while (!noDepTasks.isEmpty()) {
            Task curr = noDepTasks.remove(0);
            result.add(curr.id);
            List<Task> dependentToList = dependentTo.get(curr.id);
            reflectNeighbors(noDepTasks, curr, dependentToList);
        }

        return result;
    }

    private static void prepareDependentToMap(Map<String, List<Task>> dependentTo, Task currentTask, String task) {
        if (dependentTo.containsKey(task)) {
            List<Task> currDeps = dependentTo.get(task);
            currDeps.add(currentTask);
            dependentTo.put(task, currDeps);
        } else {
            List<Task> newDeps = new ArrayList<>();
            newDeps.add(currentTask);
            dependentTo.put(task, newDeps);
        }
    }

    private static void reflectNeighbors(List<Task> noDepTasks, Task curr, List<Task> dependentToList) {
        for (Task neighbor : dependentToList) {
            neighbor.dependencies.remove(curr);
            neighbor.dep -= 1;
            if (neighbor.dep == 0) {
                noDepTasks.add(neighbor);
            }
        }
    }

    public static class Task {
        String id;
        int dep = 0;
        Set<Task> dependencies;

        public Task(String id) {
            this.id = id;
            this.dependencies = new HashSet<>();
        }

        public void addDependency(Task task) {
            this.dependencies.add(task);
        }
    }

}
