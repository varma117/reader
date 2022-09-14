package com.reader.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.reader.model.Reader;
import com.reader.repository.ReaderRepository;

@Service
public class ReaderServiceImpl implements IReaderService{

	@Autowired
	ReaderRepository readerRepo;

	@Override
	public Long createReader(Reader reader) {
		Reader newReader = readerRepo.save(reader);
		return newReader.getrId();
	}
		

}