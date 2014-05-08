package perso.challenges.crackthecode.linkedlists;

import java.util.Arrays;

import static junit.framework.Assert.assertEquals;

/**
 * User: sennen
 * Date: 03/05/2014
 * Time: 00:19
 */
public class LinkedListTestCase {
    static LinkedListAssertion assertThat(LinkedList linkedList) {
        return new LinkedListAssertion(linkedList);
    }

    static class LinkedListAssertion {
        private final LinkedList actualLinkedList;

        public LinkedListAssertion(LinkedList actualLinkedList) {
            this.actualLinkedList = actualLinkedList;
        }

        public void elementsEqual(int... expectedElements) {
            assertEquals(getMessage(expectedElements), expectedElements.length, actualLinkedList.size());
            int index = 0;
            for (Integer data : actualLinkedList) {
                assertEquals(getMessage(expectedElements), expectedElements[index], data.intValue());
                index++;
            }
        }

        private String getMessage(int[] expectedElements) {
            return "Actual : " + actualLinkedList.toString() + " ; Expected : " + Arrays.toString(expectedElements);
        }

        public void headEquals(int data) {
            actualLinkedList.head().equals(new LinkedList.Node(data));
        }
    }
}
