package com.fuwh.demo;

import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.DefaultHashService;
import org.apache.shiro.crypto.hash.HashRequest;
import org.apache.shiro.util.SimpleByteSource;

public class HashServiceDemo {

	public static void main(String[] args) {
		/*
		 * 构建一个HashService
		 * 默认情况下：
		 * 散列算法：SHA-512 
		 * 循环次数：1
		 * 不生成公盐
		 */
		DefaultHashService service=new DefaultHashService();
		service.setHashAlgorithmName("SHA-512");//设置加密算法，默认就是这个
		service.setPrivateSalt(new SimpleByteSource("123"));//设置私盐
		service.setGeneratePublicSalt(true);//设置生成公研
		service.setRandomNumberGenerator(new SecureRandomNumberGenerator());//设置公盐的生成方式
		service.setHashIterations(1);//设置加密次数
		
		/*
		 * 构建一个HashRequest里面包含了HashService加密需要的一些信息。
		 */
		HashRequest request=new HashRequest.Builder()
				.setAlgorithmName("MD5")
				.setSalt("12345")
				.setSource("pass1234")
				.setIterations(2)
				.build();
		
		System.out.println(service.computeHash(request).toString());
	}
}
