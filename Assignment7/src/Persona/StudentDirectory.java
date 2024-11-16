/* 
* To change this license header, choose License Headers in Project Properties. 
* To change this template file, choose Tools | Templates 
* and open the template in the editor. 
*/ 
package Persona;

import java.util.ArrayList;

public class StudentDirectory {
    private ArrayList<Student> students;

    public StudentDirectory() {
        students = new ArrayList<>();  
    }

    public void addStudent(Student student) {
        students.add(student);  
    }

    public ArrayList<Student> getStudents() {
        return students;  
    }
}
