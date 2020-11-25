package com.example.demo.controller.singleton;
import com.example.demo.controller.annoations.NotRecommend;
import com.example.demo.controller.annoations.ThreadSafe;

/**
 * 懒汉模式
 * 单例实例在第一次使用时进行创建
 */
@ThreadSafe
@NotRecommend //不推荐，同步会带来性能开销
public class SingletonExample3 {

    //私有构造函数
    private SingletonExample3(){

    }

    //单例对象
    private static SingletonExample3 instance = null;

    //静态的工厂方法
    public static synchronized SingletonExample3 getInstance(){

        if(instance == null){
            instance = new SingletonExample3();
        }

        return instance;
    }
}
