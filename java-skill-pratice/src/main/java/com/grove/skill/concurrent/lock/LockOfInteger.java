package com.grove.skill.concurrent.lock;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 关于使用Integer作为锁
 */
@Slf4j
@Component
public class LockOfInteger {

    private Integer lock = 2;

    public void start() {
        Thread task1 = new Thread(new Task1());
        task1.start();
        Thread task2 = new Thread(new Task2());
        task2.start();
    }

    public void start2() {
        Thread task1 = new Thread(new Task3());
        task1.start();
        Thread task2 = new Thread(new Task3());
        task2.start();

    }

    class Task3 implements Runnable {

        private int count = 0;

        private final Integer integer = new Integer(count);

        @Override
        public void run() {
            for (int i=0;i<1000; i++) {
                count++;
            }
            log.info("result is {}", count);
        }
    }

    class Task1 implements Runnable {

        @Override
        public void run() {
            synchronized (lock) {
                log.info("start run task1");
                try {
                    Thread.sleep(3000l);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class Task2 implements Runnable {

        @Override
        public void run() {
            synchronized (lock) {
                log.info("start run task2");
                try {
                    Thread.sleep(3000l);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
