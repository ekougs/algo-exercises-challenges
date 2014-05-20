package perso.challenges.crackthecode.recursion;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * User: sennen
 * Date: 18/05/2014
 * Time: 20:13
 */
public class FibonacciSolverTest {
    @Test
    public void testFibonacci0() throws Exception {
        assertEquals(FibonacciSolver.get(0), 0);
    }

    @Test
    public void testFibonacci1() throws Exception {
        assertEquals(FibonacciSolver.get(1), 1);
    }

    @Test
    public void testFibonacci2() throws Exception {
        assertEquals(FibonacciSolver.get(2), 1);
    }

    @Test
    public void testFibonacci4() throws Exception {
        assertEquals(FibonacciSolver.get(4), 3);
    }
}
