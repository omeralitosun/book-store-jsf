package com.dataAccess.abstracts;

import java.util.List;

import com.entities.concretes.Book;

import jakarta.ejb.Local;

@Local
public interface BookRepository {
	
	String saveOrUpdate(Book book);
	List<Book> findAll();
	Book findById(int id);
	String delete(int id);
}
