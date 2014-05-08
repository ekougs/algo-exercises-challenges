package perso.challenges.crackthecode.linkedlists;

import java.util.Iterator;

/**
 * User: sennen
 * Date: 02/05/2014
 * Time: 23:09
 */
public class LinkedList implements Iterable<Integer> {
    private Node head;
    private int size;

    public LinkedList(int data) {
        init(data);
    }

    public void append(int data) {
        if(head == null) {
            init(data);
            return;
        }
        Node node = head;
        while(node.next != null) {
            node = node.next;
        }
        node.next = new Node(data);
        size++;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder linkedListToString = new StringBuilder("LinkedList{");
        Node node = head;
        while(node != null) {
            linkedListToString.append(node.data).append(", ");
            node = node.next;
        }
        int length = linkedListToString.toString().length();
        linkedListToString.replace(length - 2, length, "}");
        return linkedListToString.toString();
    }

    private void init(int data) {
        head = new Node(data);
        size = 1;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new LinkedListIterator(head);
    }

    public Node head() {
        return head;
    }

    public void removeNext(Node node) {
        node.next = node.next.next;
        size--;
    }

    public static class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
        }

        public Node next() {
            return next;
        }

        void setNext(Node next) {
            this.next = next;
        }

        public int getData() {
            return data;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            Node node = (Node) o;
            return data == node.data;
        }

        @Override
        public int hashCode() {
            return data;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    '}';
        }
    }

    private static class LinkedListIterator implements Iterator<Integer> {
        private Node node;

        public LinkedListIterator(Node head) {
            this.node = head;
        }

        @Override
        public boolean hasNext() {
            return node != null;
        }

        @Override
        public Integer next() {
            Node next = node;
            node = node.next;
            return next.data;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
