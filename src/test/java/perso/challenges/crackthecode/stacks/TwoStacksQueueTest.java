package perso.challenges.crackthecode.stacks;

import org.junit.Test;
import perso.challenges.crackthecode.structure.Queue;

import static junit.framework.Assert.*;

/**
 * User: sennen
 * Date: 17/05/2014
 * Time: 18:01
 */
public class TwoStacksQueueTest {
    @Test
    public void testPeek() throws Exception {
        Queue<Integer> queue = new TwoStacksQueue<Integer>();
        queue.offer(1);
        assertEquals(1, queue.peek().intValue());
        assertEquals(1, queue.peek().intValue());
        queue.offer(3);
        assertEquals(1, queue.peek().intValue());
    }

    @Test
    public void testPoll() throws Exception {
        Queue<Integer> queue = new TwoStacksQueue<Integer>();
        queue.offer(1);
        queue.offer(3);
        assertEquals(1, queue.poll().intValue());
        assertEquals(3, queue.poll().intValue());
        assertNull(queue.poll());
        assertNull(queue.poll());
    }

    @Test
    public void testIsEmpty() throws Exception {
        Queue<Integer> queue = new TwoStacksQueue<Integer>();
        queue.offer(1);
        queue.peek();
        assertFalse(queue.isEmpty());
        queue.poll();
        assertTrue(queue.isEmpty());
    }
}
