package com.business.abstracts;

import java.util.List;

import com.entities.concretes.Book;

import jakarta.ejb.Local;

@Local
public interface BookService {
	String add(Book book);
	List<Book> getAll();
	Book getById(int id);
	String update(int id,Book book);
	String delete(int id);
}
