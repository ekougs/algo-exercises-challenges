package perso.challenges.crackthecode.linkedlists;

import org.junit.Test;
import perso.challenges.crackthecode.structure.IntegerLinkedList;

import static junit.framework.Assert.assertEquals;
import static perso.challenges.crackthecode.linkedlists.IntegerLinkedListTestCase.assertThat;

/**
 * User: sennen
 * Date: 03/05/2014
 * Time: 00:17
 */
public class IntegerLinkedListTest {
    @Test
    public void testSize() throws Exception {
        IntegerLinkedList integerLinkedList = new IntegerLinkedList(8);
        assertEquals(1, integerLinkedList.size());
        integerLinkedList.append(10);
        assertEquals(2, integerLinkedList.size());
    }

    @Test
    public void testRemoveHead() throws Exception {
        IntegerLinkedList integerLinkedList = new IntegerLinkedList(8);
        integerLinkedList.append(10);
        assertThat(integerLinkedList).headEquals(8);
    }

    @Test
    public void testRemoveNext() throws Exception {
        IntegerLinkedList integerLinkedList = new IntegerLinkedList(8);
        assertEquals(1, integerLinkedList.size());
        integerLinkedList.append(10);
        assertEquals(2, integerLinkedList.size());
        integerLinkedList.removeNext(integerLinkedList.head());
        assertEquals(1, integerLinkedList.size());
        assertThat(integerLinkedList).elementsEqual(8);
    }

    @Test
    public void testToString() throws Exception {
        IntegerLinkedList integerLinkedList = new IntegerLinkedList(8);
        assertEquals("IntegerLinkedList{8}", integerLinkedList.toString());
        integerLinkedList.append(10);
        assertEquals("IntegerLinkedList{8, 10}", integerLinkedList.toString());
    }
}
