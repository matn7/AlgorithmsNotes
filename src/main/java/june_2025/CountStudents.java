package june_2025;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class CountStudents {

    public static void main(String[] args) {
//        int[] students = {1,1,0,0};
//        int[] sandwiches = {0,1,0,1};

        int[] students = {1,1,1,0,0,1};
        int[] sandwiches = {1,0,0,0,1,1};

        CountStudents countStudents = new CountStudents();
        int result = countStudents.countStudents(students, sandwiches);
        System.out.println(result);
    }

    public int countStudents(int[] students, int[] sandwiches) {

        Deque<Integer> queue = new ArrayDeque<>();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < students.length; i++) {
            queue.addFirst(students[i]);
            stack.push(sandwiches[i]);
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            int count = 0;
            while (!queue.isEmpty() && queue.peek() != stack.peek()) {
                if (count >= size) {
                    return queue.size();
                }
                int front = queue.poll();
                queue.addLast(front);
                count++;
            }
            queue.poll();
            stack.pop();
        }
        return queue.size();
    }

}
