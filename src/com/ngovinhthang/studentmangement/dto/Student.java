/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ngovinhthang.studentmangement.dto;

/**
 *
 * @author gnaht
 */
public class Student {
    private String name, id;
    private int yob;
    private double gpa;
    
   
    
    public String getName() {
        return name;
    }

 



    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getYob() {
        return yob;
    }

    public void setYob(int yob) {
        this.yob = yob;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public Student(String id, String name, int yob, double gpa) {
        this.name = name;
        this.id = id;
        this.yob = yob;
        this.gpa = gpa;
        
    }

     @Override
    public String toString() {
        return "Student{" + "id=" + id + ", name=" + name + ", yob=" + yob + ", gpa=" + gpa + '}';
    }
    
    public void showProfile() {
        System.out.printf("|%-8s|%-25s|%4d|%4.1f|\n", 
                 id, name, yob, gpa);
    }
}
