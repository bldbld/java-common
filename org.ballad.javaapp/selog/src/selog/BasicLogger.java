package selog;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

/**
 * SimplE LOG (SELOG) -- A lightweight log tool for Java.
 * <p>
 * Basic Logger, define the basic output method and type, new Logger can extend
 * this class.
 * </p>
 * <p>
 * <em>The {@link #Logger} class extends from this class, so if you have question,
 * you can see this class.</em>
 * </p>
 * 
 * @author Ballad
 * @version 0.1 2011/11/17
 */
public abstract class BasicLogger {

	/**
	 * The project name your want to print in log.
	 */
	protected String projectName;

	/**
	 * The level of print log.
	 * 
	 * @see LogSupport
	 */
	protected static int logLevel = LogSupport.LOG_DEFAULT_LEVEL;

	/**
	 * The type of print log.
	 * 
	 * @see LogSupport
	 */
	protected static int logType = LogSupport.LOG_DEFAULT_TYPE;

	/**
	 * The FileWriter for output the log in file.<br>
	 * 
	 * @see FileWriter
	 */
	private static FileWriter fileWriter;

	/**
	 * The name of log file if the log printed in file.
	 */
	private static String logFileName;

	/**
	 * Default Constructor.
	 */
	protected BasicLogger() {

	}

	/**
	 * Constructor with evaluate the projcetName.
	 * 
	 * @param name
	 */
	protected BasicLogger(String name) {
		projectName = name;
	}

	/**
	 * When program start, call this initial method.
	 * 
	 * @param logLevelPara
	 * @param logTypePara
	 * @param logFileNamePara
	 */
	protected static void initLogConfig(int logLevelPara, int logTypePara,
			String logFileNamePara) {

		logLevel = logLevelPara;
		logType = logTypePara;
		logFileName = logFileNamePara;

		if (logType == LogSupport.LOG_TYPE_FILE) {
			try {
				fileWriter = new FileWriter(new File(logFileName), true);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Print the log.
	 * 
	 * @param logCont
	 */
	protected void print(String logCont) {
		
		String logFullCont = "SELog: " + new Date() + ", Projcet "
				+ projectName + LogSupport.getLevelWord(logLevel) + ": "
				+ logCont + "\n";
		if (logType == LogSupport.LOG_TYPE_FILE) {
			printToFile(logFullCont);
		} else if (logType == LogSupport.LOG_TYPE_CONSOLE) {
			printToConsole(logFullCont);
		} else {
			// Bad logType.
		}
	}

	/**
	 * Print the log's content to console.
	 * 
	 * @param logFullCont
	 */
	private void printToConsole(String logFullCont) {

		if (logLevel == LogSupport.LOG_LEVEL_TRACE) {
			System.out.println(logFullCont);
		} else {
			// Contain: LEVEL_ERROR & LEVEL_FAULT
			System.err.println(logFullCont);
		}
	}

	/**
	 * Print the log's content to file.
	 * 
	 * @param logFullCont
	 */
	protected void printToFile(String logFullCont) {
		try {
			fileWriter.write(logFullCont);
			fileWriter.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * When program exit, call this method to close the FileWriter.
	 */
	protected void closeLogConfig() {
		try {
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
