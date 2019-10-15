package com.uc.server.web;

import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.hwl.themis.log.annoation.LogItem;
import com.hwl.themis.log.annoation.LogMapping;

@Service
public class TestService {

	private static final Logger LOGGER = LoggerFactory.getLogger(TestService.class);
	
	@LogMapping(item=LogItem.ALL)
	public String name(String str) {
		LOGGER.info("============>str:" + str);
		return str;
	}
	

	public static void main(String[] args) throws NoSuchMethodException, SecurityException {
		TestService testService = new TestService();
		Class<?> class1 = testService.getClass();
		Method method = class1.getDeclaredMethod("name", String.class);
		System.out.println(method);
		LogMapping logMapping = method.getAnnotation(LogMapping.class);
		System.out.println(logMapping);
	}
}
