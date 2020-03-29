package com.fr0streaper.idetutorial;

public class Constant implements Expression {

    private final Double value;

    public Constant(Double value) {
        this.value = value;
    }

    public Double evaluate() {
        return value;
    }

    @Override
    public String toString() {
        return value.toString();
    }

}