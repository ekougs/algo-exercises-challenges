package perso.challenges.crackthecode.stacks;

import org.junit.Test;
import perso.challenges.crackthecode.structure.LinkedListStack;
import perso.challenges.crackthecode.structure.Stack;

import static perso.challenges.crackthecode.stacks.StackTestCase.assertThat;

/**
 * User: sennen
 * Date: 18/05/2014
 * Time: 12:19
 */
public class StackSorterTest {
    @Test
    public void testSort() throws Exception {
        Stack<Integer> stack = new LinkedListStack<>();
        stack.offer(7);
        stack.offer(20);
        stack.offer(12);
        stack.offer(18);
        stack.offer(5);
        stack.offer(10);
        StackSorter<Integer> stackSorter = new StackSorter<>();
        assertThat(stackSorter.sort(stack)).hasTheseElementsInSameOrder(5, 7, 10, 12, 18, 20);
    }
}
