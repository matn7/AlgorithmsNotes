package coderpro;

public class Main {

    public static void main(String[] args) throws Exception {
        QueueUsingStacks<Integer> queueUsingStacks = new QueueUsingStacks<>();

        queueUsingStacks.enqueue(1);
        queueUsingStacks.enqueue(2);
        queueUsingStacks.enqueue(3);
        queueUsingStacks.enqueue(4);

        System.out.println(queueUsingStacks.dequeue());

        int[][] matrix = {
                {1, 3, 5, 8},
                {10, 11, 15, 16},
                {24, 27, 30, 31}
        };
    }
}
