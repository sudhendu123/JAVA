package com.sample.java.prgm;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;

public class CustomException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected String errorCode;
	private STATUS_CODE statusCode = STATUS_CODE.FAILURE;
	private String errorMessage;
	private List<String> errorParams;

	public CustomException(String errorCode, String errorMessage) {
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	public CustomException(String errorCode, STATUS_CODE statusCode, String errorMessage) {
		this.errorCode = errorCode;
		this.statusCode = statusCode;
		this.errorMessage = errorMessage;
	}

	public CustomException(String errorCode, String errorMessage, Throwable root) {
		super(root);
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	public CustomException(String errorCode, STATUS_CODE statusCode, String errorMessage, Throwable root) {
		super(root);
		this.errorCode = errorCode;
		this.statusCode = statusCode;
		this.errorMessage = errorMessage;
	}

	public CustomException(String errorCode, Throwable root) {
		super(root);
		this.errorCode = errorCode;
		this.errorMessage = root.getMessage();
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public STATUS_CODE getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(STATUS_CODE statusCode) {
		this.statusCode = statusCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public List<String> getErrorParams() {
		return errorParams;
	}

	public void setErrorParams(List<String> errorParams) {
		this.errorParams = errorParams;
	}

	public static enum STATUS_CODE {

		FAILURE(0), TIMEOUT(1);

		private int statusCode;

		STATUS_CODE(int statusCode) {
			this.statusCode = statusCode;
		}

		public int get() {
			return statusCode;
		}
	}

	private static void joinStackTrace(Throwable e, StringWriter writer) {
		PrintWriter printer = null;
		try {
			printer = new PrintWriter(writer);
			while (e != null) {
				printer.println(e);
				StackTraceElement[] trace = e.getStackTrace();
				for (StackTraceElement aTrace : trace) {
					printer.println("\tat " + aTrace);
				}
				e = e.getCause();
				if (e != null) {
					printer.println("Caused by:\r\n");
				}
			}
		} finally {
			if (printer != null)
				printer.close();
		}
	}

	private static String joinStackTrace(Throwable e) {
		StringWriter writer = null;
		try {
			writer = new StringWriter();
			joinStackTrace(e, writer);
			return writer.toString();
		} finally {
			if (writer != null)
				try {
					writer.close();
				} catch (IOException e1) {
					// ignore
				}
		}
	}

	@Override
	public String getMessage() {
		StringBuilder sb = new StringBuilder(100);
		sb.append("Error Code : ").append(errorCode).append(", Error Message : ").append(errorMessage)
				.append(", Cause : ").append(joinStackTrace(getCause()));
		return sb.toString();
	}
}
