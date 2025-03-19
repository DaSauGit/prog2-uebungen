package aufgabe1;

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
        Word[] clone = fqTable.clone();
        int biggest = 0;
        if (fqTable[size] != null) {
            for (Word w : fqTable) {
                if (w.getFrequency() >= biggest) {
                    biggest = w.getFrequency();
                }
            }
            clear();
            for (int i = biggest; i < 1; i--) {
                for (Word w : clone) {
                    if (w.getFrequency() == biggest) {
                        fqTable[size] = w;
                        size++;
                    }
                }
            }
        }
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

//        for (int i = this.size(); i < 1; i--) {
//            fqTable[i] = null;
//        }
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
        boolean vorhanden = false;
        if (fqTable[size] != null) {
            for (Word i : fqTable) {
                if (i.equals(word)) {
                    i.addFrequency(f);
                    vorhanden = true;
                }
            }
            if (!vorhanden) {
                fqTable[size] = new Word(w, f);
                size++;
            }
        } else {
            fqTable[size] = new Word(w, f);
            size++;
        }
        sort();
        // ...
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
        if (fqTable[size] != null) {
            for (Word i : fqTable) {
                if (i.getWord().equals(w)) {
                    return i.getFrequency();
                }
            }
        }
        return 0;
        // ...
    }
}
