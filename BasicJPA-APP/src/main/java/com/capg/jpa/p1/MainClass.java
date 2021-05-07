package com.capg.jpa.p1;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration cfg = new Configuration();
		SessionFactory factory = cfg.configure().buildSessionFactory(); 
		
		System.out.println("1");
		
		Session session = factory.openSession();// jdbc -> coonection object
		Transaction t = session.beginTransaction();
		
		// ---- write code for data base operation ----
		
		Account a = new Account();
		//---------Insert--------------//
		a.setAccountHolderName("Ramya");
		a.setBalance(2000);
		a.setOpenningDate(LocalDate.now());
		Address address = new Address(801,"Hyderabad","Telangana");
		a.setAddress(address);
		
		Address officeaddress = new Address(21,"Begampet","Telangana");
		a.setOffice_address(officeaddress);
		  // insert into Account .....
		
		Policy p1 = new Policy("XYZ");
		Policy p2 = new Policy("ABC");
		Policy p3 = new Policy("uvw");
		
		List<Policy> policylist = Arrays.asList(p1,p2,p3);
		
		a.setPolicies(policylist);
		
		session.save(a);
		
		System.out.println("  -->> Data Saved ..");
		
		// HQL or JPQL List<?>
		//----------Get Details By Id------------//
					/*a = (Account)session.get(Account.class,1);
				  // 
					System.out.println(a);*/
		//-----------Update the details------------//
		  /*a = (Account)session.load(Account.class,101);
		  a.setAccountHolderName("Vaishnavi");
		  //session.update(a);
		  session.saveOrUpdate(a);
		  System.out.println(a);*/
		
		//-----------Delete the details-----------//
		  
		/*a = (Account)session.load(Account.class,1);
		session.delete(a);*/
		 
		t.commit();
		
		
		session.close();
		System.out.println("All Done");

	}

}
