package medium;

public class DoublyLinkedList {
    public Node head;
    public Node tail;

    public static void main(String[] args) {
        Node element = new Node(1);
        element.prev = null;
        element.next = new Node(2);
        element.next.prev = element;
        element.next.next = new Node(3);
        element.next.next.prev = element.next;
        element.next.next.next = new Node(4);
        element.next.next.next.prev = element.next.next;
        element.next.next.next.next = new Node(5);
        element.next.next.next.next.prev = element.next.next.next;
        element.next.next.next.next.next = null;

        DoublyLinkedList ddl = new DoublyLinkedList();
        ddl.head = element;

        ddl.setHead(new Node(4));
        ddl.setTail(new Node(6));
        ddl.traverse(ddl.head);

        ddl.insertBefore(new Node(6), new Node(3));
        ddl.insertAfter(new Node(6), new Node(3));
        ddl.traverse(ddl.head);

        ddl.insertAtPosition(1, new Node(3));
        ddl.traverse(ddl.head);

        ddl.removeNodesWithValue(3);
        ddl.traverse(ddl.head);

        ddl.remove(new Node(2));
        ddl.traverse(ddl.head);

        System.out.println(ddl.containsNodeWithValue(5));

    }

    public void traverse(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println();
    }

    public void setHead(Node node) {
        // Write your code here.
        Node current = head;
        while (current != null) {
            if (current.value == node.value) {
                current.prev.next = current.next;
                current.next.prev = current.prev;
                current.next = this.head;
                head.prev = current;
                current.prev = null;
                head = current;
                return;
            }
            current = current.next;
        }
    }

    public void setTail(Node node) {
        // Write your code here.
        Node current = head;
        while (current.next != null) {
//            if (current.value == node.value) {
//                current.prev.next = current.next;
//            }
            current = current.next;
        }
        System.out.println(); // we have last element
        tail = current;
        current.next = node;
        node.prev = current;
        tail = node;
    }

    public void insertBefore(Node node, Node nodeToInsert) {
        // Write your code here.
        if (head == null) {
            head = nodeToInsert;
            return;
        }

        while (head != null) {
            if (head.value == node.value) {
                if (head.prev == null) {
                    // insert as first element
                    nodeToInsert.next = head;
                    head.prev = nodeToInsert;
//                    setHead(nodeToInsert);
                    return;
                }
                head.prev.next = nodeToInsert;
                nodeToInsert.prev = head.prev;
                head.prev = nodeToInsert;
                nodeToInsert.next = head;
            }
            head = head.next;
        }
    }

    public void insertAfter(Node node, Node nodeToInsert) {
        // Write your code here.
        Node current = this.head;
        if (current == null) {
            head = nodeToInsert;
            return;
        }

        while (current != null) {
            if (current.value == node.value) {
                if (current.next == null) {
                    // insert as last element
                    current.next = nodeToInsert;
                    nodeToInsert.prev = current;
//                    setTail(nodeToInsert);
                    return;
                }
                nodeToInsert.prev = current;
                nodeToInsert.next = current.next;
                current.next.prev = nodeToInsert;
                current.next = nodeToInsert;
            }
            current = current.next;
        }
    }

    public void insertAtPosition(int position, Node nodeToInsert) {
        // Write your code here.
        Node current = this.head;
        int counter = 1;

        while (current.next != null && counter < position) {
            counter++;
            current = current.next;
        }

        if (counter < position) {
            // insert as last element
            current.next = nodeToInsert;
            nodeToInsert.prev = current;
//            setTail(nodeToInsert);
        } else {
            insertBefore(current, nodeToInsert);
        }

    }

    public void removeNodesWithValue(int value) {
        // Write your code here.
        Node current = this.head;
        while (current != null) {
            if (current.value == value) {
                remove(current);
            }
            current = current.next;
        }
    }

    public void remove(Node node) {
        // Write your code here.
        Node current = this.head;
        while (current != null) {
            if (current.value == node.value) {
                if (current.next == null) {
                    // remove last element
                    current.prev.next = null;
//                    setTail(current.prev);
                    return;
                }
                if (current.prev == null) {
                    // remove first element
                    current.next.prev = null;
//                    setHead(current.next);
                    return;
                }
                current.prev.next = current.next;
                current.next.prev = current.prev;
            }
            current = current.next;
        }
    }

    public boolean containsNodeWithValue(int value) {
        // Write your code here.
        Node current = this.head;
        while (current != null) {
            if (current.value == value) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // Do not edit the class below.
    static class Node {
        public int value;
        public Node prev;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }
}

