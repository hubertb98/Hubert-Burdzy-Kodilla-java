package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;

public class StreamMain {
    public static void main(String[] args) {
//        ExpressExecutor expressExecutor = new ExpressExecutor();
//
//        System.out.println("Calculating expressions with lambdas");
//        expressExecutor.executeExpression(10, 5, ((a, b) -> a + b));
//        expressExecutor.executeExpression(10, 5, ((a, b) -> a - b));
//        expressExecutor.executeExpression(10, 5, ((a, b) -> a * b));
//        expressExecutor.executeExpression(10, 5, ((a, b) -> a / b));
//
//        System.out.println("Calculating expressions with method references");
//        expressExecutor.executeExpression(3,4, FunctionalCalculator::addAToB);
//        expressExecutor.executeExpression(3,4, FunctionalCalculator::subBFormA);
//        expressExecutor.executeExpression(3,4, FunctionalCalculator::multiplyAByB);
//        expressExecutor.executeExpression(3,4, FunctionalCalculator::divideAByB);
        PoemBeautifier poemBeautifier = new PoemBeautifier();
        String text = "Lorem ipsum dolor sit amet";
        String text2 = "~";

        poemBeautifier.beautify(text, s -> s.toUpperCase());
        poemBeautifier.beautify(text, s -> s.toLowerCase());
        poemBeautifier.beautify(text, s -> s.replace(" ", "-"));
        poemBeautifier.beautify(text, s -> text2 + s + text2);

    }
}
