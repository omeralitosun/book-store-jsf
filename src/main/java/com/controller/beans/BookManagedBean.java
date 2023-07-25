package com.controller.beans;

import java.io.Serializable;

import com.business.abstracts.BookService;
import com.entities.concretes.Book;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

@Named
@ViewScoped
public class BookManagedBean implements Serializable{

	private static final long serialVersionUID = 1L;
	@EJB
	private BookService service;
	private Book book;
	
	@PostConstruct
    public void init() {
        String bookIdParam = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
        book = new Book();
        if (bookIdParam != null) {
        	int bookId;
            bookId = Integer.parseInt(bookIdParam);
            book = service.getById(bookId);
        }
    }
	
	public String add() {
		book.setId(0);
		service.add(book);
		return "index";
	}
	public String update() {
		service.update(book.getId(),book);
		return "index";
	}
	
	public String delete() {
		service.delete(book.getId());
		return "index";
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}
}
