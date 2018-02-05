package com.peng.dubbo.sample.provider.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Service;
import com.peng.dubbo.sample.provider.SampleService;
import com.peng.dubbo.sample.provider.impl.User;
@Component
@Service(interfaceName="com.peng.dubbo.sample.provider.SampleService")
public class SampleServiceImpl implements SampleService {

	@Override
	public String sayHello(String name) {
		return "Hello " + name;
	}

	@Override
	public List<User> getUsers() {
		List<User> list = new ArrayList<>();
		User u1 = new User();
		u1.setName("jack");
		u1.setAge(20);
		u1.setSex("m");

		User u2 = new User();
		u2.setName("tom");
		u2.setAge(21);
		u2.setSex("m");

		User u3 = new User();
		u3.setName("rose");
		u3.setAge(19);
		u3.setSex("w");

		list.add(u1);
		list.add(u2);
		list.add(u3);
		return list;
	}

}
