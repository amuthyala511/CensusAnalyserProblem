package com.blz.censusanalyser;

public class CensusAnalyserException extends Exception {

	enum ExceptionType {
		CENSUS_FILE_PROBLEM, WRONG_FILE_TYPE, NO_SUCH_FILE, UNABLE_TO_PARSE
	}

	public ExceptionType type;

	public CensusAnalyserException(String message, ExceptionType type) {
		super(message);
		this.type = type;
	}

	public CensusAnalyserException(String message, ExceptionType type, Throwable cause) {
		super(message);
		this.type = type;
	}
}
