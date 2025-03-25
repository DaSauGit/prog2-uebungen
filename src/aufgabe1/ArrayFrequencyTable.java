package aufgabe1;

import java.util.Arrays;

/**
 * @author oliverbittel
 * @author Oliver Haase
 */
public class ArrayFrequencyTable extends AbstractFrequencyTable {
    private final int DEFAULT_SIZE = 100;
    private int size = 0;
    private Word[] fqTable;

    public ArrayFrequencyTable() {
        clear();
    }

    private void sort() {

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public final void clear() {
        // throw muss auskommentiert werden!
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        // Ihr Code:
        size = 0;
        fqTable = new Word[DEFAULT_SIZE];
        // ...
    }

    @Override
    public void add(String w, int f) {
        // throw muss auskommentiert werden!
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        // Ihr Code:
        Word word = new Word(w, f);
        if (fqTable.length == size) {
            fqTable = Arrays.copyOf(fqTable, 2 * size);
        }
        boolean vorhanden = false;
        for (int i = 0; i < size; i++) {
            if (word.getWord().equals(fqTable[i].getWord())) {
                fqTable[i].addFrequency(word.getFrequency());
                moveToLeft(i);
                vorhanden = true;
            }
        }
        if (!vorhanden) {
            fqTable[size] = word;
            if (size != 0) {
                moveToLeft(size);
            }
            size++;
        }
        // ...
    }

    private void moveToLeft(int pos) {
        Word w = fqTable[pos];
        int i = pos - 1;
        while (i >= 0 && w.getFrequency() > fqTable[i].getFrequency()) {
            fqTable[i + 1] = fqTable[i];
            i--;
        }
        fqTable[i + 1] = w;

    }

    @Override
    public Word get(int pos) {
        // throw muss auskommentiert werden!
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//         Ihr Code:
        Word w = fqTable[pos];
        return w;
        // ...
    }

    @Override
    public int get(String w) {
        // throw muss auskommentiert werden!
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        // Ihr Code:
        for (int i = 0; i < size; i++) {
            if (w.equals(fqTable[i].getWord())) {
                return fqTable[i].getFrequency();
            }
        }
        return 0;
        // ...
    }
}
