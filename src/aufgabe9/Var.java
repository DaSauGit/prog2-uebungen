package aufgabe9;

import java.util.Map;

public class Var implements  Expression{
    String variable;
    public Var(String variable){
        this.variable = variable;
    }

    @Override
    public double eval(Map<String, Double> varBel) {
        return 0;
    }
}
