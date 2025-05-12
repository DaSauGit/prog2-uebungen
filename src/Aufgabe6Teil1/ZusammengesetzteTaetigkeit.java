package Aufgabe6Teil1;

import java.util.ArrayList;
import java.util.List;

public abstract class ZusammengesetzteTaetigkeit implements Taetigkeit{
    List<Taetigkeit> meineTaetigkeiten = new ArrayList<>();

    @Override
    public double getTime() {
        return 0;
    }

    @Override
    public void add(Taetigkeit t) {
        meineTaetigkeiten.add(t);
    }

    @Override
    public void remove(Taetigkeit t) {
        meineTaetigkeiten.remove(t);
    }

    @Override
    public int getAnzahl() {
        int anzahl = meineTaetigkeiten.size();
        for (Taetigkeit t : meineTaetigkeiten) {
            if (t instanceof ParalleleTaetigkeit) {
                anzahl += t.getAnzahl();
                anzahl--;
            }
        }
        return anzahl;
    }

    @Override
    public String toString() {
        return null;
    }
}
