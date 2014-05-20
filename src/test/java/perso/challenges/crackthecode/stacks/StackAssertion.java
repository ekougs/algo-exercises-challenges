package perso.challenges.crackthecode.stacks;

import perso.challenges.crackthecode.structure.Stack;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

/**
* User: sennen
* Date: 18/05/2014
* Time: 12:21
*/
public class StackAssertion {
    private final Stack<Integer> stack;

    public StackAssertion(Stack<Integer> stack) {
        this.stack = stack;
    }

    public void hasTheseElementsInSameOrder(int... elements) {
        if (stack.isEmpty()) {
            assertEquals(0, elements.length);
            return;
        }
        int i = 0;
        while (!stack.isEmpty()) {
            assertTrue(i < elements.length);
            int element = stack.poll();
            assertEquals(elements[i], element);
            i++;
        }
        assertEquals(i, elements.length);
    }
}
