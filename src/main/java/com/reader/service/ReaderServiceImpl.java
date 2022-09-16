package com.reader.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reader.model.PurchagedBook;
import com.reader.model.Reader;
import com.reader.repository.PurchagedBookRepo;
import com.reader.repository.ReaderRepository;

@Service
public class ReaderServiceImpl implements IReaderService{

	@Autowired
	ReaderRepository readerRepo;

	@Autowired
	PurchagedBookRepo pbRepo;
	
	@Override
	public Long createReader(Reader reader) {
		Reader newReader = readerRepo.save(reader);
		Long bookId = reader.getBookId();
		PurchagedBook pbook = new PurchagedBook(bookId);
		pbook.setBookId(reader.getBookId());
		PurchagedBook nbook = pbRepo.save(pbook);
		return newReader.getrId();
	}

}