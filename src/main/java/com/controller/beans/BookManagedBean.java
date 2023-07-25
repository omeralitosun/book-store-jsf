package com.controller.beans;

import java.io.Serializable;

import com.business.abstracts.BookService;
import com.entities.concretes.Book;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;

@Named
@RequestScoped
public class BookManagedBean implements Serializable{

	private static final long serialVersionUID = 1L;
	@EJB
	private BookService service;
	private Book book;
	private String result = "None";
	
	@PostConstruct
    public void postConstruct() {
        String bookIdParam = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
        book = new Book();
        this.result="Noneee";
        if (bookIdParam != null) {
        	int bookId;
            bookId = Integer.parseInt(bookIdParam);
            book = service.getById(bookId);
        }
    }
	
	public String add() {
		this.result = service.add(book);
		return "newbook";
	}
	
	public String get() {
		//this.book = service.getById(1);
		this.book = service.getAll().get(1);
		return "newbook";
	}
	
	public String getResult() {
		return result;
	}



	public void setResult(String result) {
		this.result = result;
	}



	public Book getBook() {
		return book;
	}


	public void setBook(Book book) {
		this.book = book;
	}
}
