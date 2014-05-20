package perso.challenges.crackthecode.linkedlists;

import perso.challenges.crackthecode.structure.IntegerLinkedList;
import perso.challenges.crackthecode.structure.Node;

import java.util.HashSet;

/**
 * User: sennen
 * Date: 02/05/2014
 * Time: 23:08
 */
public class LinkedLists {
    public static IntegerLinkedList removeDuplicates(IntegerLinkedList integerLinkedList) {
        HashSet<Node<Integer>> uniqueNodes = new HashSet<>();
        Node<Integer> node = integerLinkedList.head();
        Node<Integer> previousNode = null;

        while (node != null) {
            if (!uniqueNodes.add(node)) {
                integerLinkedList.removeNext(previousNode);
            } else {
                previousNode = node;
            }
            node = node.next();
        }
        return integerLinkedList;
    }

    public static IntegerLinkedList removeDuplicatesInPlace(IntegerLinkedList integerLinkedList) {
        Node<Integer> head = integerLinkedList.head();
        Node<Integer> node = head;
        Node<Integer> previousNode = null;
        int position = 0;
        while (node != null) {
            Node<Integer> iterator = head;
            int positionToCompareWith = 0;
            while (!iterator.equals(node)) {
                iterator = iterator.next();
                positionToCompareWith++;
            }
            if (positionToCompareWith < position) {
                integerLinkedList.removeNext(previousNode);
                position--;
            } else {
                previousNode = node;
            }
            node = node.next();
            position++;
        }
        return integerLinkedList;
    }

    public static Node<Integer> getNthToLastElement(IntegerLinkedList integerLinkedList, int n) {
        Node<Integer> node = integerLinkedList.head();
        Node<Integer> cursor = integerLinkedList.head();
        int count = 0;
        while (cursor.next() != null) {
            if (count >= n) {
                node = node.next();
            }
            cursor = cursor.next();
            count++;
        }

        return node;
    }

    public static void removeMiddleElement(IntegerLinkedList integerLinkedList) {
        Node<Integer> previousCursorSingle = null;
        Node<Integer> cursorSingle = integerLinkedList.head();
        Node<Integer> cursorDouble = integerLinkedList.head();
        while (cursorDouble.next() != null) {
            previousCursorSingle = cursorSingle;
            cursorSingle = cursorSingle.next();
            cursorDouble = cursorDouble.next().next();
        }
        integerLinkedList.removeNext(previousCursorSingle);
    }

    public static IntegerLinkedList sum(IntegerLinkedList integerLinkedList1, IntegerLinkedList integerLinkedList2) {
        Node<Integer> node1 = integerLinkedList1.head();
        Node<Integer> node2 = integerLinkedList2.head();
        boolean get1 = node1 != null;
        boolean get2 = node2 != null;
        IntegerLinkedList sum = null;
        int remainder = 0;
        boolean calculate = get1 || get2;
        while (calculate) {
            int currentSum = remainder;
            if (get1) {
                currentSum += node1.value();
            }
            if (get2) {
                currentSum += node2.value();
            }
            int sumDigit = currentSum % 10;
            if (sum == null) {
                sum = new IntegerLinkedList(sumDigit);
            } else {
                sum.append(sumDigit);
            }
            remainder = currentSum / 10;
            node1 = get1 ? node1.next() : null;
            node2 = get2 ? node2.next() : null;
            get1 = node1 != null;
            get2 = node2 != null;
            calculate = get1 || get2 || remainder > 0;
        }
        return sum;
    }

    public static Node<Integer> getLoopingElement(IntegerLinkedList integerLinkedList) {
        Node<Integer> node = integerLinkedList.head();
        Node<Integer> doubleSpeedNode = integerLinkedList.head();
        //On cherche un point de rendez-vous
        while (doubleSpeedNode.next() != null) {
            node = node.next();
            doubleSpeedNode = doubleSpeedNode.next().next();
            if (node.equals(doubleSpeedNode)) {
                // Lorsqu'il est atteint, la tete est aussi pres du noeud de cycle que le doubleSpeedNode
                break;
            }
        }
        if (doubleSpeedNode.next() == null) {
            return null;
        }
        node = integerLinkedList.head();
        while(!node.equals(doubleSpeedNode)) {
            // Les deux noeuds avancent a la meme vitesse et se rejoignent au noeud du cycle
            node = node.next();
            doubleSpeedNode = doubleSpeedNode.next();
        }
        return doubleSpeedNode;
    }
}
