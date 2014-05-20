package perso.challenges.crackthecode.stacks;

import perso.challenges.crackthecode.structure.Stack;

/**
 * User: sennen
 * Date: 18/05/2014
 * Time: 12:27
 */
public class StackTestCase {
    static StackAssertion assertThat(Stack<Integer> stack) {
        return new StackAssertion(stack);
    }
}
