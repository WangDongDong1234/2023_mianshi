package juc;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class 抢车位 {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);
        for(int i=1;i<=6;i++){
            new Thread(()->{
                //抢占
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+"抢到了车位");
                    TimeUnit.SECONDS.sleep(5);
                    System.out.println(Thread.currentThread().getName()+"离开了车位");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    //释放
                    semaphore.release();
                }


            },String.valueOf(i)).start();
        }
    }

}
