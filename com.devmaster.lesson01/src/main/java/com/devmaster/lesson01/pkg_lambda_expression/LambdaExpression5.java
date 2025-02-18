package com.devmaster.lesson01.pkg_lambda_expression;

import java.util.*;

class Book{
    int id;
    String name;
    float price;
    public Book(int id, String name, float price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
public class LambdaExpression5 {
    public static void main(String[] args) {
        List<Book> books = new ArrayList<Book>();
        books.add(new Book(1, "Lập trình Java", 9.95f));
        books.add(new Book(2, "Java SpringBoot", 19.95f));
        books.add(new Book(3, "PHP Laravel", 12.95f));
        books.add(new Book(4, "NetCore API", 29.95f));
        books.add(new Book(5, "Javascript", 19.95f));

        books.stream().forEach(System.out::println);
        System.out.println("==============");
        var filterPrice=books.stream().filter(x->x.price > 15);
        filterPrice.forEach(System.out::println);
    }
}
