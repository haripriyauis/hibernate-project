package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		//this is my second commit
		//this will be shown 
	//create session factory
		
		//this is third commit
		SessionFactory factory=new Configuration()
		                      .configure("hibernate.cfg.xml")
		                      .addAnnotatedClass(Student.class)
		                      .buildSessionFactory();
				                
		
	//create session
		Session session=factory.getCurrentSession();
		try{
			//craete a new student object
			System.out.println("create a new student object");
			Student tempStudent=new Student("Paul","Wall","paul@luv2code.com");
			
			//start a transaction
			session.beginTransaction();
			
			//save the student object
			System.out.println("saving the student object");
			session.save(tempStudent);
			//commit transaction
			session.getTransaction().commit();
			System.out.println("done");
			
		}
		
		finally{
			factory.close();
		}
		
		
		
		
		

	}

}
