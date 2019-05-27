package com.liwenguang.api.webmagic.util;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author liwenguang
 * @Date 2019-05-19 00:03
 * @Description
 */
public class ThreadPoolUtil {

    public final static int THREAD_NUMBER = 3;

    static class NamedThreadFactory implements ThreadFactory {
        private static final AtomicInteger POOL_NUMBER = new AtomicInteger(1);
        private final ThreadGroup group;
        private final AtomicInteger threadNumber = new AtomicInteger(1);
        private final String namePrefix;

        NamedThreadFactory(String name) {
            SecurityManager s = System.getSecurityManager();
            group = (s != null) ? s.getThreadGroup() :
                    Thread.currentThread().getThreadGroup();
            namePrefix = name + "-" +
                    POOL_NUMBER.getAndIncrement() +
                    "-thread-";
        }

        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(group, r,
                    namePrefix + threadNumber.getAndIncrement(),
                    0);
            if (t.isDaemon()) {
                t.setDaemon(false);
            }
            if (t.getPriority() != Thread.NORM_PRIORITY) {
                t.setPriority(Thread.NORM_PRIORITY);
            }
            return t;
        }
    }

    public static ExecutorService get(int number, String name) {
        return new ThreadPoolExecutor(number, 10, 0, TimeUnit.SECONDS, new LinkedBlockingQueue<>(128), new NamedThreadFactory(name),
                (r, executor) -> {
                    throw new RejectedExecutionException(name + " 线程超过预期，请检查");
                });
    }

    public static ExecutorService get(String name) {
        return get(THREAD_NUMBER, name);
    }

}