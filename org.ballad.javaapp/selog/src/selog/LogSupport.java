package selog;

/**
 * SimplE LOG (SELOG) -- A lightweight log tool for Java.<br>
 * The global values doing support.
 * 
 * @author Ballad
 * @version 0.1 2011/11/17
 */
public class LogSupport {

	// LogType

	public final static int LOG_TYPE_CONSOLE = 2;

	public final static int LOG_TYPE_FILE = 1;

	// LogLevel

	public final static int LOG_LEVEL_FAULT = 3;

	public final static int LOG_LEVEL_ERROR = 2;

	public final static int LOG_LEVEL_TRACE = 1;

	// Default values

	public final static int LOG_DEFAULT_TYPE = LOG_TYPE_CONSOLE;

	public final static int LOG_DEFAULT_LEVEL = LOG_LEVEL_TRACE;

	// Support methods

	/**
	 * Private construction.
	 */
	private LogSupport() {

	}

	/**
	 * This method is not visible if out of the SELog.
	 */
	protected final static String getLevelWord(int logLevel) {
		String retStr = null;
		switch (logLevel) {
		case LOG_LEVEL_TRACE:
			retStr = " [TRACE] ";
			break;
		case LOG_LEVEL_ERROR:
			retStr = " [ERROR] ";
			break;
		case LOG_LEVEL_FAULT:
			retStr = " [FAULT] ";
			break;
		default:
			retStr = "";
			break;
		}
		return retStr;
	}
}
