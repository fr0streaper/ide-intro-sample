package Expressions;

import ExpressionTypes.BinaryExpression;
import ExpressionTypes.Expression;

public class Log extends BinaryExpression {

    public Log(Expression arg1, Expression arg2) {
        super(arg1, arg2);
    }

    @Override
    public Double evaluate() {
        return Math.log(arg1.evaluate()) / Math.log(arg2.evaluate());
    }

    @Override
    public String toString() {
        return arg1.toString() + " " + arg2.toString() + " log";
    }

}