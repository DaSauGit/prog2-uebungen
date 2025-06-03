package aufgabe9;

import java.util.Map;

public class Difference extends CompoundExpression{
    double difference;
    public Difference(Expression a, Expression b){
        // a - b;
    }

    @Override
    public double eval(Map<String, Double> varBel) {
        return 0;
    }
}
