package com.zzrenfeng.thread.thread;
/**
 * syn锁不光是在一个代码体中多次使用的，可以是两个不同的线程中去争抢锁的
 * 无需手动释放锁，当程序执行完毕会自动的释放锁，或者遇到异常也会释放锁
 * @author Administrator
 *
 */
public class SynchronizedTest {
	public static void main(String[] args) {
		final SynchronizedTest mySynchronized = new SynchronizedTest();
		final SynchronizedTest mySynchronized2 = new SynchronizedTest();
		new Thread("thread1") {
			public void run() {
				synchronized (mySynchronized) {
				try {
					System.out.println(this.getName()+" start");
					//int i =1/0;   //如果发生异常，jvm会将锁释放
					Thread.sleep(5000);
					System.out.println(this.getName()+"醒了");
					System.out.println(this.getName()+" end");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				}
			}
		}.start();
		new Thread("thread2") {
			public void run() {
				synchronized (mySynchronized) {         //争抢同一把锁时，线程1没释放之前，线程2只能等待
//					synchronized (mySynchronized2) {    //如果不是一把锁，可以看到两句话同时打印
					System.out.println(this.getName()+" start");
					System.out.println(this.getName()+" end");
					
				}
			}
		}.start();
	}
}
