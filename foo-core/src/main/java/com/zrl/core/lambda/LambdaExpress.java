package com.zrl.core.lambda;

import java.awt.event.ActionListener;
import java.util.function.BinaryOperator;

public class LambdaExpress {

    public static void main(String[] args) {

        //1、无入参
        Runnable noArguments = () -> System.out.println("Hello World");

        // 一个入参
        ActionListener oneArgument = event -> System.out.println("button clicked");

        // 多个语句
        Runnable multiStatement = () -> {
            System.out.print("Hello");
            System.out.println(" World");
        };

        //多个入参
        BinaryOperator<Long> add = (x, y) -> x + y;

        //
        BinaryOperator<Long> addExplicit = (Long x, Long y) -> x + y;
    }

}
