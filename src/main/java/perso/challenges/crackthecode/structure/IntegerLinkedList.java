package perso.challenges.crackthecode.structure;

import java.util.Iterator;

/**
 * User: sennen
 * Date: 02/05/2014
 * Time: 23:09
 */
public class IntegerLinkedList implements Iterable<Integer> {
    private Node<Integer> head;
    private int size;

    public IntegerLinkedList(int data) {
        init(data);
    }

    public void append(int data) {
        if(head == null) {
            init(data);
            return;
        }
        Node<Integer> node = head;
        while(node.next() != null) {
            node = node.next();
        }
        node.setNext(new Node<Integer>(data));
        size++;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder linkedListToString = new StringBuilder("IntegerLinkedList{");
        Node node = head;
        while(node != null) {
            linkedListToString.append(node.value()).append(", ");
            node = node.next();
        }
        int length = linkedListToString.toString().length();
        linkedListToString.replace(length - 2, length, "}");
        return linkedListToString.toString();
    }

    private void init(int data) {
        head = new Node<Integer>(data);
        size = 1;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new LinkedListIterator(head);
    }

    public Node<Integer> head() {
        return head;
    }

    public void removeNext(Node node) {
        node.setNext(node.next().next());
        size--;
    }

//    public static class Node {
//        private int data;
//        private Node next;
//
//        public Node(int data) {
//            this.data = data;
//        }
//
//        public Node next() {
//            return next;
//        }
//
//        void setNext(Node next) {
//            this.next = next;
//        }
//
//        public int getData() {
//            return data;
//        }
//
//        @Override
//        public boolean equals(Object o) {
//            if (this == o) {
//                return true;
//            }
//            if (o == null || getClass() != o.getClass()) {
//                return false;
//            }
//
//            Node node = (Node) o;
//            return data == node.data;
//        }
//
//        @Override
//        public int hashCode() {
//            return data;
//        }
//
//        @Override
//        public String toString() {
//            return "Node{" +
//                    "data=" + data +
//                    '}';
//        }
//    }

    private static class LinkedListIterator implements Iterator<Integer> {
        private Node<Integer> node;

        public LinkedListIterator(Node<Integer> head) {
            this.node = head;
        }

        @Override
        public boolean hasNext() {
            return node != null;
        }

        @Override
        public Integer next() {
            Node<Integer> next = node;
            node = node.next();
            return next.value();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
