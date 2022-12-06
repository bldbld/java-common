package org.ballad.javacommon.basic.common.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.ToIntFunction;

public class LambdaFunctionConsumer {
    public static void main(String[] args) {

        Function<Integer, String> functiona = intValue -> intValue + "string";
        String s2 = functiona.apply(3);
        System.out.println(s2);

        IntFunction<List> functionb = intValue -> new ArrayList(intValue);
        System.out.println(functionb.apply(5).size());

        ToIntFunction<Integer> functionc = intValue -> intValue + 3;
        System.out.println(functionc.applyAsInt(5));

        BiFunction<Integer, Integer, Integer> functiond = (integer, integer2) -> integer + integer2;
        System.out.println(functiond.apply(3, 2));


    }
}
