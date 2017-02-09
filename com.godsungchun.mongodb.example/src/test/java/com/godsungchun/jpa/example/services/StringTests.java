package com.godsungchun.jpa.example.services;

import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by Dream on 2017-02-09.
 */
public class StringTests {
	public static void main(String[] args) throws Exception {
		String text = new String(Files.readAllBytes(Paths.get("C:\\DEV\\1.xml")));
		
		String value = text.replace("\u0001?", "");
		System.out.println(value);
	}
}
