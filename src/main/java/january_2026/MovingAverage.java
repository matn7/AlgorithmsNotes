package january_2026;

import java.util.ArrayDeque;
import java.util.LinkedList;

public class MovingAverage {

    public static void main(String[] args) {
        MovingAverage movingAverage = new MovingAverage(3);
        System.out.println(movingAverage.next(1));

        System.out.println(movingAverage.next(10));

        System.out.println(movingAverage.next(3));

        System.out.println(movingAverage.next(5));

    }

    // O(1) time | O(n) space
    final LinkedList<Integer> queue;
    final int size;
    int sum;
    public MovingAverage(int size) {
        this.queue = new LinkedList<>();
        this.size = size;
        this.sum = 0;
    }

    public double next(int val) {
        queue.addLast(val);
        sum += val;
        if (queue.size() > size) {
            int removed = queue.removeFirst();
            sum -= removed;
        }
        return (double) sum / queue.size();
    }

}
