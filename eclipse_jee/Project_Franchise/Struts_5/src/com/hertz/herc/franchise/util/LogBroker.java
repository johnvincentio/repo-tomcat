package com.hertz.herc.franchise.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogBroker {

	public static void debug (Class<?> classRef, String msg) {
		Logger logger = LoggerFactory.getLogger (classRef);
		logger.debug (msg);
	}

	public static void info (Class<?> classRef, String msg) {
		Logger logger = LoggerFactory.getLogger (classRef);
		logger.info (msg);
	}

	public static void warn (Class<?> classRef, String msg) {
		Logger logger = LoggerFactory.getLogger (classRef);
		logger.warn (msg);
	}

	public static void error (Class<?> classRef, String msg) {
		Logger logger = LoggerFactory.getLogger (classRef);
		logger.error (msg);
	}

	public static void fatal (Class<?> classRef, String msgId, String msg) {
		Logger logger = LoggerFactory.getLogger (classRef);
		logger.error (msgId, msg);
	}
}
