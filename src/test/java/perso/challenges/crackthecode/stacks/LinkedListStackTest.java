package perso.challenges.crackthecode.stacks;

import org.junit.Test;
import perso.challenges.crackthecode.structure.LinkedListStack;

import static junit.framework.Assert.*;

/**
 * User: sennen
 * Date: 15/05/2014
 * Time: 20:09
 */
public class LinkedListStackTest {
    @Test
    public void testPeek() throws Exception {
        LinkedListStack<Integer> stack = new LinkedListStack<Integer>(1);
        assertEquals(1, stack.peek().intValue());
        assertEquals(1, stack.peek().intValue());
        stack.offer(3);
        assertEquals(3, stack.peek().intValue());
    }

    @Test
    public void testPoll() throws Exception {
        LinkedListStack<Integer> stack = new LinkedListStack<Integer>(1);
        stack.offer(3);
        assertEquals(3, stack.poll().intValue());
        assertEquals(1, stack.poll().intValue());
        assertNull(stack.poll());
        assertNull(stack.poll());
    }

    @Test
    public void testIsEmpty() throws Exception {
        LinkedListStack<Integer> stack = new LinkedListStack<Integer>(1);
        stack.peek();
        assertFalse(stack.isEmpty());
        stack.poll();
        assertTrue(stack.isEmpty());
    }
}
