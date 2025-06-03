package aufgabe9;

import java.util.Map;

public class Constant implements Expression {
    double constant;
    public Constant(double wert) {
        this.constant = wert;
    }

    @Override
    public double eval(Map<String, Double> varBel) {
        return 0;
    }
}
