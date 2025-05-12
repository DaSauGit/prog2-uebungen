package Aufgabe6Teil1;

public class SerielleTaetigkeit extends ZusammengesetzteTaetigkeit{
    @Override
    public double getTime() {
        double time = 0;
        for (Taetigkeit t : meineTaetigkeiten) {
            time += t.getTime();
        }
        return time;
    }

    @Override
    public String toString() {
        return "Serielle Tätigkeit braucht " + getTime() + " Minuten um fertig zu werden.";
    }
}
