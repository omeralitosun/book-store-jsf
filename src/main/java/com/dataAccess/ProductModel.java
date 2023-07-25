package com.dataAccess;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.entities.Product;

public class ProductModel {


	public String create(Product product) {	
		String result = "başarılı";
		Transaction transaction = null;
		Session session = null;
		try  {
			// start a transaction
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			// save the book objects
			session.merge(product);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			result = e.getMessage();
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			if(session != null) {
				session.close();
			}
		}
		
		return result;
	}

}