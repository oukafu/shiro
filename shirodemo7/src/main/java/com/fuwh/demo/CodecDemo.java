package com.fuwh.demo;

import org.apache.shiro.codec.Base64;
import org.apache.shiro.codec.Hex;

public class CodecDemo {

	public static void main(String[] args) {
		String password="pass1234";
		
		/*
		 * Base64类提供了一些base64方式的编码和解码操作
		 */
		System.out.println("Base64加密后："+Base64.encodeToString(password.getBytes()));
		System.out.println("Base64解密后："+Base64.decodeToString(Base64.encodeToString(password.getBytes())));
		
		/*
		 * Hex类提供了一些十六进制的编码和解码操作
		 */
		System.out.println("Hex编码后："+Hex.encodeToString(password.getBytes()));
		System.out.println("Hex解码后："+new String(Hex.decode(Hex.encode(password.getBytes()))));
	}
}
