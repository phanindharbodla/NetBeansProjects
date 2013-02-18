/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jda;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 *
 * @author Phanindhar Bodla
 */
public class School {
   private List teachersNames;
   private Set teachersIds;
   private Map timetable;
   private Properties teacherSubjects;

    public List getTeachersNames() {
        System.out.println(teachersNames);
        return teachersNames;
    }

    public Set getTeachersIds() {
        System.out.println(teachersIds);
        return teachersIds;
    }

    public Map getTimetable() {
        System.out.println(timetable);
        return timetable;
    }

    public Properties getTeacherSubjects() {
        System.out.println(teacherSubjects);
        return teacherSubjects;
    }

    public void setTeachersNames(List teachersNames) {
        this.teachersNames = teachersNames;
    }

    public void setTeachersIds(Set teachersIds) {
        this.teachersIds = teachersIds;
    }

    public void setTimetable(Map timetable) {
        this.timetable = timetable;
    }

    public void setTeacherSubjects(Properties teacherSubjects) {
        this.teacherSubjects = teacherSubjects;
    }
  

   
}
