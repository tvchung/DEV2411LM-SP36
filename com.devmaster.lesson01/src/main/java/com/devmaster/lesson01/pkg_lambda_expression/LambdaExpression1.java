package com.devmaster.lesson01.pkg_lambda_expression;

@FunctionalInterface
interface SayHello {
    void sayHello();
}

/**
 * Lambda expression không tham số
 */
public class LambdaExpression1 {
    public static void main(String[] args) {
        SayHello sayHello = () -> {
            System.out.println("Hello World");
        };
        sayHello.sayHello();
    }
}
