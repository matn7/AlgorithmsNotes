package medium;

public class DoublyLinkedList2 {

    public static void main(String[] args) {
        DoublyLinkedList ddl = new DoublyLinkedList();

        ddl.setHead(new Node(1));
        ddl.insertAfter(new Node(1), new Node(2));
        ddl.insertAfter(new Node(2), new Node(3));
        ddl.insertAfter(new Node(3), new Node(4));
        ddl.insertAfter(new Node(4), new Node(5));
        ddl.insertAfter(new Node(5), new Node(6));
        ddl.insertAfter(new Node(6), new Node(7));

        ddl.insertAtPosition(7, new Node(1));
        traverse(ddl.head);

        ddl.insertAtPosition(1, new Node(1));
        traverse(ddl.head);

        ddl.insertAtPosition(2, new Node(1));
        traverse(ddl.head);

        ddl.insertAtPosition(3, new Node(1));
        traverse(ddl.head);

        ddl.insertAtPosition(4, new Node(1));
        traverse(ddl.head);

//        Node node = new Node(1);
//        node.prev = null;
//        node.next = new Node(2);
//        node.next.prev = node;
//        node.next.next = new Node(3);
//        node.next.next.prev = node.next;
//        node.next.next.next = new Node(4);
//        node.next.next.next.prev = node.next.next;
//        node.next.next.next.next = new Node(5);
//        node.next.next.next.next.prev = node.next.next.next;
//        node.next.next.next.next.next = null;
//
//        traverse(node);
//
//        DoublyLinkedList ddl = new DoublyLinkedList();
//        ddl.head = node;
//
//        ddl.setHead(node.next.next.next);
//        ddl.setTail(new Node(6));
//
//        ddl.insertBefore(ddl.tail, new Node(3));
//        ddl.insertAfter(ddl.tail, new Node(3));
//        ddl.insertAtPosition(1, new Node(3));
//
//        traverse(ddl.head);
//
//        ddl.removeNodesWithValue(3);
//
//        traverse(ddl.head);
//
//        ddl.remove(node.next);
//
//        traverse(ddl.head);
//
//        boolean containsNodeWithValue = ddl.containsNodeWithValue(5);
//        System.out.println(containsNodeWithValue);
    }

    public static void traverse(Node node) {
        Node current = node;
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println();
    }

    static class DoublyLinkedList {
        public Node head;
        public Node tail;

        public void setHead(Node node) {
            if (head == null) {
                head = node;
                tail = head;
            } else {
                // Write your code here.
                Node current = head;
                while (current != null) {
                    if (current.equals(node)) {
                        // change pointers
                        if (current.equals(tail)) {
                            current.prev.next = null;
                            tail = current.prev;

                            current.next = head;
                            head.prev = current;
                            current.prev = null;
                            head = current;
                            return;
                        } else if (current.equals(head)) {
                            return;
                        } else {
                            current.prev.next = current.next;
                            current.next.prev = current.prev;
                            head.prev = current;
                            current.next = head;
                            current.prev = null;
                            head = current;
                            return;
                        }
                    }
                    current = current.next;
                }
                // not found append
                current = head;
                node.next = current;
                current.prev = node;
                head = node;
            }
        }
        public void setTail(Node node) {
            // Write your code here.
            if (head == null) {
                head = node;
                tail = head;
            } else if (head.prev == null && head.next == null) {
                // only one element
                head.next = node;
                node.prev = head;
                tail = node;
            } else {
                Node current = head;
                while (current.next != null) {
                    if (current.equals(node)) {
                        break;
                    }
                    current = current.next;
                }
                if (current != null && current.equals(head)) {
                    // setup new head
                    if (current.next != null) {
                        current.next.prev = null;
                        head = current.next;
                    }
                    tail.next = node;
                    node.prev = tail;
                    node.next = null;
                    tail = node;
                } else {
                    current.next = node;
                    node.prev = current;
                    node.next = null;
                    tail = node;
                }
            }
        }

        public void insertBefore(Node node, Node nodeToInsert) {
            // Write your code here.
            if (head == null) {
                head = nodeToInsert;
                return;
            }

            Node current = head;
            while (current.next != null) {
                if (current.equals(node)) {
                    break;
                }
                current = current.next;
            }
            if (current.prev == null) {
                // insert at tail
                current.prev = nodeToInsert;
                nodeToInsert.next = current;
                nodeToInsert.prev = null;
                head = nodeToInsert;
            } else {
                // insert in between
                if (nodeToInsert.next != null && nodeToInsert.prev != null) {
                    nodeToInsert.next.prev = nodeToInsert.prev;
                    nodeToInsert.prev.next = nodeToInsert.next;
                }
                if (nodeToInsert.value == tail.value) {
                    tail = current;
                    current.next = null;
                }
                nodeToInsert.next = current;
                nodeToInsert.prev = current.prev;
                current.prev.next = nodeToInsert;
                current.prev = nodeToInsert;
            }
        }

        public void insertAfter(Node node, Node nodeToInsert) {
            // Write your code here.
            if (head == null) {
                head = nodeToInsert;
                return;
            }

            Node current = head;
            while (current.next != null) {
                if (current.equals(node)) {
                    break;
                }
                current = current.next;
            }
            if (current.next == null) {
                // insert at tail
                current.next = nodeToInsert;
                nodeToInsert.prev = current;
                nodeToInsert.next = null;
                tail = nodeToInsert;
            } else {
                // insert in between
                if (nodeToInsert.value == head.value) {
                    head = current;
                    current.prev = null;
                }
                nodeToInsert.prev = current;
                nodeToInsert.next = current.next;
                current.next.prev = nodeToInsert;
                current.next = nodeToInsert;
            }
        }

        public void insertAtPosition(int position, Node nodeToInsert) {
            // Write your code here.
            if (head == null) {
                head = nodeToInsert;
                tail = nodeToInsert;
                return;
            }
            if (position == 1) {
                setHead(nodeToInsert);
                return;
            }

            Node current = head;
            while (current != null) {
                if (current.value == position) {
                    break;
                }
                current = current.next;
            }

            Node ntiCurrent = head;
            while (ntiCurrent != null) {
                if (ntiCurrent.value == nodeToInsert.value) {
                    break;
                }
                ntiCurrent = ntiCurrent.next;
            }

            if (ntiCurrent != null && current != null) {
                // node right next to each other
                if (ntiCurrent.next.equals(current)) {
                    return;
                }

                if (ntiCurrent.equals(head)) {
                    if (ntiCurrent.next != null) {
                        ntiCurrent.next.prev = null;
                        head = ntiCurrent.next;
                    }
                }
                if (current.equals(tail)) {
                    if (current.prev != null) {
                        ntiCurrent.next = current;
                        ntiCurrent.prev = current.prev;
                        current.prev.next = ntiCurrent;
                        current.prev = ntiCurrent;
                    }
                } else {
                    // in-between
                    if (ntiCurrent.next != null && ntiCurrent.prev != null) {
                        ntiCurrent.next.prev = ntiCurrent.prev;
                        ntiCurrent.prev.next = ntiCurrent.next;
                    }
                    if (current.next != null && current.prev != null) {
                        ntiCurrent.next = current;
                        ntiCurrent.prev = current.prev;
                        current.prev.next = ntiCurrent;
                        current.prev = ntiCurrent;
                    }
                }
            }

        }

        public void removeNodesWithValue(int value) {
            // Write your code here.
            if (head == null) {
                return;
            }
            Node current = head;
            while (current != null) {
                if (current.value == value) {
                    // remove
                    if (current.next == null && current.prev == null) {
                        head = null;
                    } else if (current.prev == null) {
                        // remove head
                        current.next.prev = null;
                        head = current.next;
                    } else if (current.next == null) {
                        // remove tail
                        current.prev.next = null;
                        tail = current.prev;
                    } else {
                        // remove in-between
                        current.prev.next = current.next;
                        current.next.prev = current.prev;
                    }
                }
                current = current.next;
            }
        }

        public void remove(Node node) {
            // Write your code here.
            Node current = head;
            while (current != null) {
                if (current.value == node.value) {
                    // remove
                    if (current.next == null && current.prev == null) {
                        head = null;
                    } else if (current.prev == null) {
                        // remove head
                        current.next.prev = null;
                        head = current.next;
                    } else if (current.next == null) {
                        // remove tail
                        current.prev.next = null;
                        tail = current.prev;
                    } else {
                        // remove in-between
                        current.prev.next = current.next;
                        current.next.prev = current.prev;
                    }
                    break;
                }
                current = current.next;
            }
        }

        public boolean containsNodeWithValue(int value) {
            // Write your code here.
            Node current = head;
            while (current != null) {
                if (current.value == value) {
                    return true;
                }
                current = current.next;
            }
            return false;
        }
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
