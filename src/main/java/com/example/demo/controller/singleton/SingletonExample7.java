package com.example.demo.controller.singleton;
import com.example.demo.controller.annoations.Recommend;
import com.example.demo.controller.annoations.ThreadSafe;

/**
 * 枚举模式： 最安全
 * 相比懒汉模式：在安全性方面更容易保证
 * 相比饿汉模式：在实际调用时才做初始化，后续使用可以直接取到里面的值，不会造成资源浪费
 */
@ThreadSafe
@Recommend
public class SingletonExample7 {

    //私有构造函数
    private SingletonExample7(){

    }

    //静态的工厂方法
    public static SingletonExample7 getInstance(){
        return Singleton.INSTANCE.getInstance();


    }

    //定义一个私有枚举类
    private enum Singleton{
        INSTANCE;

        private SingletonExample7 singleton;

        //JVM保证该方法绝对只调用一次
        Singleton(){
            singleton = new SingletonExample7();
        }

        public SingletonExample7 getInstance(){
            return singleton;
        }




    }
}
