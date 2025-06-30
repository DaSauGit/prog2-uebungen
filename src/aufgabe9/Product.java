package aufgabe9;

import java.util.Map;

public class Product extends CompoundExpression{
    Expression produkt;
    public Product(Expression a, Expression b){

    }

    @Override
    public double eval(Map<String, Double> varBel) {
        return 0;
    }
}
