package Expressions;

import ExpressionTypes.Expression;
import ExpressionTypes.UnaryExpression;

public class Sqrt extends UnaryExpression {

    public Sqrt(Expression arg) {
        super(arg);
    }

    @Override
    public Double evaluate() {
        return Math.sqrt(arg.evaluate());
    }

    @Override
    public String toString() {
        return arg.toString() + " sqrt";
    }
}
