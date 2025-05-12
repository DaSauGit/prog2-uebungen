package Aufgabe6Teil1;

public class ParalleleTaetigkeit extends ZusammengesetzteTaetigkeit{
    @Override
    public double getTime() {
        double time = 0;
        double longestTime = 0;
        for (Taetigkeit t : meineTaetigkeiten) {
            if (t.getTime() > longestTime) {
                longestTime = t.getTime();
            }
        }
        time = longestTime;
        return time;
    }

    @Override
    public String toString() {
        return "Parallele Tätigkeit braucht " + getTime() + " Minuten um fertig zu werden.";
    }
}
