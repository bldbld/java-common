package selog.test;

import selog.LogSupport;
import selog.Logger;

public class SeLogTest {

	public static void initTest() {
		Logger logger = Logger.initLogger("LogTest",
				LogSupport.LOG_LEVEL_TRACE, LogSupport.LOG_TYPE_FILE,
				"logfiletest.log");
		logger.trace("This is Trace Test");
	}

	public static void main(String[] args) {
		SeLogTest.initTest();
	}
}
