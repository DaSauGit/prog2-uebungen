package aufgabe9;

import java.util.Map;

public class Product extends CompoundExpression{
    double produkt;
    public Product(Expression a, Expression b){
        // a * b
    }

    @Override
    public double eval(Map<String, Double> varBel) {
        return 0;
    }
}
