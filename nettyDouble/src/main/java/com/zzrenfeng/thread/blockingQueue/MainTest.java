package com.zzrenfeng.thread.blockingQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
/**
 * blockingQueue 是一个线程安全的list，有两种实现，分别是Array实现和Linked实现，数据结构决定了其性质
 * 
 * @author rf
 *
 */
public class MainTest {
	public static void main(String[] args) throws Exception {
		BlockingQueue<String> queue = new LinkedBlockingQueue<String>(2);
		// BlockingQueue<String> queue = new LinkedBlockingQueue<String>();
		// 不设置的话，LinkedBlockingQueue默认大小为Integer.MAX_VALUE
		// BlockingQueue<String> queue = new ArrayBlockingQueue<String>(2);
		Consumer consumer = new Consumer(queue);
		Producer producer = new Producer(queue);
		for (int i = 0; i < 3; i++) {
			new Thread(producer, "Producer" + (i + 1)).start();
		}
		for (int i = 0; i < 5; i++) {
			new Thread(consumer, "Consumer" + (i + 1)).start();
		}
		
		new Thread(producer, "Producer" + (5)).start();
	}

}
