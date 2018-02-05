package com.peng.dubbo.sample.test;

import java.io.IOException;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.peng.dubbo.sample.provider.SampleService;

public class Consumer {
	public static void main(String[] args) throws IOException {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "sample-consumer.xml" });
		context.start();
		
		SampleService sampleService = (SampleService) context.getBean("sampleService");
		String hello = sampleService.sayHello("tom");
		System.out.println(hello);
		
		List list = sampleService.getUsers();
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i));
			}
		}
		
		System.in.read();
	}
	
}
