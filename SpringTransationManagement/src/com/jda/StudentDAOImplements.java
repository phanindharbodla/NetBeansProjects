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
    * a record in the Student and Marks tables.
    */
   public void create(String name, Integer age, Integer marks, Integer year);
   /** 
    * This is the method to be used to list down
    * all the records from the Student and Marks tables.
    */
   public List<StudentPOJO> listStudents();
}