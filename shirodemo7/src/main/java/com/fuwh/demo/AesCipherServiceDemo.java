package com.fuwh.demo;

import java.security.Key;

import org.apache.shiro.crypto.AesCipherService;

public class AesCipherServiceDemo {

	public static void main(String[] args) {
		
		AesCipherService acs=new AesCipherService();
		String pass="pass1234";
		Key key=acs.generateNewKey();
		System.out.println(acs.encrypt(pass.getBytes(), key.getEncoded()));
		System.out.println(acs.encrypt(pass.getBytes(), key.getEncoded()).toString());
		System.out.println(acs.encrypt(pass.getBytes(), key.getEncoded()).toHex());
		System.out.println(acs.encrypt(pass.getBytes(), key.getEncoded()).toBase64());
	}
}
