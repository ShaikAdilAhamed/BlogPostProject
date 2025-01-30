package com.first.ramSirRstApi.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordGeneratorEncoder {
	public static void main(String[] args) {
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		System.out.println("------------Encoded-------------------------");
		System.out.println(passwordEncoder.encode("admin"));
	//	System.out.println(passwordEncoder.encode("adil"));
		//System.out.println("----------------Decoded------------------------");
	//	System.out.println(passwordEncoder.encode("adil"));
		//System.out.println(passwordEncoder.encode("adil"));
		
	}
}
