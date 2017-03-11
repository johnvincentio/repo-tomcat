package com.springinaction.knights;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class KnightAopMain {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("knights-aop.xml");
		System.out.println("stage 1");

		Knight knight = (Knight) context.getBean("knight");
		System.out.println("stage 2");

		knight.embarkOnQuest();
		System.out.println("stage 3");
	}
}
