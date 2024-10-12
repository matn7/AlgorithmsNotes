package udemy.recursion;

import java.util.ArrayList;
import java.util.List;

public class BuildACar {

    // O(n) time
    public static void buildCar(List<Task> taskList) {
        for (Task task : taskList) {
            task.execute();
        }
    }

    public static class Task {
        private String id;
        private List<Task> dependencyList;
        private boolean done = false;

        public Task(String id, Task... dependencyArray) {
            this.id = id;
            dependencyList = new ArrayList<>();
            for (Task task : dependencyArray) {
                dependencyList.add(task);
            }
        }

        public void execute() {
            if (done) {
                return;
            }

            // Ensure all successors are done first, this task cannot be executed without executing all it's
            // dependencies.
            for (Task task : dependencyList) {
                task.execute();
            }
            runTask();
        }

        private void runTask() {
            done = true;
            System.out.println("Completed task: " + id.toUpperCase());
        }
    }

}
