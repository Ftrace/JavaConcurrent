package com.example.demo.controller.publish;

import com.example.demo.controller.annoations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * 不安全发布对象实例
 * 发布对象:使一个对象能够被当前范围之外的代码所使用
 */
@NotThreadSafe
@Slf4j
public class UnsafePublish {

    private String[] states= {"a","b","c"};

    public String[] getStates(){
        return states;
    } //可以通过该方法得到states引用

    public static void main(String[] args) {
        UnsafePublish unsafePublish = new UnsafePublish();
        log.info("{}", Arrays.toString(unsafePublish.getStates()));
        unsafePublish.getStates()[0] = "d";
        log.info("{}", Arrays.toString(unsafePublish.getStates()));
    }
}
