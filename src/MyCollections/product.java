package MyCollections;

import java.util.Deque;
import java.util.LinkedList;

public class product {


    public static void main(String[] args) {
        Deque<Integer> stack = new LinkedList<>();
        int maxSize = 500;
        int n = 2000;
        Thread Producer = new Thread() {
            @Override
            public void run() {
                while (true) {
                    synchronized (stack) {
                        if (stack.size() < maxSize) {
                            stack.push(1);
                            System.out.println("填了,一共有" + stack.size());
                            notify();
                        } else {
                            try {
                                System.out.println("吃快点");
                                wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        };

        Thread Consumer = new Thread() {
            @Override
            public void run() {
                while (true) {
                    synchronized (stack) {
                        if (!stack.isEmpty()) {
                            stack.pop();
                            System.out.println("吃一个,还有" + stack.size());
                            notify();
                        } else {
                            try {
                                System.out.println("没了，我等等");
                                wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        };
        Producer.setPriority(10);
        Consumer.setPriority(5);
        Producer.start();
        Consumer.start();
    }
}

