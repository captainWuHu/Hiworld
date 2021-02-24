package MyCollections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MyThread {
    public static void main(String[] a){
        Object someObject = new Object();
        String code = "2Ik";
        char[] part = new char[3];
        List<String> bufferPool= new LinkedList<>();


        Thread t1 = new Thread(){
            @Override
            public void run(){
                if(dfs(0)){
                    System.out.println("true");
                }else{
                    System.out.println("false");
                }
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            public boolean dfs(int index){
                if(index==3){
                    String res = String.valueOf(part);
                    synchronized (someObject) {
                        bufferPool.add(res);
                    }
                    return res.equals(code);
                }

                for(int i = 0;i<75;i++){
                    part[index]=((char)('0'+i));
                    if(dfs(index+1))return true;
                }
                return false;
            }
        };

        Thread t2 = new Thread(){
            @Override
            public void run() {
                while(true) {
                    if (bufferPool.size() == 0) {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }else{
                        System.out.println(bufferPool.remove(0));
                    }
                }
            }
        };

        //t1.setPriority(Thread.MAX_PRIORITY);
        t1.setPriority(5);
        t2.setPriority(2);
        t2.setDaemon(true);
        t1.start();
        t2.start();


    }





}
