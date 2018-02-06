package com.peng.dubbo.sampleAnnotation.test;


import java.io.IOException;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.dubbo.config.annotation.Reference;
import com.peng.dubbo.sample.provider.SampleService;




/*public class Consumer {
	public static void main(String[] args) throws IOException {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "sample-consumer-annotation.xml" });
		context.start();
		
		SampleService sampleService = (SampleService) context.getBean("com.peng.dubbo.sample.provider.SampleService");
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
	
}*/
@Component
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/sample-consumer-annotation.xml"})
public class Consumer {
    
    /*@Reference(interfaceName="com.mujourney.service.UserService")*/
	@Reference(interfaceName="com.peng.dubbo.sampleAnnotation.provider.SampleService")
    private SampleService sampleService;
    
    @Test
    public void pors()  {
        System.out.println(sampleService.sayHello("dubbo!!!"));
    }
}