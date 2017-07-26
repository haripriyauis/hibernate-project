package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
	//create session factory
		SessionFactory factory=new Configuration()
		                      .configure("hibernate.cfg.xml")
		                      .addAnnotatedClass(Student.class)
		                      .buildSessionFactory();
				                
		
	//create session
		Session session=factory.getCurrentSession();
		try{
			
			
			int studentId=1;
			
			
			//get a session and start transaction
			session=factory.getCurrentSession();
			session.beginTransaction();
			
			
			
			
			//retrieve student based on id:primary key
			System.out.println("\nGetting student with id:"+studentId);
			
			Student myStudent=session.get(Student.class,studentId);
			
			System.out.println("Updating student");
			myStudent.setFirstName("scooby");
			
			//commit transaction
			session.getTransaction().commit();
			//new code
			
			session=factory.getCurrentSession();
			session.beginTransaction();
			
			//update email for students
			System.out.println("update email for all students");
			session.createQuery("update Student set email='foo@gmail.com'").executeUpdate();
			session.getTransaction().commit();
			
			System.out.println("done");
			
		}
		
		finally{
			factory.close();
		}
		
		
		
		
		

	}

}
