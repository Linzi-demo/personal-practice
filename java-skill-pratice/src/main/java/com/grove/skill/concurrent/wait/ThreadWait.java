package com.grove.skill.concurrent.wait;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ThreadWait {

    public static final Object lock = new Object();

    /**
     * 占用锁的线程调用wait后，会释放锁
     */
    public void start() {
        Thread t1 = new Thread(() -> {
            log.info("开始执行线程1");
            synchronized (lock) {
                log.info("线程1获取锁");
                int i =0;
                while (true) {
                    i++;
                    if (i == 100000) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }

            }
        });

        Thread t2 = new Thread(() -> {
            log.info("开始执行线程2");
            synchronized (lock) {
                log.info("线程2获取锁");

            }
        });

        t1.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();

    }
}
