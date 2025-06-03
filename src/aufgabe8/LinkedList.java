package aufgabe8;

/**
 *
 * @author Daniel Sauer
 */


public class LinkedList {
    private static class Node {
        int value;
        Node next;

        Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    private Node head;
    private int size;

    public LinkedList() {
        head = null;
        size = 0;
    }

    public LinkedList add(int value) {
        head = new Node(value, head);
        size++;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("{");
        Node p = head;
        boolean firstElement = true;
        while (p != null) {
            if (!firstElement)
                builder.append(", ");
            else
                firstElement = false;
            builder.append(p.value);
            p = p.next;
        }
        builder.append("}, size = " + size);
        return builder.toString();
    }

    public LinkedList mergeSort() {
        Node end = head;
        while (end.next != null) {
            end = end.next;
        }
        LinkedList result = mergeSort(head, end);
        this.head = result.head;
        this.size = result.size;

        return this;
    }

    private static LinkedList mergeSort(Node li, Node re) {
        if (li == re) {
            LinkedList b = new LinkedList();
            b.add(li.value);
            return b;
        }

        Node mid = li;
        Node end = li;
        while (end != re && end.next != re) {
            mid = mid.next;
            end = end.next.next;
        }

        LinkedList links = mergeSort(li, mid);
        LinkedList rechts = mergeSort(mid.next, re);

        return merge(links, rechts);
    }

    private static LinkedList merge(LinkedList a, LinkedList b) {
        LinkedList c = new LinkedList();

        Node aNode = a.head;
        Node bNode = b.head;
        Node tail = null;
        int count = 0;

        if (aNode != null && bNode != null) {
            if (aNode.value <= bNode.value) {
                c.head = new Node(aNode.value, null);
                aNode = aNode.next;
            } else {
                c.head = new Node(bNode.value, null);
                bNode = bNode.next;
            }
            tail = c.head;
            count = 1;
        }

        while (aNode != null && bNode != null) {
            if (aNode.value <= bNode.value) {
                tail.next = new Node(aNode.value, null);
                aNode = aNode.next;
            } else {
                tail.next = new Node(bNode.value, null);
                bNode = bNode.next;
            }
            tail = tail.next;
            count++;
        }

        while (aNode != null) {
            if (tail == null) {
                c.head = new Node(aNode.value, null);
                tail = c.head;
            } else {
                tail.next = new Node(aNode.value, null);
                tail = tail.next;
            }
            aNode = aNode.next;
            count++;
        }

        while (bNode != null) {
            if (tail == null) {
                c.head = new Node(bNode.value, null);
                tail = c.head;
            } else {
                tail.next = new Node(bNode.value, null);
                tail = tail.next;
            }
            bNode = bNode.next;
            count++;
        }

        c.size = count;
        return c;
    }


}