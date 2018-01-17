package com.zzrenfeng.thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * 线程池 （Executors工厂创建）
 * 1：single Thread Executor  单线程池
 * 2：Cached Thread Pool      缓存线程池,不固定线程的大小
 * 3:Fixed Thread Pool        固定大小的线程池
 * 4:Scheduled Thread Pool    任务调度
 * 5:Single Thread Scheduled Pool   单线程任务调度
 *
 */
public class WhatIsPool {
	public static void main(String[] args) {
		int num = Runtime.getRuntime().availableProcessors();
		long total = Runtime.getRuntime().totalMemory();
		long freem=Runtime.getRuntime().freeMemory();
		
		System.out.println(num);
		System.out.println(total/1024/1024);
		System.out.println(freem);
		
		/**
		 * 列出几种线程池的创建方式
		 */
		ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
		ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
		
		int cpuNums = Runtime.getRuntime().availableProcessors();
		System.out.println(cpuNums);
		ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(cpuNums);
		ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(8);
		
		
		ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
	}

}
