package com.springinaction.knights;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.springinaction.knights.config.KnightConfig;

public class KnightConfigMain {

	public static void main (String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext context = new AnnotationConfigApplicationContext (KnightConfig.class);
		System.out.println("stage 1");

		Knight knight = (Knight) context.getBean("knight");
		System.out.println("stage 2");

		knight.embarkOnQuest();
		System.out.println("stage 3");
	}
}
