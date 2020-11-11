package com.blz.censusanalyser;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CensusAnalyserTest {
	private static final String INDIA_CENSUS_CSV_FILE_PATH = "C:\\Users\\Muthyala Aishwarya\\Downloads\\IndiaStateCensusData.csv";
    private static final String WRONG_CENSUS_CSV_FILE_PATH = "F:\\Users\\Muthyala Aishwarya\\Downloads\\IndiaStateCensusData.csv";
    private static final String WRONG_CENSUS_FILE_TYPE_PATH = "C:\\Users\\Muthyala Aishwarya\\Downloads\\IndiaStateCensusData.txt";
    private static final String CENSUS_WRONG_DELIMITER_FILE_PATH = "C:\\Users\\Muthyala Aishwarya\\Downloads\\IndiaStateCensusData.csv";
    private static final String CENSUS_WITHOUT_HEADER_FILE_PATH = "C:\\Users\\Muthyala Aishwarya\\Downloads\\IndiaStateCensusData.csv";
    
    private static final String INDIA_CODE_CSV_FILE_PATH = "C:\\Users\\Muthyala Aishwarya\\Downloads\\IndiaStateCode.csv";
    private static final String WRONG_CODE_CSV_FILE_PATH = "F:\\Users\\Muthyala Aishwarya\\Downloads\\IndiaStateCode.csv";
    private static final String WRONG_CODE_FILE_TYPE_PATH = "C:\\Users\\Muthyala Aishwarya\\Downloads\\IndiaStateCode.txt";
    private static final String CODE_WRONG_DELIMITER_FILE_PATH = "C:\\Users\\Muthyala Aishwarya\\Downloads\\IndiaStateCode.csv";
    private static final String CODE_WITHOUT_HEADER_FILE_PATH = "C:\\Users\\Muthyala Aishwarya\\Downloads\\IndiaStateCode.csv";

    private static CensusAnalyser censusAnalyser;
    
    @BeforeClass
    public static void createCensusAnalyserObj() {
    	 CensusAnalyser censusAnalyser = new CensusAnalyser();
    }
    
    //TC 1.1
    @Test
    public void given_IndianCensusCSVFile_ReturnsCorrectRecords() {
        try {
            int numOfRecords = censusAnalyser.loadIndiaCensusData(INDIA_CENSUS_CSV_FILE_PATH);
            Assert.assertEquals(29,numOfRecords);
        } catch (CensusAnalyserException e) { }
    }
    
    @Test
    public void given_IndianCodeCSVFile_ReturnsCorrectRecords() {
        try {
            int numOfRecords = censusAnalyser.loadIndiaCodeData(INDIA_CODE_CSV_FILE_PATH);
            Assert.assertEquals(37,numOfRecords);
        } catch (CensusAnalyserException e) { }
    }

    //TC 1.2
    @Test
    public void given_IndiaCensusData_WithWrongFilePath_ShouldThrowException() {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            censusAnalyser.loadIndiaCensusData(WRONG_CENSUS_CSV_FILE_PATH);
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM, e.type);
        }
    }
    
    @Test
    public void given_IndiaCodeData_WithWrongFilePath_ShouldThrowException() {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            censusAnalyser.loadIndiaCodeData(WRONG_CODE_CSV_FILE_PATH);
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM, e.type);
        }
    }
    
    //TC 1.3
    @Test
    public void given_IndiaCensusData_WithWrongFileType_ShouldThrowException() {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            censusAnalyser.loadIndiaCensusData(WRONG_CENSUS_FILE_TYPE_PATH);
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.WRONG_FILE_TYPE, e.type);
        }
    }
    
    @Test
    public void given_IndiaCodeData_WithWrongFileType_ShouldThrowException() {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            censusAnalyser.loadIndiaCodeData(WRONG_CODE_FILE_TYPE_PATH);
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.WRONG_FILE_TYPE, e.type);
        }
    }
    
    //TC 1.4
    @Test
    public void given_IndiaCensusData_WithWrongFileDelimiter_ShouldThrowException() {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            censusAnalyser.loadIndiaCensusData(CENSUS_WRONG_DELIMITER_FILE_PATH);
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.NO_SUCH_FILE, e.type);
        }
    }
    
    @Test
    public void given_IndiaCodeData_WithWrongFileDelimiter_ShouldThrowException() {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            censusAnalyser.loadIndiaCodeData(CODE_WRONG_DELIMITER_FILE_PATH);
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.NO_SUCH_FILE, e.type);
        }
    }
    
    //TC 1.5
    @Test
    public void given_IndiaCensusData_WithoutHeader_ShouldThrowException() {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            censusAnalyser.loadIndiaCensusData(CENSUS_WITHOUT_HEADER_FILE_PATH);
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.NO_SUCH_FILE, e.type);
        }
    }
    
    @Test
    public void given_IndiaCodeData_WithoutHeader_ShouldThrowException() {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            censusAnalyser.loadIndiaCodeData(CODE_WITHOUT_HEADER_FILE_PATH);
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.NO_SUCH_FILE, e.type);
        }
    }
}
