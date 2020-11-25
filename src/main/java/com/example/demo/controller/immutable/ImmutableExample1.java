package com.example.demo.controller.immutable;

import com.example.demo.controller.annoations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@NotThreadSafe
public class ImmutableExample1 {
    private final static Integer a = 1;
    private final static String b = "abc";
    private final static Map<Integer,Integer> map = new HashMap<>();

    static {
        map.put(1,2);
        map.put(3,4);
        map.put(5,6);
    }

    public static void main(String[] args){
//        a = 2;
//        b ="3";
//        map = new HashMap<>();
        map.put(1,3);
        log.info("{}",map.get(1));
    }

    private void test(final int a){
//        a=1;
    }
}
