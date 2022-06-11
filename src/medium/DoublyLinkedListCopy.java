package medium;

public class DoublyLinkedListCopy {
    public static Node head;
    public Node tail;

    public static void main(String[] args) {
        Node element = new Node(1);
        head = element;
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

        DoublyLinkedListCopy ddl = new DoublyLinkedListCopy();

//        ddl.setHead(new Node(4));
//        ddl.setTail(new Node(6));

        ddl.insertAfter(new Node(1), new Node(8)); // 8
        ddl.insertAfter(new Node(8), new Node(2)); // 2 8
        ddl.insertAfter(new Node(8), new Node(2));

        ddl.insertBefore(new Node(8), new Node(6));
        ddl.insertBefore(new Node(8), new Node(9));
        ddl.insertBefore(new Node(8), new Node(12));

        ddl.insertBefore(new Node(6), new Node(3));
        ddl.insertAfter(new Node(6), new Node(3));
        traverse(head);
//        ddl.insertAtPosition(-5, new Node(5));
        System.out.println();
        System.out.println(ddl.containsNodeWithValue(5));

//        ddl.remove(new Node(5));

        traverse(head);
        System.out.println();
        System.out.println(ddl.containsNodeWithValue(5));


        ddl.removeNodesWithValue(2);
        traverse(head);
    }

    public static void traverse(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
    }

    public void setHead(Node node) {
        // Write your code here.
        Node current = this.head;
        insertBefore(current, node); // as first element insert node
        this.head = current.prev;
        while (current != null) {
            if (current.value == node.value) {
                remove(current);
            }
            current = current.next;
        }
    }

    public void setTail(Node node) {
        // Write your code here.
        Node current = this.head;

        while (current.next != null) {
            if (current.value == node.value) {
                remove(current);
            }
            current = current.next;
        }
        this.tail = current;
        insertAfter(current, node);
        this.tail = current.next;
    }

    public void insertBefore(Node node, Node nodeToInsert) {
        // Write your code here.
        Node current = this.head;
        if (current == null) {
            head = nodeToInsert;
            return;
        }

        while (current.next != null) {
            if (current.value == node.value) {
                if (current.prev == null) {
                    // insert as first element
                    nodeToInsert.next = current;
                    current.prev = nodeToInsert;
                    return;
                }
                current.prev.next = nodeToInsert;
                nodeToInsert.prev = current.prev;
                current.prev = nodeToInsert;
                nodeToInsert.next = current;

            }
            current = current.next;
        }
    }

    public void insertAfter(Node node, Node nodeToInsert) {
        // Write your code here.
        Node current = this.head;
        if (current == null) {
            head = nodeToInsert;
            return;
        }

        while (current.next != null) {
            if (current.value == node.value) {
                if (current.next == null) {
                    // insert as last element
                    current.next = nodeToInsert;
                    nodeToInsert.prev = current;
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
        int counter = 0;

        while (current.next != null && counter < position) {
            counter++;
            current = current.next;
        }

        if (counter < position) {
            // insert as last element
            current.next = nodeToInsert;
            nodeToInsert.prev = current;
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
                    return;
                }
                if (current.prev == null) {
                    // remove first element
                    current.next.prev = null;
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

