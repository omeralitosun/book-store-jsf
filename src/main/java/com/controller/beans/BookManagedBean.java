package com.controller.beans;

import java.io.Serializable;

import com.business.abstracts.BookService;
import com.entities.concretes.Book;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.ExternalContext;
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
	
	public void add() {
		book.setId(0);
		service.add(book);		
		goToIndexPage();
	}
	public void update() {
		service.update(book.getId(),book);
		goToIndexPage();
	}
	
	public void delete() {
		service.delete(book.getId());
		goToIndexPage();
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}
	
	public void goToIndexPage() {
		try {
			ExternalContext ec = FacesContext.getCurrentInstance()
			        .getExternalContext();
		    ec.redirect(ec.getRequestContextPath()+"?success=true");    
		} catch (Exception e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		}
	}
}
