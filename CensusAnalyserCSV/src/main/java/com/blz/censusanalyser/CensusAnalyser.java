package com.blz.censusanalyser;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.stream.StreamSupport;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class CensusAnalyser {
	static int numOfRecords = 0;
	public int loadIndiaCensusData(String csvFilePath) throws CensusAnalyserException {
		try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath))) {
			Iterator<IndiaCensusCSV> iterator = this.getCSVFileIterator(reader, IndiaCensusCSV.class);
			Iterable<IndiaCensusCSV> iterable = () -> iterator;
			numOfRecords = (int) StreamSupport.stream(iterable.spliterator(), false).count();
		} catch (NoSuchFileException e) {
			if (!csvFilePath.contains(".csv")) {
				throw new CensusAnalyserException(e.getMessage(),
						CensusAnalyserException.ExceptionType.WRONG_FILE_TYPE);
			}
		} catch (IOException e) {
			throw new CensusAnalyserException(e.getMessage(),
					CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM);
		}
		return numOfRecords;
	}

	public int loadIndiaCodeData(String csvFilePath) throws CensusAnalyserException {
		try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath))) {
			Iterator<IndiaCodeCSV> iterator = this.getCSVFileIterator(reader, IndiaCodeCSV.class);
			Iterable<IndiaCodeCSV> iterable = () -> iterator;
			numOfRecords = (int) StreamSupport.stream(iterable.spliterator(), false).count();
		} catch (NoSuchFileException e) {
			if (!csvFilePath.contains(".csv")) {
				throw new CensusAnalyserException(e.getMessage(),
						CensusAnalyserException.ExceptionType.WRONG_FILE_TYPE);
			}
		} catch (IOException e) {
			throw new CensusAnalyserException(e.getMessage(),
					CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM);
		}
		return numOfRecords;
	}

	private <E> Iterator<E> getCSVFileIterator(Reader reader, Class csvClass) throws CensusAnalyserException {
		try {
			CsvToBeanBuilder<E> csvToBeanBuilder = new CsvToBeanBuilder<>(reader);
			csvToBeanBuilder.withType(csvClass);
			csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
			CsvToBean<E> csvToBean = csvToBeanBuilder.build();
			return csvToBean.iterator();
		} catch (RuntimeException e) {
			throw new CensusAnalyserException(e.getMessage(), CensusAnalyserException.ExceptionType.NO_SUCH_FILE);
		}
	}
}
