package demo.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SLF4JConsoleTest {
	static final Logger LOG = LoggerFactory.getLogger(SLF4JConsoleTest.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SLF4JConsoleTest console = new SLF4JConsoleTest();
		console.execute();
		console.execute2();
	}

	public SLF4JConsoleTest() {
	}

	public void execute() {
		if (LOG.isTraceEnabled()) {
			LOG.trace("Test: TRACE level message.");
		}
		if (LOG.isDebugEnabled()) {
			LOG.debug("Test: DEBUG level message.");
		}
		if (LOG.isInfoEnabled()) {
			LOG.info("Test: INFO level message.");
		}
		if (LOG.isWarnEnabled()) {
			LOG.warn("Test: WARN level message.");
		}
		if (LOG.isErrorEnabled()) {
			LOG.error("Test: ERROR level message.");
		}
	}
	public void execute2() {
		LOG.trace("Test: TRACE level message.");
		LOG.debug("Test: DEBUG level message.");
		LOG.info("Test: INFO level message.");
		LOG.warn("Test: WARN level message.");
		LOG.error("Test: ERROR level message.");
	}
}
