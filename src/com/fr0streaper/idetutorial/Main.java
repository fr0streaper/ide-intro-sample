package com.fr0streaper.idetutorial;

public class Main {

    public static void main(String[] args) {
        PolishExpressionParser parser = new PolishExpressionParser();

        if (args.length != 1) {
            System.out.println("Please supply exactly 1 argument");
            return;
        }

        try {
            System.out.println(parser.parse(args[0]).evaluate());
        } catch (Exception e) {
            System.out.println("The program has finished with an exception: " + e.getMessage());
        }
    }
}
