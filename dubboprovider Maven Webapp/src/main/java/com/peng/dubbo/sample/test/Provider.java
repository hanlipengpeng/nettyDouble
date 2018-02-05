package com.peng.dubbo.sample.test;

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Provider {
	
	public static void main(String[] args) throws IOException {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "sample-provider.xml" });
		context.start();
		System.in.read();// 为保证服务一直开着，利用输入流的阻塞来模拟
		
		
		
	}
	
}
