package perso.challenges.crackthecode.structure;

/**
 * User: sennen
 * Date: 15/05/2014
 * Time: 20:00
 */
public class LinkedListStack<T> implements Stack<T> {
    private Node<T> head;

    public LinkedListStack() {
    }

    public LinkedListStack(T firstElement) {
        this();
        head = new Node<>(firstElement);
    }

    @Override
    public T peek() {
        if(isEmpty()) {
            return null;
        }
        return head.value();
    }

    @Override
    public T poll() {
        if(isEmpty()) {
            return null;
        }
        T value = head.value();
        head = head.next();
        return value;
    }

    @Override
    public void offer(T element) {
        Node<T> newHead = new Node<>(element);
        if (isEmpty()) {
            head = newHead;
            return;
        }
        newHead.setNext(head);
        head = newHead;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }
}
