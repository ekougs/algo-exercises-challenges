package perso.challenges.crackthecode.stacks;

import org.junit.Test;
import perso.challenges.crackthecode.structure.Stack;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

/**
 * User: sennen
 * Date: 16/05/2014
 * Time: 06:48
 */
public class HanoiTowerSolverTest {
    @Test
    public void testResolutionWith4Disks() throws Exception {
        Stack<Integer> finalStack = HanoiTowerSolver.solve(4);
        assertThat(finalStack).hasThisOrderedElements(1, 2, 3, 4);
    }

    @Test
    public void testResolutionWith5Disks() throws Exception {
        Stack<Integer> finalStack = HanoiTowerSolver.solve(5);
        assertThat(finalStack).hasThisOrderedElements(1, 2, 3, 4, 5);
    }

    private StackAssertion assertThat(Stack<Integer> stack) {
        return new StackAssertion(stack);
    }

    private static class StackAssertion {
        private final Stack<Integer> stack;

        private StackAssertion(Stack<Integer> stack) {
            this.stack = stack;
        }

        private void hasThisOrderedElements(int... elements) {
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
}
