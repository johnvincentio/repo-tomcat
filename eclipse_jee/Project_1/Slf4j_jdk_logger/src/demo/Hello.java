package demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
use -Djava.util.logging.config.file=logging.properties
else
will default to the JRE's lib/logging.properties

Log levels:
SEVERE
WARNING
INFO
CONFIG
FINE
FINER
FINEST

SEVERE:
error NOT trace, info, debug, warn

WARNING:
warn, error NOT trace, info debug

INFO:
info, warn, error NOT trace, debug

CONFIG:
info, warn, error NOT trace, debug

FINE:
info, warn, debug, error NOT trace

FINER:
info, warn, debug, error NOT trace

FINEST:
trace, info, warn, debug, error

 */
public class Hello {
	static Logger LOGGER = LoggerFactory.getLogger(Hello.class);

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++)
			if (i % 2 == 0)
				LOGGER.info("Hello {}", i);
			else
				LOGGER.debug("I am on index {}", i);
		System.out.println("**********************");
		LOGGER.trace("is TRACE");
		LOGGER.info("is INFO");
		LOGGER.debug("is DEBUG");
		LOGGER.warn("is WARN");
		LOGGER.error("is ERROR");
	}
}
