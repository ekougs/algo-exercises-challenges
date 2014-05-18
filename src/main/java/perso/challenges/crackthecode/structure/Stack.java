package perso.challenges.crackthecode.structure;

/**
 * User: sennen
 * Date: 15/05/2014
 * Time: 19:59
 */
public interface Stack<T> {
    T peek();

    T poll();

    void offer(T element);

    boolean isEmpty();
}
