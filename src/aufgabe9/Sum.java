package aufgabe9;

import java.util.Map;

public class Sum extends CompoundExpression{
    double summe;

    public Sum(Expression a, Expression b){
        //summe = a + b;
    }

    @Override
    public double eval(Map<String, Double> varBel) {
        return 0;
    }
}
