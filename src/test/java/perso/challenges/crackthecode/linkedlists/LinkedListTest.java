package perso.challenges.crackthecode.linkedlists;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static perso.challenges.crackthecode.linkedlists.LinkedListTestCase.assertThat;

/**
 * User: sennen
 * Date: 03/05/2014
 * Time: 00:17
 */
public class LinkedListTest {
    @Test
    public void testSize() throws Exception {
        LinkedList linkedList = new LinkedList(8);
        assertEquals(1, linkedList.size());
        linkedList.append(10);
        assertEquals(2, linkedList.size());
    }

    @Test
    public void testRemoveHead() throws Exception {
        LinkedList linkedList = new LinkedList(8);
        linkedList.append(10);
        assertThat(linkedList).headEquals(8);
    }

    @Test
    public void testRemoveNext() throws Exception {
        LinkedList linkedList = new LinkedList(8);
        assertEquals(1, linkedList.size());
        linkedList.append(10);
        assertEquals(2, linkedList.size());
        linkedList.removeNext(linkedList.head());
        assertEquals(1, linkedList.size());
        assertThat(linkedList).elementsEqual(8);
    }

    @Test
    public void testToString() throws Exception {
        LinkedList linkedList = new LinkedList(8);
        assertEquals("LinkedList{8}", linkedList.toString());
        linkedList.append(10);
        assertEquals("LinkedList{8, 10}", linkedList.toString());
    }
}
