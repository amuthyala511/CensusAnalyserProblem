package com.blz.censusanalyser;

import java.io.Reader;
import java.util.Iterator;
import java.util.List;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class OpenCSVBuilder<E> implements ICSVBuilder {

	@Override
	public List getCSVFileIterator(Reader reader, Class csvClass) throws CSVBuilderException {
		return getCsvBean(reader, csvClass).parse();
	}
	
	public <E> CsvToBean<E> getCsvBean(Reader reader, Class<E> csvClass) {
		CsvToBeanBuilder<E> csvToBeanBuilder = new CsvToBeanBuilder<>(reader);
		csvToBeanBuilder.withType(csvClass);
		csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
		return csvToBeanBuilder.build();
	}
}
