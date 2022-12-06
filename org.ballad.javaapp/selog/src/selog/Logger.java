package selog;

/**
 * SimplE LOG (SELOG) -- A lightweight log tool for Java.
 * <p>
 * Common Logger, Java SE Program can use this Class.
 * </p>
 * <p>
 * When using this class, you shall call this class in this way when your
 * program starts:<br>
 * <code>Logger.initLogger(projcetName,logLevel,logType,logFileName);</code>
 * <br>
 * To print a log: <br>
 * <code>Logger logger = Logger.getLogger(); <br>
 * logger.trace("This is a Test Log Content");</code><br>
 * when your program ends, you need call this function:<br>
 * <code>Logger.close(); </code><br>
 * Above are sample codes.
 * </p>
 * 
 * @author Ballad
 * @version 0.1 2011/11/17
 */
public class Logger extends BasicLogger {

	/**
	 * The singleton Logger instance.
	 */
	private static Logger logger = null;

	/**
	 * Private default construction.
	 */
	private Logger() {

	}

	/**
	 * Private construction.
	 */
	private Logger(String name) {
		super(name);
	}

	// //////////////////////////////////////////////////////////////////////////////
	// Below are public methods.

	/**
	 * Call this function when you program start. If you don't call this
	 * function, well, the Logger will use the default setting, to see default
	 * setting, you can see {@link #LogSupport}. You shall not call this method
	 * more than one time, well, if you call this method many times, the
	 * configuration of Logger will use the last time's call's parameters.
	 */
	public static synchronized Logger initLogger(String projcetName,
			int logLevel, int logType, String logFileName) {
		if (logger == null) {
			logger = new Logger(projcetName);
		}
		initLogConfig(logLevel, logType, logFileName);
		return logger;
	}

	/**
	 * This method is used for getting the Logger Instance.
	 * 
	 * @return Logger Instance
	 */
	public static synchronized Logger getLogger() {
		if (logger == null) {
			logger = new Logger();
		}
		return logger;
	}

	/**
	 * This method is used for getting the Logger Instance.
	 * 
	 * @param projectName
	 * @return Logger Instance
	 */
	public static synchronized Logger getLogger(String projectName) {
		if (logger == null) {
			logger = new Logger(projectName);
		}
		return logger;
	}

	/**
	 * This method is used for print the log's content in trace level.
	 * 
	 * @param logCont
	 */
	public void trace(String logCont) {
		if (logLevel > LogSupport.LOG_LEVEL_TRACE) {
			return;
		}
		print(logCont);
	}

	/**
	 * This method is used for print the log's content in error level.
	 * 
	 * @param logCont
	 */
	public void error(String logCont) {
		if (logLevel > LogSupport.LOG_LEVEL_ERROR) {
			return;
		}
		print(logCont);
	}

	/**
	 * This method is used for print the log's content in fault level.
	 * 
	 * @param logCont
	 */
	public void fault(String logCont) {
		// Now, the fault level is the highest level, so below codes means
		// nothing.
		// if (logLevel > LogSupport.LOG_LEVEL_FAULT) {
		// return;
		// }
		print(logCont);
	}

	public void close() {
		closeLogConfig();
		logger = null;
	}
}
