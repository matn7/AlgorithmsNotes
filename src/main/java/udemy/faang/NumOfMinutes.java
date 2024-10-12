package udemy.faang;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumOfMinutes {

    public static void main(String[] args) {
        int n = 8;
        int[] managers = {2, 2, 4, 6, -1, 4, 4, 5};
        int[] informtime = {0, 0, 4, 0, 7, 3, 6, 0};
        NumOfMinutes numOfMinutes = new NumOfMinutes();
        numOfMinutes.numOfMinutes(n, 4, managers, informtime);
    }

    // O(n) time | O(n) space
    public int numOfMinutes(int n, int headId, int[] managers, int[] informtime) {
        Map<Integer, Employee> employeeGraph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            employeeGraph.put(i, new Employee(i));
        }

        for (int e = 0; e < n; e++) {
            Employee employee = employeeGraph.get(e);
            if (managers[e] == -1) {
                continue;
            }
            Employee manager = employeeGraph.get(managers[e]);
            manager.addSub(employee);
        }

        int result = dfs(employeeGraph.get(headId), informtime);
        return result;
    }

    private int dfs(Employee employee, int[] informtime) {
        if (employee.subordinates.isEmpty()) {
            return 0;
        }
        int max = 0;
        List<Employee> subordinates = employee.subordinates;
        for (Employee sub : subordinates) {
            max = Math.max(max, dfs(sub, informtime));
        }
        return max + informtime[employee.id];
    }

    class Employee {
        int id;
        List<Employee> subordinates;

        public Employee(int id) {
            this.id = id;
            this.subordinates = new ArrayList<>();
        }

        public void addSub(Employee e) {
            this.subordinates.add(e);
        }
    }

}
