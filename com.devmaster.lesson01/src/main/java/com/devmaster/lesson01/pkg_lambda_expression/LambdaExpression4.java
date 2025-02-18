package com.devmaster.lesson01.pkg_lambda_expression;

import java.util.List;
import java.util.Arrays;

public class LambdaExpression4 {
    public static void main(String[] args) {
        List<String> list
                = Arrays.asList("Java SpringBoot",
                            "C# NetCore",
                            "PHP",
                            "JavaScript");

        list.forEach(x->System.out.println(x));
        System.out.println("=================");

        list.forEach(System.out::println);

        System.out.println("=================");
        // filter
        list.stream().filter(x->x.length()>10).forEach(System.out::println);
        System.out.println("=================");
        list.stream().filter(x->x.toUpperCase().contains("C")).forEach(System.out::println);
    }
}
