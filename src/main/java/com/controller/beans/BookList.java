package com.controller.beans;

import java.io.Serializable;
import java.util.List;

import com.business.abstracts.BookService;
import com.entities.concretes.Book;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
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
    private String success;
    
    @PostConstruct
    public void postConstruct() {
        booksAvailable = service.getAll();
        success = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("success");
    }
    
    public List<Book> getBooksAvailable() {
  
        return booksAvailable;
    }

	public void setBooksAvailable(List<Book> booksAvailable) {
		this.booksAvailable = booksAvailable;
	}    
    
	public void onPageLoad() {
		if(success!=null && success.equals("true")) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Kayıt Başarılı"));
		}
	}
    
}