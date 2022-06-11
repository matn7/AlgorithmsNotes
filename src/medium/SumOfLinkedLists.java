package medium;

public class SumOfLinkedLists {

    public static void main(String[] args) {
        LinkedList linkedListOne = new LinkedList(2);
//        linkedListOne.next = new LinkedList(4);
//        linkedListOne.next.next = new LinkedList(7);
//        linkedListOne.next.next.next = new LinkedList(1);

        LinkedList linkedListTwo = new LinkedList(9);
//        linkedListTwo.next = new LinkedList(4);
//        linkedListTwo.next.next = new LinkedList(5);

        SumOfLinkedLists sumOfLinkedLists = new SumOfLinkedLists();
        sumOfLinkedLists.sumOfLinkedLists(linkedListOne, linkedListTwo);
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

    public LinkedList sumOfLinkedLists(LinkedList linkedListOne, LinkedList linkedListTwo) {
        // Write your code here.
        LinkedList current1 = linkedListOne;
        LinkedList current2 = linkedListTwo;

        LinkedList result = null;
        LinkedList previous = null;
        int carry = 0;
        while (current1 != null && current2 != null) {
            int sum = current1.value + current2.value + carry;
            if (sum >= 10) {
                sum = sum % 10;
                carry = 1;
            } else {
                carry = 0;
            }
            if (result == null) {
                result = new LinkedList(sum);
                previous = result;
            } else {
                previous.next = new LinkedList(sum);
                previous = previous.next;
            }
            current1 = current1.next;
            current2 = current2.next;
        }

        while (current1 != null) {
            int sum = current1.value + carry;
            if (sum >= 10) {
                sum = sum % 10;
                carry = 1;
            } else {
                carry = 0;
            }
            previous.next = new LinkedList(sum);
            previous = previous.next;
            current1 = current1.next;
        }

        while (current2 != null) {
            int sum = current2.value + carry;
            if (sum >= 10) {
                sum = sum % 10;
                carry = 1;
            } else {
                carry = 0;
            }
            previous.next = new LinkedList(sum);
            previous = previous.next;
            current2 = current2.next;
        }

        if (carry != 0) {
            previous.next = new LinkedList(carry);
        }
        return result;
    }

}
