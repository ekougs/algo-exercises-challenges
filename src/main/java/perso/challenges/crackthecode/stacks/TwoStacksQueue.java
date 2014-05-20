package perso.challenges.crackthecode.stacks;

import perso.challenges.crackthecode.structure.LinkedListStack;
import perso.challenges.crackthecode.structure.Queue;
import perso.challenges.crackthecode.structure.Stack;

/**
 * User: sennen
 * Date: 17/05/2014
 * Time: 17:57
 */
public class TwoStacksQueue<T> implements Queue<T> {
    private final Stack<T> inputStack = new LinkedListStack<>();
    private final Stack<T> outputStack = new LinkedListStack<>();

    @Override
    public T peek() {
        putAllToOutput();
        return outputStack.peek();
    }

    @Override
    public T poll() {
        putAllToOutput();
        return outputStack.poll();
    }

    @Override
    public void offer(T element) {
        putAllToInput();
        inputStack.offer(element);
    }

    @Override
    public boolean isEmpty() {
        return inputStack.isEmpty() && outputStack.isEmpty();
    }

    private void putAllToOutput() {
        while (!inputStack.isEmpty()) {
            outputStack.offer(inputStack.poll());
        }
    }

    private void putAllToInput() {
        while (!outputStack.isEmpty()) {
            inputStack.offer(outputStack.poll());
        }
    }
}
