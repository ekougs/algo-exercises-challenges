package perso.challenges.crackthecode.linkedlists;

import org.junit.Test;
import perso.challenges.crackthecode.structure.IntegerLinkedList;
import perso.challenges.crackthecode.structure.Node;

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
        IntegerLinkedList integerLinkedList = new IntegerLinkedList(8);
        integerLinkedList.append(10);
        integerLinkedList.append(8);
        integerLinkedList.append(8);
        integerLinkedList.append(10);
        integerLinkedList.append(9);
        IntegerLinkedListTestCase.assertThat(LinkedLists.removeDuplicates(integerLinkedList)).elementsEqual(8, 10, 9);
    }

    @Test
    public void testRemoveDuplicatesInPlace() throws Exception {
        IntegerLinkedList integerLinkedList = new IntegerLinkedList(8);
        integerLinkedList.append(10);
        integerLinkedList.append(8);
        integerLinkedList.append(8);
        integerLinkedList.append(10);
        integerLinkedList.append(9);
        IntegerLinkedListTestCase.assertThat(LinkedLists.removeDuplicatesInPlace(integerLinkedList)).elementsEqual(8, 10, 9);
    }

    @Test
    public void testFindNthToLastElement() throws Exception {
        IntegerLinkedList integerLinkedList = new IntegerLinkedList(8);
        integerLinkedList.append(10);
        integerLinkedList.append(8);
        integerLinkedList.append(8);
        integerLinkedList.append(10);
        integerLinkedList.append(11);
        integerLinkedList.append(9);
        assertEquals(11, LinkedLists.getNthToLastElement(integerLinkedList, 1).value().intValue());
    }

    @Test
    public void testRemoveMiddle() throws Exception {
        IntegerLinkedList integerLinkedList = new IntegerLinkedList(1);
        integerLinkedList.append(2);
        integerLinkedList.append(3);
        integerLinkedList.append(4);
        integerLinkedList.append(5);
        LinkedLists.removeMiddleElement(integerLinkedList);
        IntegerLinkedListTestCase.assertThat(integerLinkedList).elementsEqual(1, 2, 4, 5);
    }


    @Test
    public void testSum() throws Exception {
        IntegerLinkedList integerLinkedList1 = new IntegerLinkedList(3);
        integerLinkedList1.append(1);
        integerLinkedList1.append(5);
        IntegerLinkedList integerLinkedList2 = new IntegerLinkedList(5);
        integerLinkedList2.append(9);
        integerLinkedList2.append(2);
        IntegerLinkedList sumIntegerLinkedList = LinkedLists.sum(integerLinkedList1, integerLinkedList2);
        IntegerLinkedListTestCase.assertThat(sumIntegerLinkedList).elementsEqual(8, 0, 8);

        integerLinkedList1 = new IntegerLinkedList(3);
        integerLinkedList1.append(1);
        integerLinkedList1.append(5);
        integerLinkedList2 = new IntegerLinkedList(5);
        integerLinkedList2.append(9);
        integerLinkedList2.append(5);
        sumIntegerLinkedList = LinkedLists.sum(integerLinkedList1, integerLinkedList2);
        IntegerLinkedListTestCase.assertThat(sumIntegerLinkedList).elementsEqual(8, 0, 1, 1);

        integerLinkedList1 = new IntegerLinkedList(3);
        integerLinkedList1.append(1);
        integerLinkedList2 = new IntegerLinkedList(5);
        integerLinkedList2.append(9);
        integerLinkedList2.append(5);
        sumIntegerLinkedList = LinkedLists.sum(integerLinkedList1, integerLinkedList2);
        IntegerLinkedListTestCase.assertThat(sumIntegerLinkedList).elementsEqual(8, 0, 6);
    }

    @Test
    public void testGetLoop() throws Exception {
        IntegerLinkedList integerLinkedList = new IntegerLinkedList(1);
        integerLinkedList.append(2);
        integerLinkedList.append(3);
        integerLinkedList.append(4);
        integerLinkedList.append(5);
        assertNull(LinkedLists.getLoopingElement(integerLinkedList));
        Node<Integer> node3 = integerLinkedList.head().next().next();
        Node<Integer> node5 = node3.next().next();
        Node<Integer> node6 = new Node<Integer>(6);
        node5.setNext(node6);
        node6.setNext(node3);
        assertEquals(3, LinkedLists.getLoopingElement(integerLinkedList).value().intValue());
    }
}
