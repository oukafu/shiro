package com.fuwh.demo;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.Sha256Hash;

public class HashDemo {

	public static void main(String[] args) {
		String password="pass1234";
		
		/*
		 * Md5散列解密,通常用来加密密码
		 * 在散列解密的时候，可以指定盐（salt）和加密的次数
		 * 盐用来提高加密的复杂度，因为弹出的Md5加密还是可能被破解
		 * 但是，加上一个只有系统知道的盐就基本上不会被破解了
		 * 加密次数，用来提高加密的复杂度
		 */
		Md5Hash md5Hash1=new Md5Hash(password);
		Md5Hash md5Hash2=new Md5Hash(password, "123");
		Md5Hash md5Hash3=new Md5Hash(password, "123",2);
		System.out.println("Md5加密--不加盐："+md5Hash1);
		System.out.println("Md5加密--加盐："+md5Hash2);
		System.out.println("Md5加密--加盐--二次加密："+md5Hash3);
		
		/*
		 * Sha256Hash
		 */
		Sha256Hash sha256Hash1=new Sha256Hash(password);
		Sha256Hash sha256Hash2=new Sha256Hash(password, "123");
		Sha256Hash sha256Hash3=new Sha256Hash(password, "123",2);
		System.out.println("Sha256Hash加密--不加盐："+sha256Hash1);
		System.out.println("Sha256Hash加密--加盐："+sha256Hash2);
		System.out.println("Sha256Hash加密--加盐--二次加密："+sha256Hash3);
	}
}
