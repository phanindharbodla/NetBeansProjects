/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jda;

/**
 *
 * @author Phanindhar Bodla
 */
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class StudentMapper implements RowMapper<StudentPOJO> {
   public StudentPOJO mapRow(ResultSet rs, int rowNum) throws SQLException {
      StudentPOJO student = new StudentPOJO();
      student.setId(rs.getInt("id"));
      student.setName(rs.getString("name"));
      student.setAge(rs.getInt("age"));
      return student;
   }
}