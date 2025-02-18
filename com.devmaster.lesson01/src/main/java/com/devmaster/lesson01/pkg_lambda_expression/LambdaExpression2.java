package com.devmaster.lesson01.pkg_lambda_expression;

@FunctionalInterface
interface SayHello2{
    void sayHello(String name);
}

public class LambdaExpression2 {
    public static void main(String[] args) {
        // Lambda sử dụng 1 tham số
        SayHello2 say = (name) -> {
            System.out.println("Hello " +name);
        };
        say.sayHello("Chung Trịnh");
        // Ngắn gọn
        say = name -> {
            System.out.println("Hello " +name);
        };
        say.sayHello("Chung Trunh");

        // ngăn gọn hơn
        say = name -> System.out.println("Hello " +name);
        say.sayHello("Devmaster");
    }
}
