package Aufgabe6Teil1;

public interface Taetigkeit {
    double getTime();

    void add(Taetigkeit t);

    void remove(Taetigkeit t);

    int getAnzahl();

    String toString();
}
