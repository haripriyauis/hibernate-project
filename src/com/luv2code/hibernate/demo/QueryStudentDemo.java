package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;




import com.luv2code.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
	//create session factory
		SessionFactory factory=new Configuration()
		                      .configure("hibernate.cfg.xml")
		                      .addAnnotatedClass(Student.class)
		                      .buildSessionFactory();
				                
		
	//create session
		Session session=factory.getCurrentSession();
		try{
			
			//start a transaction
			session.beginTransaction();
			
			
			//query students
			List<Student> theStudents=session.createQuery("from Student").getResultList();
			
			//display students
			displayStudents(theStudents);
			
			//query student:last name="doe"
			theStudents=session.createQuery("from Student s where s.lastName='Doe'").list();
			
			//display students
			
			System.out.println("\n\n who have last name doe");
			displayStudents(theStudents);
			//commit transaction
			session.getTransaction().commit();
			System.out.println("done");
			
		}
		
		finally{
			factory.close();
		}
		
		
		
		
		

	}

	private static void displayStudents(List<Student> theStudents) {
		for(Student tempStudent:theStudents){
			System.out.println(tempStudent);
		}
	}

}
