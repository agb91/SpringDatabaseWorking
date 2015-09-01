package it.html.spring.client;
 

import java.util.List;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import it.html.spring.book.Cosa;
import it.html.spring.book.CosaDao;


public class BookClient {
	public static void main(String[] args) {
		
	    BeanFactory ctx = new XmlBeanFactory(new ClassPathResource("beans.xml"));														
	    CosaDao cosaDao = (CosaDao)ctx.getBean("CosaDao");
	    
	    // Delete
	    cosaDao.delete("1234567890123");
	    cosaDao.delete("1234567890321");
	    cosaDao.delete("primo");
	    cosaDao.delete("secondo");
	    	    
	    //Insert Promessi Sposi
	    Cosa cosa = new Cosa();
	    cosa.setNome("primo");
	    cosa.setEta("23");
	    cosaDao.insert(cosa);
	    System.out.println("Inserito:\t" + cosa);
	    	    	    
	    // Insert Il Barone Rampante
	    cosa = new Cosa();
	    cosa.setNome("secondo");
	    cosa.setEta("33");	    
	    cosaDao.insert(cosa);
	    System.out.println("Inserito:\t" + cosa);
	    
	    //Find Promessi Sposi
	    cosa = cosaDao.findByNome("primo");
	    System.out.println("Trovato:\t" + cosa);
	    	  
	    //Update Promessi Sposi
	    cosa.setEta("99");
	    cosaDao.update(cosa);
	    System.out.println("Modificato:\t" + cosa);
	    
	    int rowCount = cosaDao.bookCount();
	    System.out.println("Numero Persone: " + rowCount);  
	    
	    System.out.println("Lista Persone:");
	    List<Cosa> cosas = cosaDao.findAllBooks();
	    for (Cosa b : cosas)
	    	System.out.println("\t\t"+b);	    	 	 	    		    	    	    	    	 
	}	
}
