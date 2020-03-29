package com.fr0streaper.idetutorial;

public class Power extends BinaryExpression {

    public Power(Expression arg1, Expression arg2) {
        super(arg1, arg2);
    }

    @Override
    public Double evaluate() {
        return Math.pow(arg1.evaluate(), arg2.evaluate());
    }

}