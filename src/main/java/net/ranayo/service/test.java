package net.ranayo.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.web.bind.annotation.GetMapping;

import net.ranayo.model.user;

public class test {

	@GetMapping("/test/db")
	public String goTest() {
		EntityManagerFactory emf =
				Persistence.createEntityManagerFactory("ranayoDB");
		
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		try {
			user user = new user();
			user.setUsEmail("wjdals644");
			user.setUsPasswd("123123123");
			user.setUsAuth(70);
			
			System.out.println(user.toString());
			
			em.persist(user); // 쿼리실행
			
		}
		catch(Exception e) {
			e.printStackTrace();
			et.rollback();
		}
		finally {
			et.commit();
		}
		
		em.close();
		emf.close();
		return "test";
		
	}
	
}
