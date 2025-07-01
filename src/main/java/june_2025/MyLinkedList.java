package june_2025;

import java.util.ArrayList;
import java.util.List;

public class MyLinkedList {

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();

        myLinkedList.deleteAtIndex(0);

//        myLinkedList.addAtHead(7);
//        myLinkedList.addAtHead(2);
//        myLinkedList.addAtHead(1);
//        myLinkedList.addAtIndex(3, 0);
//        myLinkedList.deleteAtIndex(2);
//        myLinkedList.addAtHead(6);
//        myLinkedList.addAtTail(4);
//
//        System.out.println(myLinkedList.get(4));
//        myLinkedList.addAtHead(4);
//        myLinkedList.addAtIndex(5, 0);
//        myLinkedList.addAtHead(6);
        System.out.println();
    }


    List<Integer> array;

    public MyLinkedList() {
        array = new ArrayList<>();
    }

    public int get(int index) {
        if (array.size() <= index) {
            return -1;
        }
        return array.get(index);
    }

    public void addAtHead(int val) {
        array.add(0, val);
    }

    public void addAtTail(int val) {
        array.add(array.size(), val);
    }

    public void addAtIndex(int index, int val) {
        if (array.size() < index) {
            return;
        }
        array.add(index, val);

    }

    public void deleteAtIndex(int index) {
        if (array.size() <= index) {
            return;
        }
        array.remove(index);
    }
}
