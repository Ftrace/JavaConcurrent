package com.example.demo.controller.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

@Slf4j
public class FutureExample {
    static class MyCallable implements Callable<String>{
        @Override
        public String call() throws Exception {
            log.info("do something in callable");
            Thread.sleep(5000);
            return "Done !";
        }
    }

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();

        //通过Future接收结果
        Future<String> future = executorService.submit(new MyCallable());

        log.info("do something in main");
        Thread.sleep(1000);

        //future.get()会阻塞接收
        String result = future.get();

        log.info("result：{}", result);

    }
}
