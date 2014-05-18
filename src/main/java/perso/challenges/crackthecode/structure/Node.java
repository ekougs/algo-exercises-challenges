package perso.challenges.crackthecode.structure;

/**
 * User: sennen
 * Date: 15/05/2014
 * Time: 20:01
 */
public class Node<T> {
    private final T value;
    private Node<T> next;

    public Node(T value) {
        this.value = value;
    }


    public T value() {
        return value;
    }

    public Node<T> next() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
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

        return !(value != null ? !value.equals(node.value) : node.value != null);

    }

    @Override
    public int hashCode() {
        return value != null ? value.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
}
