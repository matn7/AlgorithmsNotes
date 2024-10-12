package whiteboard;

public class SumOfLinkedLists {

    // This is an input class. Do not edit.
    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        LinkedList one = new LinkedList(1);
        one.next = new LinkedList(1);
        one.next.next = new LinkedList(1);
//        one.next.next.next = new LinkedList(1);

        LinkedList two = new LinkedList(9);
        two.next = new LinkedList(9);
        two.next.next = new LinkedList(9);

        SumOfLinkedLists sumOfLinkedLists = new SumOfLinkedLists();
        sumOfLinkedLists.sumOfLinkedLists(one, two);
    }

    public LinkedList sumOfLinkedLists(LinkedList linkedListOne, LinkedList linkedListTwo) {
        // Write your code here.
        LinkedList newList = new LinkedList(0);
        LinkedList one = linkedListOne;
        LinkedList two = linkedListTwo;
        int carry = 0;
        LinkedList workerList = newList;

        while (one != null && two != null) {
            int firstVal = one.value;
            int secondVal = two.value;
            int sum = firstVal + secondVal + carry;
            carry = sum / 10;
            int newNodeValue = sum % 10;
            LinkedList newNode = new LinkedList(newNodeValue);
            workerList.next = newNode;
            workerList = newNode;
            one = one.next;
            two = two.next;
        }

        while (one != null) {
            int firstVal = one.value;
            int sum = firstVal + carry;
            carry = sum / 10;
            int newNodeValue = sum % 10;
            LinkedList newNode = new LinkedList(newNodeValue);
            workerList.next = newNode;
            workerList = newNode;
            one = one.next;
        }

        while (two != null) {
            int secondValue = two.value;
            int sum = secondValue + carry;
            carry = sum / 10;
            int newNodeValue = sum % 10;
            LinkedList newNode = new LinkedList(newNodeValue);
            workerList.next = newNode;
            workerList = newNode;
            two = two.next;
        }

        if (carry != 0) {
            workerList.next = new LinkedList(carry);
        }

        return newList.next;
    }

}
