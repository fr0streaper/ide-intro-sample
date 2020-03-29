package Expressions;

import ExpressionTypes.Expression;
import ExpressionTypes.UnaryExpression;

public class Negate extends UnaryExpression {

    public Negate(Expression arg) {
        super(arg);
    }

    @Override
    public Double evaluate() {
        return -1 * arg.evaluate();
    }

    @Override
    public String toString() {
        return arg.toString() + " neg";
    }
}
