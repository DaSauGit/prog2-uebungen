package aufgabe2;

import aufgabe1.AbstractFrequencyTable;
import aufgabe1.Word;

public class LinkedListFrequencyTable extends AbstractFrequencyTable {
    private int size = 0;
    private Word[] fqTable;
    private Node begin;
    private Node end;

    public LinkedListFrequencyTable() {
        clear();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        size = 0;
        begin = new Node(null, null, null);
        end = new Node(null, null, begin);
        begin.next = end;
    }

    @Override
    public void add(String w, int f) {
        Word word = new Word(w, f);
        Node p = begin.next;
        //wort schon vorhanden
        while (p != end) {
            if (w.equals(p.data.getWord())) {
                p.data.addFrequency(f);
                moveLeft(p);
                return;
            }
            p = p.next;
        }
        //Wort neu
        Node r = new Node(word, end, end.prev);
        r.prev.next = r;
        p.prev = r;
        moveLeft(r);
        size++;
    }

    private void moveLeft(Node n) {
        while (n.prev != begin && n.data.getFrequency() > n.prev.data.getFrequency()) {
            // Knoten mit dem vorherigen Knoten tauschen
            Node prev = n.prev;
            Node next = n.next;

            prev.next = next;
            next.prev = prev;

            n.prev = prev.prev;
            n.next = prev;

            if (prev.prev != null) {
                prev.prev.next = n;
            }
            prev.prev = n;
        }
    }

    @Override
    public Word get(int pos) {
        Node t = begin.next;
        for (int i = 0; i < pos; i++) {
            t = t.next;
        }
        return t.data;
    }

    @Override
    public int get(String w) {
        Node p = begin.next;
        for (int i = 0; i < size; i++) {
            if (w.equals(p.data.getWord())) {
                return p.data.getFrequency();
            }
            p = p.next;
        }
        return 0;
    }

    private static class Node {
        Node next;
        Node prev;
        Word data;

        Node(Word x, Node n, Node p) {
            data = x;
            prev = p;
            next = n;
        }
    }
}
