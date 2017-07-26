package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
	//create session factory
		SessionFactory factory=new Configuration()
		                      .configure("hibernate.cfg.xml")
		                      .addAnnotatedClass(Student.class)
		                      .buildSessionFactory();
				                
		
	//create session
		Session session=factory.getCurrentSession();
		try{
			//craete a new student object
			System.out.println("create a new student object");
			Student tempStudent=new Student("Daffy","Duck","daffy@luv2code.com");
			
			//start a transaction
			session.beginTransaction();
			
			//save the student object
			System.out.println("saving the student object");
			System.out.println(tempStudent);
			session.save(tempStudent);
			//commit transaction
			session.getTransaction().commit();
			
			//my new code
			System.out.println("Saved Student.Genearted id: "+ tempStudent.getId());
			
			//get a session and start transaction
			session=factory.getCurrentSession();
			session.beginTransaction();
			
			
			//retrieve student based on id:primary key
			System.out.println("\nGetting student with id:"+tempStudent.getId());
			
			Student myStudent=session.get(Student.class,tempStudent.getId());
			
			System.out.println("Get complete:"+myStudent);
			//commit transaction
			session.getTransaction().commit();
			
			
			
			System.out.println("done");
			
		}
		
		finally{
			factory.close();
		}
		
		
		
		
		

	}

}
