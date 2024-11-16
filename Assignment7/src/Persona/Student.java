/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persona;

public class Student {
    private String studentId;
    private StudentProfile profile;

    public Student(String studentId) {
        this.studentId = studentId;
        this.profile = new StudentProfile(this);
    }

    public String getStudentId() {
        return studentId;
    }

    public StudentProfile getProfile() {
        return profile;
    }
}