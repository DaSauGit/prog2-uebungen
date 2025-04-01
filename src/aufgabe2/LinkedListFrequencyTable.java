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
    }

    @Override
    public void add(String w, int f) {
        Word word = new Word(w, f);
        Node p = begin.next;
        while (p.next != null) {
            if (w.equals(p.data.getWord())) {
                p.data.addFrequency(f);
                moveLeft(p);
                return;
            }
            Node r = new Node(word, end, end.prev);
            r.prev.next = r;
            p.prev = r;
            moveLeft(p);
            size++;
        }
    }

    private void moveLeft(Node n) {
        int freq = n.data.getFrequency();
        while (n.prev.data.getFrequency() > freq) {
            n.data = n.prev.data;
        }
    }

    @Override
    public Word get(int pos) {
        return null;
    }

    @Override
    public int get(String w) {
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
