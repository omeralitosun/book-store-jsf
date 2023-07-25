package com.controller.beans;

import java.io.Serializable;
import java.util.List;

import com.business.abstracts.BookService;
import com.entities.concretes.Book;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

@Named
@ViewScoped
public class BookList implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB
    private BookService service;
    private List<Book> booksAvailable;
    
    @PostConstruct
    public void postConstruct() {
        booksAvailable = service.getAll();
    }
    
    public List<Book> getBooksAvailable() {
        return booksAvailable;
    }

	public void setBooksAvailable(List<Book> booksAvailable) {
		this.booksAvailable = booksAvailable;
	}    
    
    
}