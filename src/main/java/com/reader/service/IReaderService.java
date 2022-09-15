package com.reader.service;

import org.springframework.stereotype.Component;

import com.reader.model.PurchagedBook;
import com.reader.model.Reader;

@Component
public interface IReaderService {

	public Long createReader(Reader reader,PurchagedBook pbook);
}
