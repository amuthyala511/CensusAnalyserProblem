package com.blz.censusanalyser;


public class CSVBuilderException extends Exception {
	enum ExceptionType {
		CENSUS_FILE_PROBLEM, WRONG_FILE_TYPE, NO_SUCH_FILE, NO_SUCH_FIELD
	}
	
	public CensusAnalyserException.ExceptionType type;

	public CSVBuilderException(String message, CensusAnalyserException.ExceptionType type) {
		super(message);
		this.type = type;
	}

	public CSVBuilderException(String message, CensusAnalyserException.ExceptionType type, Throwable cause) {
		super(message);
		this.type = type;
	}
}
