package august_2024;

public class NumOfEmployees {

    public static void main(String[] args) {
        Employee employee = new Employee(2000);
        employee.left = new Employee(1000);
        employee.right = new Employee(4000);
        employee.right.left = new Employee(3000);
        employee.right.left.left = new Employee(2500);

        int result = numOfEmployees(employee, 2050);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public static int numOfEmployees(Employee employee, int amount) {
        if (employee == null) {
            return 0;
        }
        int right = numOfEmployees(employee.right, amount);
        if (employee.salary < amount) {
            return right;
        }
        int left = numOfEmployees(employee.left, amount);
        return 1 + left + right;
    }

    static class Employee {
        int salary;
        Employee left;
        Employee right;

        public Employee(int salary) {
            this.salary = salary;
        }
    }

}
