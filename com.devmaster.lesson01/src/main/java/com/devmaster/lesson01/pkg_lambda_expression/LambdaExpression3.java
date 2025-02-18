package com.devmaster.lesson01.pkg_lambda_expression;
@FunctionalInterface
interface  Calculator {
    void add(int a, int b);
}

interface Calculator2 {
    int add(int a, int b);
}

public class LambdaExpression3 {
    public static void main(String[] args) {
        Calculator calc = (int a, int b)->{
            System.out.printf("\n %d + %d = %d\n", a, b, a+b);
        };
        calc.add(10, 20);

        calc = (a,b)-> System.out.printf("\n %d + %d = %d\n", a, b, a+b);
        calc.add(100,200);

        Calculator2 calc2 = (int a, int b)->{
            return a+b;
        };
        System.out.printf("\n %d + %d = %d\n",10,20,calc2.add(10,20));
    }
}
