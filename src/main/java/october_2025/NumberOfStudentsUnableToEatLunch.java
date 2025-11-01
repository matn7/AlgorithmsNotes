package october_2025;

import java.util.HashMap;
import java.util.Map;

public class NumberOfStudentsUnableToEatLunch {

    public static void main(String[] args) {
//        int[] students = {1, 1, 1, 0, 0, 1};
//        int[] sandwiches = {1, 0, 0, 0, 1, 1};

        int[] students = {1,1,0,0};
        int[] sandwiches = {0,1,0,1};

        NumberOfStudentsUnableToEatLunch numberOfStudentsUnableToEatLunch = new NumberOfStudentsUnableToEatLunch();
        int result = numberOfStudentsUnableToEatLunch.countStudents(students, sandwiches);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public int countStudents(int[] students, int[] sandwiches) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int student : students) {
            counts.put(student, counts.getOrDefault(student, 0) + 1);
        }
        int res = students.length;
        for (int sandwich : sandwiches) {
            if (!counts.containsKey(sandwich) || counts.get(sandwich) == 0) {
                return res;
            }
            counts.put(sandwich, counts.get(sandwich) - 1);
            res--;
        }
        return res;
    }

}
