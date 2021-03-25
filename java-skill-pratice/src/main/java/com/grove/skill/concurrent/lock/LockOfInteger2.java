package com.grove.skill.concurrent.lock;

import lombok.extern.slf4j.Slf4j;

/**
 * 关于使用Integer作为锁
 */
@Slf4j
public class LockOfInteger2 {

    public void start() {
        Thread task1 = new Thread(new Task1());
        task1.start();
        Thread task2 = new Thread(new Task2());
        task2.start();
    }

    class Task1 implements Runnable {
        //private Integer lock = 2;
        //private Integer lock = 128;
        private Integer lock = new Integer(1);
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
        // 锁可以生效
        //private Integer lock = 2;
        // 锁无法生效
        //private Integer lock = 128;
        // 锁无法生效
        private Integer lock = new Integer(1);
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
