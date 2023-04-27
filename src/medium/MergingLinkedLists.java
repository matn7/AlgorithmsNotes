package medium;

import java.util.HashSet;
import java.util.Set;

public class MergingLinkedLists {
    // This is an input class. Do not edit.
    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    // O(n + m) time | O(1) space
    public LinkedList mergingLinkedLists(LinkedList linkedListOne, LinkedList linkedListTwo) {
        LinkedList currentNodeOne = linkedListOne;
        LinkedList currentNodeTwo = linkedListTwo;

        while (currentNodeOne != currentNodeTwo) {
            if (currentNodeOne == null) {
                currentNodeOne = linkedListTwo;
            } else {
                currentNodeOne = currentNodeOne.next;
            }

            if (currentNodeTwo == null) {
                currentNodeTwo = linkedListOne;
            } else {
                currentNodeTwo = currentNodeTwo.next;
            }
        }
        return currentNodeOne;
    }

    // O(n + m) time | O(1) space
    public LinkedList mergingLinkedLists2(LinkedList linkedListOne, LinkedList linkedListTwo) {
        LinkedList currentNodeOne = linkedListOne;
        int countOne = 0;
        while (currentNodeOne != null) {
            countOne++;
            currentNodeOne = currentNodeOne.next;
        }

        LinkedList currentNodeTwo = linkedListTwo;
        int countTwo = 0;
        while (currentNodeTwo != null) {
            countTwo++;
            currentNodeTwo = currentNodeTwo.next;
        }

        int difference = Math.abs(countTwo - countOne);
        LinkedList biggerCurrentNode = countOne > countTwo ? linkedListOne : linkedListTwo;
        LinkedList smallerCurrentNode = countOne > countTwo ? linkedListTwo : linkedListOne;

        for (int i = 0; i < difference; i++) {
            biggerCurrentNode = biggerCurrentNode.next;
        }

        while (biggerCurrentNode != smallerCurrentNode) {
            biggerCurrentNode = biggerCurrentNode.next;
            smallerCurrentNode = smallerCurrentNode.next;
        }

        return biggerCurrentNode;
    }

    // O(n + m) time | O(n) space
    public LinkedList mergingLinkedLists1(LinkedList linkedListOne, LinkedList linkedListTwo) {
        // Write your code here.
        Set<LinkedList> listOneNodes = new HashSet<>();
        LinkedList currentNodeOne = linkedListOne;
        while (currentNodeOne != null) {
            listOneNodes.add(currentNodeOne);
            currentNodeOne = currentNodeOne.next;
        }
        LinkedList currentNodeTwo = linkedListTwo;
        while (currentNodeTwo != null) {
            if (listOneNodes.contains(currentNodeTwo)) {
                return currentNodeTwo;
            }
            currentNodeTwo = currentNodeTwo.next;
        }
        return null;
    }
}
