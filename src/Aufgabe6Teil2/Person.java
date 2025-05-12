package Aufgabe6Teil2;

import java.util.LinkedList;
import java.util.List;

public class Person {
    private final String name;
    private final List<Buch> ausgelieheneBuecher = new LinkedList<Buch>();

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getAnzahlAusgelieheneBuecher() {
        return ausgelieheneBuecher.size();
    }

    public boolean leihtAus(Buch b) {
        if (ausgelieheneBuecher.contains(b)) {
            return false; // Hat Buch bereits
        }
        if (b.getEntleiher() != null && b.getEntleiher() != this) {
            return false; // Jemand anderes hat Buch
        }
        ausgelieheneBuecher.add(b);
        b.wirdAusgeliehen(this);
        return true;
    }

    public boolean gibtZurueck(Buch b) {
        if (!ausgelieheneBuecher.contains(b)) {
            return false; // Besitzt Buch nicht
        }
        ausgelieheneBuecher.remove(b);
        b.wirdZurueckGegeben();
        return true;
    }

    public void print() {
        System.out.printf("%s hat ausgeliehen: ", name);
        if (getAnzahlAusgelieheneBuecher() == 0) {
            System.out.printf("\n");
        }
        for (int i = 0; i < getAnzahlAusgelieheneBuecher(); i++) {
            if (i == getAnzahlAusgelieheneBuecher() - 1) {
                System.out.printf("%s\n", ausgelieheneBuecher.get(i).getName());
            } else {
                System.out.printf("%s, ", ausgelieheneBuecher.get(i).getName());
            }
        }
    }
}
