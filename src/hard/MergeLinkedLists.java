package hard;

public class MergeLinkedLists {

    public static void main(String[] args) {
        LinkedList list1 = new LinkedList(2);
        list1.next = new LinkedList(6);
        list1.next.next = new LinkedList(7);
        list1.next.next.next = new LinkedList(8);

        LinkedList list2 = new LinkedList(1);
        list2.next = new LinkedList(3);
        list2.next.next = new LinkedList(4);
        list2.next.next.next = new LinkedList(5);
        list2.next.next.next.next = new LinkedList(9);
        list2.next.next.next.next.next = new LinkedList(10);

        mergeLinkedLists(list1, list2);
    }

    public static LinkedList mergeLinkedLists(LinkedList headOne, LinkedList headTwo) {
        // Write your code here.
        LinkedList first = headOne;
        LinkedList second = headTwo;


        LinkedList result = null;
        if (first != null && second != null) {
            if (first.value < second.value) {
                result = new LinkedList(first.value);
                first = first.next;
            } else {
                result = new LinkedList(second.value);
                second = second.next;
            }
        }

        LinkedList start = result;

        int compare = Integer.compare(first.value, second.value);

        while (first != null && second != null) {
            if (Integer.valueOf(first.value).compareTo(Integer.valueOf(second.value)) < 0) {
                result.next = first;
                first = first.next;
            } else if (Integer.valueOf(first.value).compareTo(Integer.valueOf(second.value)) > 0)  {
                result.next = second;
                second = second.next;
            } else {
                result.next = second;
                second = second.next;

                result = result.next;

                result.next = first;
                first = first.next;
            }

            result = result.next;
        }

        if (first != null) {
            result.next = first;
        }

        if (second != null) {
            result.next = second;
        }

        return start;
    }

    // This is an input class. Do not edit.
    public static class LinkedList {
        int value;
        LinkedList next;

        LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }
}
