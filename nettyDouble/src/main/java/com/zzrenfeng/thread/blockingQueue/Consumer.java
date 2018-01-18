package com.zzrenfeng.thread.blockingQueue;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable{  
    BlockingQueue<String> queue; 
    public Consumer(BlockingQueue<String> queue){  
        this.queue = queue;  
    }        
    @Override  
    public void run() {  
        try {  
        	String consumer = Thread.currentThread().getName();
        	System.out.println(consumer);  
            String temp = queue.take();//如果队列为空，会阻塞当前线程  
            
            //queue.poll();//不会阻塞          return null if it is emputy
            System.out.println(consumer+"get a product:"+temp);  
        } catch (InterruptedException e) {  
            e.printStackTrace();  
        }  
    }  
} 
