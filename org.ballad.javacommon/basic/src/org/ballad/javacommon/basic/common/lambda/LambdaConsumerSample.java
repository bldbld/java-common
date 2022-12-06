package org.ballad.javacommon.basic.common.lambda;

import java.util.function.Consumer;

public class LambdaConsumerSample {

    public static void main(String[] args) {
        Consumer<String> cmra = str -> System.out.println(str);
        Consumer<String> cmrb = LambdaConsumerSample::sout;
        cmra.accept("a");
        cmrb.accept("a");

    }

    public static void sout(String s){
        System.out.println(s);
    }

}
