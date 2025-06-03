package aufgabe8;

/**
 *
 * @author Daniel Sauer
 */


public class LinkedList {
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

    private static class Node {
        int value;
        Node next;

        Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
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
        // Hier fehlt Ihr Code
        if (head == null || head.next == null) {
            return this; // Liste ist bereits sortiert
        }
        LinkedList b = new LinkedList();
        Node end = head;
        while (end.next != null) {
            end = end.next;
        }
        mergeSort(head, end, this, b);
        return this;
    }

    private LinkedList mergeSort(Node links, Node rechts, LinkedList a, LinkedList b) {
        if (links == rechts) {
            b.add(links.value);
            return b;
        }
        Node mid = links;
        Node end = links;
        while (end.next != rechts && end.next.next != rechts) {
            mid = mid.next;
            end = end.next.next;
        }
        LinkedList left = new LinkedList();
        LinkedList right = new LinkedList();

        left = mergeSort(links, mid, a, b);
        right = mergeSort(mid.next, rechts, a, b);

        return merge(left, right, b);
    }

    private static LinkedList merge(LinkedList a, LinkedList b, LinkedList c) {
        //in beiden was drinnen
        Node aNode = a.head;
        Node bNode = b.head;
        while (aNode != null && bNode != null) {
            if (aNode.value <= bNode.value) {
                c.add(aNode.value);
                aNode = aNode.next;
            } else {
                c.add(bNode.value);
                bNode = bNode.next;
            }
        }
        //in einem was drinnen, anderes leer
        if (aNode == null && bNode != null) {
            while (bNode != null) {
                c.add(bNode.value);
                bNode = bNode.next;
            }
        } else if (aNode != null && bNode == null) {
            while (aNode != null) {
                c.add(aNode.value);
                aNode = aNode.next;
            }
        }

        return c;
    }
}
