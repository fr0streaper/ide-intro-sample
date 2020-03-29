package com.fr0streaper.idetutorial;

public class Log extends BinaryExpression {

    public Log(Expression arg1, Expression arg2) {
        super(arg1, arg2);
    }

    @Override
    public Double evaluate() {
        return Math.log(arg1.evaluate()) / Math.log(arg2.evaluate());
    }

}