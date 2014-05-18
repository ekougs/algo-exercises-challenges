package perso.challenges.crackthecode.structure;

/**
 * User: sennen
 * Date: 17/05/2014
 * Time: 17:56
 */
public interface Queue<T> {
    T peek();

    T poll();

    void offer(T element);

    boolean isEmpty();
}
