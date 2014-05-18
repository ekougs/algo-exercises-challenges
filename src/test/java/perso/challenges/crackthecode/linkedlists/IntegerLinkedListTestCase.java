package perso.challenges.crackthecode.linkedlists;

import perso.challenges.crackthecode.structure.IntegerLinkedList;
import perso.challenges.crackthecode.structure.Node;

import java.util.Arrays;

import static junit.framework.Assert.assertEquals;

/**
 * User: sennen
 * Date: 03/05/2014
 * Time: 00:19
 */
public class IntegerLinkedListTestCase {
    static LinkedListAssertion assertThat(IntegerLinkedList integerLinkedList) {
        return new LinkedListAssertion(integerLinkedList);
    }

    static class LinkedListAssertion {
        private final IntegerLinkedList actualIntegerLinkedList;

        public LinkedListAssertion(IntegerLinkedList actualIntegerLinkedList) {
            this.actualIntegerLinkedList = actualIntegerLinkedList;
        }

        public void elementsEqual(int... expectedElements) {
            assertEquals(getMessage(expectedElements), expectedElements.length, actualIntegerLinkedList.size());
            int index = 0;
            for (Integer data : actualIntegerLinkedList) {
                assertEquals(getMessage(expectedElements), expectedElements[index], data.intValue());
                index++;
            }
        }

        private String getMessage(int[] expectedElements) {
            return "Actual : " + actualIntegerLinkedList.toString() + " ; Expected : " + Arrays.toString(expectedElements);
        }

        public void headEquals(int data) {
            assertEquals(actualIntegerLinkedList.head(), new Node<Integer>(data));
        }
    }
}
