package com.example.eurekaserver.rate;

import com.google.common.collect.Lists;

import java.util.Collections;
import java.util.List;

public class Test {
    public static void main(String[] args) {
//        InputStream resourceAsStream = Test.class.getResourceAsStream("/rule.yml");
//        Yaml yaml = new Yaml();
//        Object load = yaml.load(resourceAsStream);
//        System.out.println(load);

        List<String> contents = Lists.newArrayList("yy", "xx");
        Collections.sort(contents);
        System.out.println(contents);
        System.out.println(Collections.binarySearch(contents, "yyccc"));

//        object:
//        -some:
//        key: value
//        limit:
//        - null_value:
//        - boolean: true
//                - integer: 1
//                -vv:
//        key: value
//        limit:
//        - null_value:
//        - boolean: true
//                - integer: 1

    }
}
