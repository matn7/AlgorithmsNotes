package medium;

// This file is initialized with a code version of this
// question's sample test case. Feel free to add, edit,
// or remove test cases in this file as you see fit!

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.Assert.assertTrue;

class ProgramTest {
    private List<Integer> getNodeValuesHeadToTail(DoublyLinkedList linkedList) {
        List<Integer> values = new ArrayList<Integer>();
        DoublyLinkedList.Node node = linkedList.head;
        while (node != null) {
            values.add(node.value);
            node = node.next;
        }
        return values;
    }

    private List<Integer> getNodeValuesTailToHead(DoublyLinkedList linkedList) {
        List<Integer> values = new ArrayList<Integer>();
        DoublyLinkedList.Node node = linkedList.tail;
        while (node != null) {
            values.add(node.value);
            node = node.prev;
        }
        return values;
    }

    private void bindNodes(DoublyLinkedList.Node nodeOne, DoublyLinkedList.Node nodeTwo) {
        nodeOne.next = nodeTwo;
        nodeTwo.prev = nodeOne;
    }

    private boolean compare(List<Integer> array1, int[] array2) {
        if (array1.size() != array2.length) {
            return false;
        }
        for (int i = 0; i < array1.size(); i++) {
            if (array1.get(i) != array2[i]) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void TestCase1() {
        DoublyLinkedList linkedList = new DoublyLinkedList();
        DoublyLinkedList.Node one = new DoublyLinkedList.Node(1);
        DoublyLinkedList.Node two = new DoublyLinkedList.Node(2);
        DoublyLinkedList.Node three = new DoublyLinkedList.Node(3);
        DoublyLinkedList.Node three2 = new DoublyLinkedList.Node(3);
        DoublyLinkedList.Node three3 = new DoublyLinkedList.Node(3);
        DoublyLinkedList.Node four = new DoublyLinkedList.Node(4);
        DoublyLinkedList.Node five = new DoublyLinkedList.Node(5);
        DoublyLinkedList.Node six = new DoublyLinkedList.Node(6);
        bindNodes(one, two);
        bindNodes(two, three);
        bindNodes(three, four);
        bindNodes(four, five);
        linkedList.head = one;
        linkedList.tail = five;

        linkedList.setHead(four);
        assertTrue(compare(getNodeValuesHeadToTail(linkedList), new int[] {4, 1, 2, 3, 5}));
        assertTrue(compare(getNodeValuesTailToHead(linkedList), new int[] {5, 3, 2, 1, 4}));

        linkedList.setTail(six);
        assertTrue(compare(getNodeValuesHeadToTail(linkedList), new int[] {4, 1, 2, 3, 5, 6}));
        assertTrue(compare(getNodeValuesTailToHead(linkedList), new int[] {6, 5, 3, 2, 1, 4}));

        linkedList.insertBefore(six, three);
        // Utils.assertTrue(compare(getNodeValuesHeadToTail(linkedList), new int[] {4, 1, 2, 5, 3, 6}));
        assertTrue(compare(getNodeValuesTailToHead(linkedList), new int[] {6, 3, 5, 2, 1, 4}));

//     linkedList.insertAfter(six, three2);
//     Utils.assertTrue(compare(getNodeValuesHeadToTail(linkedList), new int[] {4, 1, 2, 5, 3, 6, 3}));
//     Utils.assertTrue(compare(getNodeValuesTailToHead(linkedList), new int[] {3, 6, 3, 5, 2, 1, 4}));

//     linkedList.insertAtPosition(1, three3);
//     Utils.assertTrue(
//         compare(getNodeValuesHeadToTail(linkedList), new int[] {3, 4, 1, 2, 5, 3, 6, 3}));
//     Utils.assertTrue(
//         compare(getNodeValuesTailToHead(linkedList), new int[] {3, 6, 3, 5, 2, 1, 4, 3}));

//     linkedList.removeNodesWithValue(3);
//     Utils.assertTrue(compare(getNodeValuesHeadToTail(linkedList), new int[] {4, 1, 2, 5, 6}));
//     Utils.assertTrue(compare(getNodeValuesTailToHead(linkedList), new int[] {6, 5, 2, 1, 4}));

//     linkedList.remove(two);
//     Utils.assertTrue(compare(getNodeValuesHeadToTail(linkedList), new int[] {4, 1, 5, 6}));
//     Utils.assertTrue(compare(getNodeValuesTailToHead(linkedList), new int[] {6, 5, 1, 4}));

//     Utils.assertTrue(linkedList.containsNodeWithValue(5));
    }
}

