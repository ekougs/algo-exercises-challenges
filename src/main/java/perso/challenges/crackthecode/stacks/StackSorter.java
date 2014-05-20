package perso.challenges.crackthecode.stacks;

import com.google.common.collect.Ordering;
import perso.challenges.crackthecode.structure.LinkedListStack;
import perso.challenges.crackthecode.structure.Stack;

/**
 * User: sennen
 * Date: 18/05/2014
 * Time: 12:18
 */
public class StackSorter<T extends Comparable<T>> {
    public Stack<T> sort(Stack<T> stack) {
        Stack<T> tempStack = new LinkedListStack<>();
        while (!stack.isEmpty()) {
            T element = stack.poll();
            while(!tempStack.isEmpty() && Ordering.natural().compare(tempStack.peek(), element) < 0) {
                stack.offer(tempStack.poll());
            }
            tempStack.offer(element);
        }
        return tempStack;
    }
}
