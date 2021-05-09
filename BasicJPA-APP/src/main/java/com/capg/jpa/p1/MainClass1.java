package com.capg.jpa.p1;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.capg.jpa.p3.Insurance;
import com.capg.jpa.p3.LifeInsurance;
import com.capg.jpa.p3.MedicalInsurance;

public class MainClass1 {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		SessionFactory factory = cfg.configure().buildSessionFactory(); 
		
		System.out.println("1");
		
		Session session = factory.openSession();// jdbc -> coonection object
		Transaction t = session.beginTransaction();
		
		// ---- write code for data base operation ----
		
		Student s= new Student();
		s.setId(222);
		s.setName("Vaishnavi");
		s.setAge(20);
		s.setMarks(90);
		
		Course course = new Course("Java","JNTU");
		s.setTechnicalCourse(course);
		
		Course nontechnicalcourse = new Course("Sql","EduNext");
		s.setNontechnical_course(nontechnicalcourse);
		
		
		Certificate c1 = new Certificate("Edunext","java","EdUNext Platform");
		Certificate c2 = new Certificate("Rangdhe","Rangoli","Sankranthi_Event");
		Certificate c3 = new Certificate("Python Basic","python for everybody","Coursera");
		
		Set<Certificate> cerSet = new HashSet<Certificate>();
		cerSet.add(c1);
		cerSet.add(c2);
		cerSet.add(c3);
		s.setCertificate(cerSet);
		
		// ------------ One To One

				Laptop l = new Laptop(101,"HP");
				s.setLaptop(l);
				
        // ----------  One to Many Entry -----------
				
				com.capg.jpa.p1.Courses course1 = new com.capg.jpa.p1.Courses("java");
				com.capg.jpa.p1.Courses course2 = new com.capg.jpa.p1.Courses("sql");
				com.capg.jpa.p1.Courses course3 = new com.capg.jpa.p1.Courses("jpa");
				
				List<com.capg.jpa.p1.Courses> coursesList = Arrays.asList(course1,course2,course3);  // stream session
				
				s.setCourses(coursesList);		
		
				
		//------------------------
				Examination e1 = new InternalExam("EEI",25,14,22);
				Examination e2 = new ExternalExam("EEI",100,26,70);
				
				
				List<Examination> examList = Arrays.asList(e1,e2);
				s.setExamList(examList);
				
				
		session.save(s);  // insert into Account .....
		System.out.println("  -->> Data Saved ..");
		//------------getDetails--------//
		/*s = (Student)session.get(Student.class,111);
		  // 
			System.out.println(s);*/
		//--------------Update-------------//
			/*s = (Student)session.load(Student.class,111);
		    s.setName("Ramya");
		    session.saveOrUpdate(s);*/
		//-------------Delete-----------//
		/*s = (Student)session.load(Student.class,1);
		session.delete(s);*/
		t.commit();
		
		
		session.close();
		System.out.println("All Done");

	}

}
