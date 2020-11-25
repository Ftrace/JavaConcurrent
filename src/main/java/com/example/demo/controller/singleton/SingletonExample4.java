package com.example.demo.controller.singleton;
import com.example.demo.controller.annoations.NotThreadSafe;
/**
 * 懒汉模式->双重同步锁单例模式
 * 单例实例在第一次使用时进行创建
 */
@NotThreadSafe
public class SingletonExample4 {

    //私有构造函数
    private SingletonExample4(){

    }

    // 这段代码 instance = new SingletonExample4(); 分三步
    // 1、memory = allocate() 分配对象的内存空间
    // 2、ctorInstance 初始化对象
    // 3、instance = memory 设置instance指向刚分配的内存

    // 由于JVM和CPU优化，发生了指令重排，顺序可能如下

    // 1、memory = allocate() 分配对象的内存空间
    // 3、instance = memory 设置instance指向刚分配的内存
    // 2、ctorInstance 初始化对象

    //单例对象
    private static SingletonExample4 instance = null;

    //静态的工厂方法
    public static synchronized SingletonExample4 getInstance(){

        if(instance == null){ //双重检测机制    //2. 线程B执行到这一步，检测到instance有值就会返回。但是还没初始化对象，调用会用问题
            synchronized (SingletonExample4.class){
                if(instance == null){ //同步锁
                    instance = new SingletonExample4(); //1. 线程A执行到这一步，执行到指令重排后的3（instance = memory 设置instance指向刚分配的内存）
                }
            }
        }

        return instance;
    }
}
