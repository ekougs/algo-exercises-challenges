package perso.challenges.crackthecode.linkedlists;

import java.util.HashSet;

/**
 * User: sennen
 * Date: 02/05/2014
 * Time: 23:08
 */
public class LinkedLists {
    public static LinkedList removeDuplicates(LinkedList linkedList) {
        HashSet<LinkedList.Node> uniqueNodes = new HashSet<LinkedList.Node>();
        LinkedList.Node node = linkedList.head();
        LinkedList.Node previousNode = null;

        while (node != null) {
            if (!uniqueNodes.add(node)) {
                linkedList.removeNext(previousNode);
            } else {
                previousNode = node;
            }
            node = node.next();
        }
        return linkedList;
    }

    public static LinkedList removeDuplicatesInPlace(LinkedList linkedList) {
        LinkedList.Node head = linkedList.head();
        LinkedList.Node node = head;
        LinkedList.Node previousNode = null;
        int position = 0;
        while (node != null) {
            LinkedList.Node iterator = head;
            int positionToCompareWith = 0;
            while (!iterator.equals(node)) {
                iterator = iterator.next();
                positionToCompareWith++;
            }
            if (positionToCompareWith < position) {
                linkedList.removeNext(previousNode);
                position--;
            } else {
                previousNode = node;
            }
            node = node.next();
            position++;
        }
        return linkedList;
    }

    public static LinkedList.Node getNthToLastElement(LinkedList linkedList, int n) {
        LinkedList.Node node = linkedList.head();
        LinkedList.Node cursor = linkedList.head();
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

    public static void removeMiddleElement(LinkedList linkedList) {
        LinkedList.Node previousCursorSingle = null;
        LinkedList.Node cursorSingle = linkedList.head();
        LinkedList.Node cursorDouble = linkedList.head();
        while (cursorDouble.next() != null) {
            previousCursorSingle = cursorSingle;
            cursorSingle = cursorSingle.next();
            cursorDouble = cursorDouble.next().next();
        }
        linkedList.removeNext(previousCursorSingle);
    }

    public static LinkedList sum(LinkedList linkedList1, LinkedList linkedList2) {
        LinkedList.Node node1 = linkedList1.head();
        LinkedList.Node node2 = linkedList2.head();
        boolean get1 = node1 != null;
        boolean get2 = node2 != null;
        LinkedList sum = null;
        int remainder = 0;
        boolean calculate = get1 || get2;
        while (calculate) {
            int currentSum = remainder;
            if (get1) {
                currentSum += node1.getData();
            }
            if (get2) {
                currentSum += node2.getData();
            }
            int sumDigit = currentSum % 10;
            if (sum == null) {
                sum = new LinkedList(sumDigit);
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

    public static LinkedList.Node getLoopingElement(LinkedList linkedList) {
        LinkedList.Node node = linkedList.head();
        LinkedList.Node doubleSpeedNode = linkedList.head();
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
        node = linkedList.head();
        while(!node.equals(doubleSpeedNode)) {
            // Les deux noeuds avancent a la meme vitesse et se rejoignent au noeud du cycle
            node = node.next();
            doubleSpeedNode = doubleSpeedNode.next();
        }
        return doubleSpeedNode;
    }
}
