package MyCollections;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.*;

public class ThreadPool {

    LinkedList<Runnable> tasks = new LinkedList<>();
    int maxThreadNumber;

    public ThreadPool(int maxThreadNumber) {
        this.maxThreadNumber = maxThreadNumber;
        for (int i = 0; i < maxThreadNumber; i++) {
            new taskConsumeThread("消费者进程" + i).start();
        }
    }

    public void add(Runnable r) {
        synchronized (tasks) {
            tasks.add(r);
            tasks.notifyAll();
        }
    }

    class taskConsumeThread extends Thread {
        public taskConsumeThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            Runnable task;
            while (true) {
                synchronized (tasks) {
                    while (tasks.isEmpty()) {
                        try {
                            tasks.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    task = tasks.removeLast();
                    tasks.notifyAll();
                }
                System.out.println(this.getName() + "获取到任务,并运行");
                task.run();
            }
        }
    }

    public void testPool() {
        ThreadPool tp = new ThreadPool(10);
        for (int i = 0; i < 100; i++) {
            int finalI = i;
            Runnable task = new Runnable() {
                @Override
                public void run() {
                    System.out.println("输出任务" + finalI);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            tp.add(task);
            try {
                Thread.sleep(1000 - finalI * 10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static void fileDfs(File file, ThreadPoolExecutor threadPool) {
        if (file.isFile()) {
            if (file.getName().endsWith(".java")) {
                threadPool.execute(new Runnable() {
                    @Override
                    public void run() {
                        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                            String line;
                            while ((line = br.readLine()) != null) {
                                if (line.contains("main")) {
                                    System.out.println("找到一个,文件名为" + file.getName());
                                    break;
                                }
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }

        }


        if (file.isDirectory()) {
            for (File nextFile : Objects.requireNonNull(file.listFiles())) {
                fileDfs(nextFile, threadPool);
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor tpe = new ThreadPoolExecutor(10, 15, 60,
                TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());

        File file = new File("C:\\Users\\BXW\\IdeaProjects\\notepad");
        fileDfs(file, tpe);

        tpe.shutdown();
        tpe.awaitTermination(1000,TimeUnit.MICROSECONDS);
    }
}
