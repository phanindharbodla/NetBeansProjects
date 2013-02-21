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
import javax.sql.DataSource;

public interface StudentDAOImplements {
   /** 
    * This is the method to be used to initialize
    * database resources ie. connection.
    */
   public void setDataSource(DataSource ds);
   /** 
    * This is the method to be used to create
    * a record in the StudentPOJO table.
    */
   public void create(String name, Integer age);
   /** 
    * This is the method to be used to list down
    * a record from the StudentPOJO table corresponding
    * to a passed student id.
    */
   public StudentPOJO getStudent(Integer id);
   /** 
    * This is the method to be used to list down
    * all the records from the StudentPOJO table.
    */
   public List<StudentPOJO> listStudents();
   /** 
    * This is the method to be used to delete
    * a record from the StudentPOJO table corresponding
    * to a passed student id.
    */
   public void delete(Integer id);
   /** 
    * This is the method to be used to update
    * a record into the StudentPOJO table.
    */
   public void update(Integer id, Integer age);
}