package org.ballad.javacommon.basic.common.lambda;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Lambda grammar using collection.
 *
 */
public class LambdaCollectionSample {

    public static void main(String[] args) {
        // Iterator List
        List<String> lists = Arrays.asList("I am A","I am B","I am C");
        // style 1
        lists.forEach(k -> System.out.println(k));
        // style 2
        lists.forEach(System.out::println);

        // Iterator Map
        Map<String, String> map = new HashMap<String ,String>();
        map.put("A","a");
        map.put("B","b");
        map.put("C","c");
        map.forEach((k, v) -> System.out.println(k));



    }
}
