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
			Iterator<IndiaCensusCSV> iterator = new OpenCSVBuilder().getCSVFileIterator(reader, IndiaCensusCSV.class);
			return getCount(iterator);
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
			Iterator<IndiaCodeCSV> iterator = new OpenCSVBuilder().getCSVFileIterator(reader, IndiaCodeCSV.class);
			return getCount(iterator);
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
	
	private <E> int getCount(Iterator<E> iterator) {
		Iterable<E> csvIterable = () -> iterator;
		int numOfRecords = (int) StreamSupport.stream(csvIterable.spliterator(), false).count();
		return numOfRecords;
	}
}
