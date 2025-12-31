package december_2025;

import java.util.ArrayDeque;

public class MovingAverage {

    public static void main(String[] args) {
        MovingAverage movingAverage = new MovingAverage(3);
        System.out.println(movingAverage.next(1));
        System.out.println(movingAverage.next(10));
        System.out.println(movingAverage.next(3));
        System.out.println(movingAverage.next(5));
    }

    ArrayDeque<Integer> queue;
    int size;
    double average = 0;

    public MovingAverage(int size) {
        queue = new ArrayDeque<>();
        this.size = size;
    }

    public double next(int val) {
        queue.addLast(val);
        average += val;
        if (queue.size() > size) {
            int removed = queue.removeFirst();
            average -= removed;
        }
        return average / Math.min(queue.size(), size);
    }

}
