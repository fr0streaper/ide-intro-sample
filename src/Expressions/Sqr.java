package Expressions;

import ExpressionTypes.Expression;
import ExpressionTypes.UnaryExpression;

public class Sqr extends UnaryExpression {

    public Sqr(Expression arg) {
        super(arg);
    }

    @Override
    public Double evaluate() {
        Double value = arg.evaluate();
        return value * value;
    }

    @Override
    public String toString() {
        return arg.toString() + " sqr";
    }

}
