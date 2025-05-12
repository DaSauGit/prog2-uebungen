package Aufgabe6Teil1;

public class ElementareTaetigkeit implements Taetigkeit{
    double time;
    String beschr;

    public ElementareTaetigkeit(String beschr, double time){
        this.time = time;
        this.beschr = beschr;
    }

    @Override
    public double getTime() {
        return time;
    }

    @Override
    public void add(Taetigkeit t) {

    }

    @Override
    public void remove(Taetigkeit t) {

    }

    @Override
    public int getAnzahl() {
        return 0;
    }

    @Override
    public String toString() {
        return "Tätigkeit braucht " + time + " Minuten um fertig zu werden.";
    }
}
