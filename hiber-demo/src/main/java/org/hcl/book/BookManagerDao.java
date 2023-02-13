package org.hcl.book;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class BookManagerDao {
	SessionFactory sessionFactory;
	final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();

	protected void setup() {
		try {
		   sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		} catch (Exception ex) {
		    StandardServiceRegistryBuilder.destroy(registry);
		}
    }
 
    protected void exit() {
    }
 
    protected void create() {
    	 Book book = new Book();
    	    book.setTitle("Effective Java");
    	    book.setAuthor("Joshua Bloch");
    	    book.setPrice(32.59f);
    	 
    	    Session session = sessionFactory.openSession();
    	    session.beginTransaction();
    	 
    	    session.save(book);
    	 
    	    session.getTransaction().commit();
    	    session.close();
    }
 
    protected void read() {
    	 Session session = sessionFactory.openSession();
    	 
    	    long bookId = 1;
    	    Book book = session.get(Book.class, bookId);
    	 
    	    System.out.println("Title: " + book.getTitle());
    	    System.out.println("Author: " + book.getAuthor());
    	    System.out.println("Price: " + book.getPrice());
    	 
    	    session.close();

    }
 
    protected void update() {
    	 Book book = new Book();
    	 
    	    book.setId(20);
    	    book.setTitle("Ultimate Java Programming");
    	    book.setAuthor("Nam Ha Minh");
    	    book.setPrice(19.99f);
    	 
    	    Session session = sessionFactory.openSession();
    	    session.beginTransaction();
    	 
    	    session.update(book);
    	 
    	    session.getTransaction().commit();
    	    session.close();
    }
    
 
    protected void delete() {
    	 Book book = new Book();
    	    book.setId(20);
    	 
    	    Session session = sessionFactory.openSession();
    	    session.beginTransaction();
    	 
    	    session.delete(book);
    	 
    	    session.getTransaction().commit();
    	    session.close();
    }
 
	public static void main(String args[]) {
		BookManagerDao bmdao=new BookManagerDao();
		bmdao.setup();
		bmdao.create();
		bmdao.read();
		bmdao.update();
		bmdao.read();
		bmdao.delete();
		bmdao.read();
	}
	
}
