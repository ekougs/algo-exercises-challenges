package perso.challenges.crackthecode.stacks;

import org.junit.Test;
import perso.challenges.crackthecode.structure.Stack;

import static perso.challenges.crackthecode.stacks.StackTestCase.assertThat;

/**
 * User: sennen
 * Date: 16/05/2014
 * Time: 06:48
 */
public class HanoiTowerSolverTest {
    @Test
    public void testResolutionWith4Disks() throws Exception {
        Stack<Integer> finalStack = HanoiTowerSolver.solve(4);
        assertThat(finalStack).hasTheseElementsInSameOrder(1, 2, 3, 4);
    }

    @Test
    public void testResolutionWith5Disks() throws Exception {
        Stack<Integer> finalStack = HanoiTowerSolver.solve(5);
        assertThat(finalStack).hasTheseElementsInSameOrder(1, 2, 3, 4, 5);
    }

}
