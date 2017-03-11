package demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloWorld {
	public static void main(String[] args) {
		Logger log = LoggerFactory.getLogger(HelloWorld.class);
		log.info("Hello World");
	}
}
