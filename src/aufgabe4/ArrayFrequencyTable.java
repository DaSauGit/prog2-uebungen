package aufgabe4;

import java.util.Arrays;

/**
 * @author oliverbittel
 * @author Oliver Haase
 */
public class ArrayFrequencyTable<T> extends AbstractFrequencyTable<T> {
    private final int DEFAULT_SIZE = 100;
    private int size = 0;
    private Element<T>[] fqTable;

    public ArrayFrequencyTable() {
        clear();
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
        fqTable = new Element[DEFAULT_SIZE];
        // ...
    }

    @Override
    public void add(T e, int f) {
        // throw muss auskommentiert werden!
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        // Ihr Code:
        Element<T> element = new Element<>(e, f);
        if (fqTable.length == size) {
            fqTable = Arrays.copyOf(fqTable, 2 * size);
        }
        boolean vorhanden = false;
        for (int i = 0; i < size; i++) {
            if (element.getElement().equals(fqTable[i].getElement())) {
                fqTable[i].addFrequency(element.getFrequency());
                moveToLeft(i);
                return;
            }
        }
        fqTable[size] = element;
        if (size != 0) {
            moveToLeft(size);
        }
        size++;
        // ...
    }

    private void moveToLeft(int pos) {
        Element<T> w = fqTable[pos];
        int i = pos - 1;
        while (i >= 0 && w.getFrequency() > fqTable[i].getFrequency()) {
            fqTable[i + 1] = fqTable[i];
            i--;
        }
        fqTable[i + 1] = w;

    }

    @Override
    public Element<T> get(int pos) {
        // throw muss auskommentiert werden!
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//         Ihr Code:
        return fqTable[pos];
        // ...
    }

    @Override
    public int get(T e) {
        // throw muss auskommentiert werden!
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        // Ihr Code:
        for (int i = 0; i < size; i++) {
            if (e.equals(fqTable[i].getElement())) {
                return fqTable[i].getFrequency();
            }
        }
        return 0;
        // ...
    }
}
