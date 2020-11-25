package com.example.demo.controller.singleton;
import com.example.demo.controller.annoations.ThreadSafe;

/**
 * 懒汉模式->双重同步锁单例模式
 * 单例实例在第一次使用时进行创建
 */
@ThreadSafe
public class SingletonExample5 {

    //私有构造函数
    private SingletonExample5(){

    }

    // 这段代码 instance = new SingletonExample4(); 分三步
    // 1、memory = allocate() 分配对象的内存空间
    // 2、ctorInstance 初始化对象
    // 3、instance = memory 设置instance指向刚分配的内存

    //单例对象
    //volatile禁止指令重排
    private volatile static SingletonExample5 instance = null;

    //静态的工厂方法
    public static synchronized SingletonExample5 getInstance(){

        if(instance == null){ //双重检测机制
            synchronized (SingletonExample5.class){
                if(instance == null){ //同步锁
                    instance = new SingletonExample5();
                }
            }
        }

        return instance;
    }
}
