package com.blz.censusanalyser;

import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class CommonCSVBuilder implements ICSVBuilder {

	@Override
	public List getCSVFileIterator(Reader reader, Class csvClass) throws CSVBuilderException {
		try {
			CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withHeader(csvClass).withIgnoreHeaderCase());
			List<CSVRecord> csvList = csvParser.getRecords();
			return csvList;
		} catch (IOException e) {
			throw new CSVBuilderException(e.getMessage(), CSVBuilderException.ExceptionType.UNABLE_TO_PARSE);
		}
	}
}
