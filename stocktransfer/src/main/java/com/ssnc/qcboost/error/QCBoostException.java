package com.ssnc.qcboost.error;

public class QCBoostException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final String errorMessage;
	private final int errorCode;

	public QCBoostException(int code, String message) {
		super(message);
		this.errorCode = code;
		this.errorMessage = message;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public int getErrorCode() {
		return errorCode;
	}

}
