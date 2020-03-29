package Expressions;

import ExpressionTypes.Expression;
import ExpressionTypes.UnaryExpression;

public class Exp extends UnaryExpression {

    public Exp(Expression arg) {
        super(arg);
    }

    @Override
    public Double evaluate() {
        return Math.pow(Math.E, arg.evaluate());
    }

    @Override
    public String toString() {
        return arg.toString() + " exp";
    }
}
