package Aufgabe6Teil2;

public class Buch {
    private final String name;
    private Person entleiher;

    public Buch(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Person getEntleiher() {
        return entleiher;
    }

    public boolean wirdAusgeliehen(Person p) {
        if (entleiher != null) {
            return false; // Jemand anderes hat Buch
        }
        entleiher = p;
        p.leihtAus(this);
        return true;
    }

    public boolean wirdZurueckGegeben() {
        if (entleiher == null) {
            return false; // Niemand leiht Buch aus
        }
        entleiher.gibtZurueck(this);
        entleiher = null;
        return true;
    }

    public void print() {
        System.out.printf("%s: ", name);
        if (entleiher == null) {
            System.out.printf("nicht ausgeliehen\n");
        } else {
            System.out.printf("ausgeliehen von %s\n", entleiher.getName());
        }
    }
}
