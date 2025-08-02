package july_2025;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class CountStudents {

    public static void main(String[] args) {
        CountStudents countStudents = new CountStudents();
//        int[] students = {1,1,0,0};
//        int[] sandwiches = {0,1,0,1};
        int[] students = {1,1,1,0,0,1};
        int[] sandwiches = {1,0,0,0,1,1};
        int result = countStudents.countStudents(students, sandwiches);
        System.out.println(result);
    }

    // O(n) time | O(n) space -> O(1) space only 0, and 1
    public int countStudents(int[] students, int[] sandwiches) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int student : students) {
            counts.put(student, counts.getOrDefault(student, 0) + 1);
        }
        int res = students.length;

        for (int s : sandwiches) {
            if (!counts.containsKey(s) || counts.get(s) == 0) {
                return res;
            }
            counts.put(s, counts.getOrDefault(s, 0) - 1);
            res--;
        }
        return res;
    }


}
