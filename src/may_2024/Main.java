package may_2024;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
//        CircularQueue circularQueue = new CircularQueue(7);
//
//        circularQueue.enqueue(5);
//        circularQueue.enqueue(6);
//        circularQueue.enqueue(8);
//        circularQueue.enqueue(9);
//        circularQueue.enqueue(-11);
//        circularQueue.enqueue(23);
//        circularQueue.enqueue(25);
//
//        int dequeue = circularQueue.dequeue();
//
//        circularQueue.enqueue(27);
//
//        circularQueue.dequeue();
//        circularQueue.dequeue();
//        circularQueue.dequeue();
//        circularQueue.dequeue();
//        circularQueue.dequeue();
//        circularQueue.dequeue();
//        circularQueue.dequeue();
////        circularQueue.dequeue();

        List<Integer> array = new ArrayList<>();
        int[] nums = {15, 50, 25, 45, 20, 10, 35};
        for (int num : nums) {
            array.add(num);
        }
//        PriorityQueue priorityQueue = new PriorityQueue(array);
//        priorityQueue.printElements();
//
//        System.out.println();
//        priorityQueue.push(5);
//        priorityQueue.printElements();
//
//        System.out.println();
//        priorityQueue.pop();
//        priorityQueue.printElements();
//
//        System.out.println();
//        priorityQueue.pop();
//        priorityQueue.printElements();
//
//        System.out.println();
//        priorityQueue.pop();
//        priorityQueue.printElements();
//
//        System.out.println();
//        priorityQueue.pop();
//        priorityQueue.printElements();
//
//        System.out.println();
//        priorityQueue.pop();
//        priorityQueue.printElements();
//
//        System.out.println();
//        priorityQueue.pop();
//        priorityQueue.printElements();
//
//        System.out.println();
//        priorityQueue.pop();
//        priorityQueue.printElements();
//
//        System.out.println();
//        priorityQueue.pop();
//        priorityQueue.printElements();
//
//        System.out.println();
//        priorityQueue.push(15);
//        priorityQueue.printElements();
//
//        System.out.println();

        List<Double> doubleArray = new ArrayList<>();
        double[] doubles = {15, 50, 25, 45, 20, 10, 35};
        for (double doub : doubles) {
            doubleArray.add(doub);
        }
        PriorityQueueComparator<Double> priorityQueueComp = new PriorityQueueComparator<>(doubleArray, Comparator.reverseOrder());
        priorityQueueComp.printElements();

        System.out.println();
        priorityQueueComp.pop();
        priorityQueueComp.printElements();

        System.out.println();
        priorityQueueComp.pop();
        priorityQueueComp.printElements();

        System.out.println();
        priorityQueueComp.push(700.0);
        priorityQueueComp.printElements();

        System.out.println();
        priorityQueueComp.push(36.0);
        priorityQueueComp.printElements();

        System.out.println();
        priorityQueueComp.pop();
        priorityQueueComp.printElements();

        System.out.println();
        priorityQueueComp.pop();
        priorityQueueComp.printElements();


    }

    static class Student implements Comparable<Student> {
        int grade;
        String name;

        public Student(int grade, String name) {
            this.grade = grade;
            this.name = name;
        }

        @Override
        public int compareTo(Student o) {
            return o.grade - this.grade;
        }
    }

}
