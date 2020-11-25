package com.example.demo.controller.singleton;
import com.example.demo.controller.annoations.ThreadSafe;

/**
 * 饿汉模式 通过静态块实现
 * 单例实例在类装载时进行创建
 * 缺点：构造方法里如果处理过多，会导致类加载过慢，引起性能问题
 */
@ThreadSafe
public class SingletonExample6 {

    //私有构造函数
    private SingletonExample6(){

    }

    //单例对象
    private static SingletonExample6 instance = null;

    static {
        instance = new SingletonExample6();
    }

    //静态的工厂方法
    public static SingletonExample6 getInstance(){
        return instance;
    }

    public static void main(String[] args) {
        System.out.println(getInstance().hashCode());
        System.out.println(getInstance().hashCode());
    }
}
