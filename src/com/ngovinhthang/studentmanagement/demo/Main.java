/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ngovinhthang.studentmanagement.demo;

import com.ngovinhthang.studentmanagement.dao.StudentManager;
import com.ngovinhthang.studentmanagement.ui.Menu;

/**
 *
 * @author gnaht
 */
public class Main {

    public static void main(String[] args) {
        StudentManager sm = new StudentManager();
        Menu menu = new Menu("Welcome to Student Management System Console");
        menu.addNewOption("1.Add a new student");
        menu.addNewOption("2.Update profile student");
        menu.addNewOption("3.Remove a student");
        menu.addNewOption("4.Search student");
        menu.addNewOption("5.Show the profile of all students");
        menu.addNewOption("6.Print the student list ascending by id");
        menu.addNewOption("7.Print the student list ascending by name");
        menu.addNewOption("8.Print the student list ascending by Gpa");
        menu.addNewOption("9.Print the student list GPA greater than or equal 3.2");
        menu.addNewOption("10.Quit");
        int choice;
        do {
            menu.printMenu();
            choice = menu.getChoice();
            switch (choice) {
                case 1:
                    System.out.println("You are preparing to "
                            + "input a new student profile");
                    sm.AddNewStudent();
                    break;

                case 2:
                    System.out.println("You are required to input "
                            + "a student id to update");
                    sm.updateProfileStudent();
                    break;
                case 3:
                    System.out.println("You are required to input "
                            + "a student id to remove");
                    sm.removeStudent();
                    break;
                case 4:
                    System.out.println("You are required to input "
                            + "a student id to search");
                    sm.searchStudentById();
                    break;
                case 5:
                    System.out.println("The profile of all student");
                    sm.showProfileOfAllStudents();
                    break;
                case 6:
                    System.out.println("The profile of all student after sort ascending by id");
                    sm.printStudentListAscById();
                    break;
                case 7:
                    System.out.println("The profile of all student after sort ascending by name");
                    sm.printStudentListAscByName();
                    break;
                case 8:
                    sm.printStudentListAscByGpa();
                    break;
                case 9:
                    sm.printStudentsGt8();
                    break;
                case 10:
                    System.out.println("Bye bye, see you next time!");
                    break;
            }
        } while (choice != 10);

    }

}
