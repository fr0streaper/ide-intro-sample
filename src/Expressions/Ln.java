package Expressions;

import ExpressionTypes.Expression;
import ExpressionTypes.UnaryExpression;

public class Ln extends UnaryExpression {

    public Ln(Expression arg) {
        super(arg);
    }

    @Override
    public Double evaluate() {
        return Math.log(arg.evaluate());
    }

    @Override
    public String toString() {
        return arg.toString() + " ln";
    }
}
