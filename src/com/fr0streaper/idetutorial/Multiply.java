package com.fr0streaper.idetutorial;

public class Multiply extends BinaryExpression {

    public Multiply(Expression arg1, Expression arg2) {
        super(arg1, arg2);
    }

    @Override
    public Double evaluate() {
        return arg1.evaluate() * arg2.evaluate();
    }

}
