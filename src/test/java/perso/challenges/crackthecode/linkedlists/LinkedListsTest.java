package perso.challenges.crackthecode.linkedlists;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNull;

/**
 * User: sennen
 * Date: 02/05/2014
 * Time: 23:08
 */
public class LinkedListsTest {
    @Test
    public void testRemoveDuplicates() throws Exception {
        LinkedList linkedList = new LinkedList(8);
        linkedList.append(10);
        linkedList.append(8);
        linkedList.append(8);
        linkedList.append(10);
        linkedList.append(9);
        LinkedListTestCase.assertThat(LinkedLists.removeDuplicates(linkedList)).elementsEqual(8, 10, 9);
    }

    @Test
    public void testRemoveDuplicatesInPlace() throws Exception {
        LinkedList linkedList = new LinkedList(8);
        linkedList.append(10);
        linkedList.append(8);
        linkedList.append(8);
        linkedList.append(10);
        linkedList.append(9);
        LinkedListTestCase.assertThat(LinkedLists.removeDuplicatesInPlace(linkedList)).elementsEqual(8, 10, 9);
    }

    @Test
    public void testFindNthToLastElement() throws Exception {
        LinkedList linkedList = new LinkedList(8);
        linkedList.append(10);
        linkedList.append(8);
        linkedList.append(8);
        linkedList.append(10);
        linkedList.append(11);
        linkedList.append(9);
        assertEquals(11, LinkedLists.getNthToLastElement(linkedList, 1).getData());
    }

    @Test
    public void testRemoveMiddle() throws Exception {
        LinkedList linkedList = new LinkedList(1);
        linkedList.append(2);
        linkedList.append(3);
        linkedList.append(4);
        linkedList.append(5);
        LinkedLists.removeMiddleElement(linkedList);
        LinkedListTestCase.assertThat(linkedList).elementsEqual(1, 2, 4, 5);
    }


    @Test
    public void testSum() throws Exception {
        LinkedList linkedList1 = new LinkedList(3);
        linkedList1.append(1);
        linkedList1.append(5);
        LinkedList linkedList2 = new LinkedList(5);
        linkedList2.append(9);
        linkedList2.append(2);
        LinkedList sumLinkedList = LinkedLists.sum(linkedList1, linkedList2);
        LinkedListTestCase.assertThat(sumLinkedList).elementsEqual(8, 0, 8);

        linkedList1 = new LinkedList(3);
        linkedList1.append(1);
        linkedList1.append(5);
        linkedList2 = new LinkedList(5);
        linkedList2.append(9);
        linkedList2.append(5);
        sumLinkedList = LinkedLists.sum(linkedList1, linkedList2);
        LinkedListTestCase.assertThat(sumLinkedList).elementsEqual(8, 0, 1, 1);

        linkedList1 = new LinkedList(3);
        linkedList1.append(1);
        linkedList2 = new LinkedList(5);
        linkedList2.append(9);
        linkedList2.append(5);
        sumLinkedList = LinkedLists.sum(linkedList1, linkedList2);
        LinkedListTestCase.assertThat(sumLinkedList).elementsEqual(8, 0, 6);
    }

    @Test
    public void testGetLoop() throws Exception {
        LinkedList linkedList = new LinkedList(1);
        linkedList.append(2);
        linkedList.append(3);
        linkedList.append(4);
        linkedList.append(5);
        assertNull(LinkedLists.getLoopingElement(linkedList));
        LinkedList.Node node3 = linkedList.head().next().next();
        LinkedList.Node node5 = node3.next().next();
        LinkedList.Node node6 = new LinkedList.Node(6);
        node5.setNext(node6);
        node6.setNext(node3);
        assertEquals(3, LinkedLists.getLoopingElement(linkedList).getData());
    }
}
