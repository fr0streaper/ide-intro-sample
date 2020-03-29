package Expressions;

import ExpressionTypes.BinaryExpression;
import ExpressionTypes.Expression;

public class Add extends BinaryExpression {

    public Add(Expression arg1, Expression arg2) {
        super(arg1, arg2);
    }

    @Override
    public Double evaluate() {
        return arg1.evaluate() + arg2.evaluate();
    }

    @Override
    public String toString() {
        return arg1.toString() + " " + arg2.toString() + " +";
    }

}