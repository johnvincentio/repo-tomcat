package com.springinaction.knights;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class KnightMain {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("knights.xml"); // <co id="co_loadKnightContext"/>
		System.out.println("stage 1");

		Knight knight = (Knight) context.getBean("knight"); // <co id="co_getBeanKnight"/>
		System.out.println("stage 2");

		knight.embarkOnQuest();// <co id="co_useKnight"/>
		System.out.println("stage 3");
	}
}
