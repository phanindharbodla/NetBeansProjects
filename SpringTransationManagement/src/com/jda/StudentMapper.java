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

      StudentPOJO studentMarks = new StudentPOJO();

      studentMarks.setId(rs.getInt("id"));
      studentMarks.setName(rs.getString("name"));
      studentMarks.setAge(rs.getInt("age"));
      studentMarks.setSid(rs.getInt("sid"));
      studentMarks.setMarks(rs.getInt("marks"));
      studentMarks.setYear(rs.getInt("year"));

      return studentMarks;
   }
}