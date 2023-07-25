package com.business.concretes;

import java.util.List;

import com.business.abstracts.BookService;
import com.dataAccess.abstracts.BookRepository;
import com.dataAccess.concretes.BookHibernateDao;
import com.entities.concretes.Book;

import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;

@Stateless
public class BookManager implements BookService{
	
	@EJB
	private BookRepository repository;

	@Override
	public String add(Book book) {
		book.setId(0);
		return repository.saveOrUpdate(book);
	}

	@Override
	public List<Book> getAll() {
		return repository.findAll();
	}

	@Override
	public Book getById(int id) {
		return repository.findById(id);
	}
	
	
}
