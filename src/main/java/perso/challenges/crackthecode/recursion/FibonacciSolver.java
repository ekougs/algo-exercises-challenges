package perso.challenges.crackthecode.recursion;

/**
 * User: sennen
 * Date: 18/05/2014
 * Time: 20:12
 */
public class FibonacciSolver {
    public static int get(int n) {
        if(n == 0) {
            return 0;
        }
        if(n == 1) {
            return 1;
        }
        return get(n - 2) + get(n - 1);
    }
}
