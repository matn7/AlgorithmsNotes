package medium;

public class SumOfLinkedListsREPEAT {

    public static void main(String[] args) {
        LinkedList linkedListOne = new LinkedList(2);
        linkedListOne.next = new LinkedList(4);
        linkedListOne.next.next = new LinkedList(7);
        linkedListOne.next.next.next = new LinkedList(1);

        LinkedList linkedListTwo = new LinkedList(9);
        linkedListTwo.next = new LinkedList(4);
        linkedListTwo.next.next = new LinkedList(5);

        SumOfLinkedListsREPEAT sumOfLinkedListsREPEAT = new SumOfLinkedListsREPEAT();
        sumOfLinkedListsREPEAT.sumOfLinkedLists(linkedListOne, linkedListTwo);
    }

    // This is an input class. Do not edit.
    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    // O(max(m, n)) time | O(max(m, n)) space
    // OK - repeated 13/02/2022
    public LinkedList sumOfLinkedLists(LinkedList linkedListOne, LinkedList linkedListTwo) {
        // Write your code here.
        LinkedList newLinkedListHeadPointer = new LinkedList(0);
        LinkedList currentNode = newLinkedListHeadPointer;
        int carry = 0;

        //                     c
        // 0 -> 1 -> 9 -> 2 -> 2 ->
        //                     o
        // 2 -> 4 -> 7 -> 1 ->
        //                t
        // 9 -> 4 -> 5 ->
        LinkedList nodeOne = linkedListOne;
        LinkedList nodeTwo = linkedListTwo;
        while (nodeOne != null || nodeTwo != null || carry != 0) {
            int valueOne = nodeOne != null ? nodeOne.value : 0; // 1
            int valueTwo = nodeTwo != null ? nodeTwo.value : 0; // 0
            int sumOfValues = valueOne + valueTwo + carry; // 1 + 0 + 1 = 2

            int newValue = sumOfValues % 10; // 2
            LinkedList newNode = new LinkedList(newValue);
            currentNode.next = newNode;
            currentNode = newNode;

            carry = sumOfValues / 10; // 0
            nodeOne = nodeOne != null ? nodeOne.next : null;
            nodeTwo = nodeTwo != null ? nodeTwo.next : null;
        }

        return newLinkedListHeadPointer.next; // 1 -> 9 -> 2 -> 2 ->
    }

}
