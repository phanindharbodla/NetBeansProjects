/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jda;

/**
 *
 * @author Phanindhar Bodla
 */
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
   public static void main(String[] args) {
      ApplicationContext context = 
             new ClassPathXmlApplicationContext("com/jda/beans.xml");

      StudentDAO dao = 
      (StudentDAO)context.getBean("studentJDBCTemplate");
      
      System.out.println("------Records Creation--------" );
      dao.create("Zara", 11);
      dao.create("Nuha", 2);
      dao.create("Ayan", 15);

      System.out.println("------Listing Multiple Records--------" );
      List<StudentPOJO> students = dao.listStudents();
      for (StudentPOJO record : students) {
         System.out.print("ID : " + record.getId() );
         System.out.print(", Name : " + record.getName() );
         System.out.println(", Age : " + record.getAge());
      }

      System.out.println("----Updating Record with ID = 2 -----" );
      dao.update(2, 20);

      System.out.println("----Listing Record with ID = 2 -----" );
      StudentPOJO student = dao.getStudent(2);
      System.out.print("ID : " + student.getId() );
      System.out.print(", Name : " + student.getName() );
      System.out.println(", Age : " + student.getAge());
	  
   }
}