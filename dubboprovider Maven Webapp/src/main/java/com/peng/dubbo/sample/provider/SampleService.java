package com.peng.dubbo.sample.provider;

import java.util.List;

import com.peng.dubbo.sample.provider.impl.User;

public interface SampleService {
	String sayHello(String name);

	public List<User> getUsers();
}
