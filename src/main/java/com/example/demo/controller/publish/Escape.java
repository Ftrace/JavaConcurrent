package com.example.demo.controller.publish;

import com.example.demo.controller.annoations.NotRecommend;
import com.example.demo.controller.annoations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

/**
 *  对象逸出:一种错误的发布。
 *          当一个对象还没有构造完成时，就使它被其他线程所见
 */
@Slf4j
@NotThreadSafe
@NotRecommend
public class Escape {

    private int thisCanBeEscape = 0;

    public Escape(){
        new InnerClass();
    }

    //声明一个内部类
    private class InnerClass{

        public InnerClass(){
            log.info("{}",Escape.this.thisCanBeEscape);
        }
    }

    public static void main(String[] args) {
        new Escape();
    }


}
