package coderpro;

public class Main {

    public static void main(String[] args) throws Exception {
        QueueUsingStacks<Integer> queueUsingStacks = new QueueUsingStacks<>();

        queueUsingStacks.enqueue(12);
        queueUsingStacks.enqueue(22);
        queueUsingStacks.enqueue(222);

        System.out.println(queueUsingStacks.dequeue());
        System.out.println(queueUsingStacks.dequeue());
        System.out.println(queueUsingStacks.dequeue());
//        System.out.println(queueUsingStacks.dequeue());

        QueueUsingStacks<String> queueUsingStacksStr = new QueueUsingStacks<>();

//        queueUsingStacksStr.dequeue();
        queueUsingStacksStr.enqueue("First added");
        queueUsingStacksStr.enqueue("Second added");
        queueUsingStacksStr.enqueue("Third added");
        System.out.println(queueUsingStacksStr.dequeue());
        System.out.println(queueUsingStacksStr.dequeue());
        System.out.println(queueUsingStacksStr.dequeue());

        // O(n) time | O(n) space
        Queue queue = new Queue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());

        queue.enqueue(5);
        queue.enqueue(6);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }
}
