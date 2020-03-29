package com.fr0streaper.idetutorial;

public class Divide extends BinaryExpression {

    public Divide(Expression arg1, Expression arg2) {
        super(arg1, arg2);
    }

    @Override
    public Double evaluate() {
        return arg1.evaluate() / arg2.evaluate();
    }

    @Override
    public String toString() {
        return arg1.toString() + " " + arg2.toString() + " /";
    }

}
