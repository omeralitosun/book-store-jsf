package com.dataAccess.concretes;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.configuration.HibernateUtil;
import com.dataAccess.abstracts.BookRepository;
import com.entities.concretes.Book;
import com.entities.enums.Genre;

import jakarta.ejb.Stateless;

@Stateless
public class BookHibernateDao implements BookRepository{
	
	
	@Override
	public String saveOrUpdate(Book book) {
		Transaction transaction = null;
		Session session = null;
		String result = "Başarılı";
		try  {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.merge(book);
			transaction.commit();
		} catch (Exception e) {
			result="Başarısız";
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} 
		return result;
	}

	@Override
	public List<Book> findAll() {
		Session session = null;
		List<Book> books=null;
		try  {
			session = HibernateUtil.getSessionFactory().openSession();
			books = session.createQuery("from Book", Book.class).getResultList();
		} catch (Exception e) {
			books.add(new Book(1, "exception", "saddsasad", "asddasdsa", Genre.Korku, 1));
			e.printStackTrace();
		} 
		
		return books;
	}

	@Override
	public Book findById(int id) {
		Session session = null;
		Book book=null;
		try  {
			session = HibernateUtil.getSessionFactory().openSession();
			book = session.get(Book.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return book;
	}

	@Override
	public String delete(int id) {
		Transaction transaction = null;
		Session session = null;
		String result = "Başarılı";
		try  {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Book book = session.get(Book.class, id);
			if(book != null) {
				session.remove(book);
			}
			transaction.commit();
		} catch (Exception e) {
			result="Başarısız";
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} 
		return result;
	}

}
