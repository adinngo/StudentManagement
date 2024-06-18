/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ngovinhthang.studentmanagement.dao;

import com.ngovinhthang.studentmanagement.ui.Menu;
import com.ngovinhthang.studentmanagement.util.Filter;
import com.ngovinhthang.studentmanagement.util.ValidInput;
import com.ngovinhthang.studentmangement.dto.Student;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author gnaht
 */
public class StudentManager {

    private final Scanner sc = new Scanner(System.in);
    Calendar calendar = Calendar.getInstance();
    private final int currYear = calendar.get(Calendar.YEAR);
    private final int validYear = currYear - 18;
    List<Student> list = new ArrayList();

    {
        list.add(new Student("SE999999", "NGUYEN A", 2009, 3.0));
        list.add(new Student("SE666666", "NGUYEN C", 2006, 2.5));
        list.add(new Student("SE555555", "NGUYEN H", 2005, 3.2));

        list.add(new Student("SE444444", "NGUYEN F", 2004, 4.0));
        list.add(new Student("SE777777", "NGUYEN E", 2007, 2.0));
        list.add(new Student("SE888888", "NGUYEN D", 2008, 2.9));

        list.add(new Student("SE222222", "NGUYEN B", 2002, 3.1));
        list.add(new Student("SE333333", "NGUYEN E", 2003, 3.5));
    }

    //lấy danh sách sinh viên
//    public List<Student> getAllStudents() {
//        return list;
//    }
    //hàm phụ trợ giúp tìm các id đã tồn tại
    //tìm kiếm sinh viên bằng id và trả về vị trí Sinh viên
    //quy ước: >=0 là tìm thấy, < 0 là k tìm thấy 
    private int searchStudentById(String id) {
        if (list.isEmpty()) {
            return -1;
        }
        for (int i = 0; i < list.size(); i++) {
            if (id.equalsIgnoreCase(list.get(i).getId())) {
                return i;
            }
        }
        return -1;
    }

    //tìm kiếm sinh viên bằng id và show profile
    public void searchStudentById() {
        if (list.isEmpty()) {
            System.out.println("The list of students is empty!!!");
        }
        Student x;
        String id;
        id = ValidInput.getString("Input student id: ", "Student id is required!!!");
        x = searchStudenObjecttById(id);
        if (x == null) {
            System.out.println("Not found!!!");
        } else {
            x.showProfile();
        }
    }

    //tìm kiếm sinh viên bằng id và trả về object Sinh viên
    private Student searchStudenObjecttById(String id) {
        if (list.isEmpty()) {
            return null;
        }

        for (int i = 0; i < list.size(); i++) {
            if (id.equalsIgnoreCase(list.get(i).getId())) {
                return list.get(i);
            }
        }
        return null;
    }

    //thêm 1 sinh viên
    public void AddNewStudent() {
        String id, name;
        int yob;
        double gpa;
        int pos;
        do {
            id = ValidInput.getID("Input student id(SE|XXXXXX): ",
                    "The format of id is SE|XXXXXX (X stands for a digit)", "^(?:SE|se)\\d{6}$");
            pos = searchStudentById(id);
            if (pos >= 0) {
                System.out.println("The student id is already exit!!!");
            }

        } while (pos >= 0);
        System.out.printf("Input your name: ");
        name = ValidInput.getString("Input name student: ", "Student name is required!!!").toUpperCase();
        yob = ValidInput.getAnInteger("Input student yob (1990..." + validYear + "): ",
                "Yob is from 2000.." + validYear + ")", 1990, validYear);
        gpa = ValidInput.getADouble("Input student GPA (GPA on a 4-point scale): ",
                "GPA from 1.0 -> 4.0", 1.0, 4.0);
        list.add(new Student(id, name, yob, gpa));
    }

    //show prolife tất cả các sinh viên 
    public void showProfileOfAllStudents() {
        for (var x : list) {
            x.showProfile();
        }
    }

    //update profile student 
    //không cho update id
    public void updateProfileStudent() {
        Student x;
        String id;
        id = ValidInput.getString("Input student id: ", "Student id is required!!!");
        x = searchStudenObjecttById(id);
        if (x == null) {
            System.out.println("Not found!!!");
        } else {
            x.showProfile();
            Menu menuUpdate = new Menu("Which option do you want to update?");
            menuUpdate.addNewOption("1.Update name");
            menuUpdate.addNewOption("2.Update GPA");
            menuUpdate.addNewOption("3.Update YOB");
            menuUpdate.addNewOption("4.Quit");
            int choice;
            do {

                menuUpdate.printMenu();
                choice = menuUpdate.getChoice();
                switch (choice) {
                    case 1 -> {
                        x.setName(ValidInput.getString("Input name student: ", "Student name is required!!!").toUpperCase());
                        System.out.println("Update info student successfully!");
                        x.showProfile();
                        break;
                    }
                    case 2 -> {
                        x.setGpa(ValidInput.getADouble("Input student GPA (GPA on a 4-point scale):"
                                + " ", "GPA from 1.0 -> 4.0", 1.0, 4.0));
                        System.out.println("Update info student successfully!");
                        x.showProfile();
                        break;

                    }
                    case 3 -> {
                        x.setYob(ValidInput.getAnInteger("Input student yob (1990..." + validYear + "): ",
                                "Yob is from 2000.." + validYear + ")", 1990, validYear));
                        System.out.println("Update info student successfully!");
                        x.showProfile();
                        break;

                    }
                    case 4 -> {
                        System.out.println("Exit update function");
                        break;
                    }
                }
            } while (choice != 4);
        }

    }

    public void removeStudent() {
        int pos;
        String id;
        id = ValidInput.getString("Input student id: ", "Student id is required!!!");
        pos = searchStudentById(id);
        if (pos == -1) {
            System.out.println("Not found!!!");
        } else {
            int answer;
            System.out.println("Are you sure?");
            System.out.println("1.yes | 2.No");
            answer = sc.nextInt();
            if (answer == 1) {
                list.remove(pos);
                System.out.println("Delete a student successfully!");
            }

        }
    }

    //sắp xếp tăng dần theo id
    //vì comparator là interface chỉ có 1 hàm abstract duy nhất
    // -> functional interface -> lambda expression 
    public void printStudentListAscById() {
        Collections.sort(list, (o1, o2) -> o1.getId().compareTo(o2.getId()));
        showProfileOfAllStudents();
    }

    //hàm phụ trợ lấy first name
    private String getFirstName(String name) {
        if (name.trim().indexOf(" ") > 0) {
            String firstName = name.substring(name.lastIndexOf(" ") + 1);
            return firstName;
        }
        return name;
    }

    //sắp xếp sinh viên theo tên
    public void printStudentListAscByName() {
        if (list.isEmpty()) {
            System.out.println("The list of students is empty!!!");
        }
        //interface comparator
        Collections.sort(list, (o1, o2) -> getFirstName(o1.getName()).
                compareTo(getFirstName(o2.getName())));
        showProfileOfAllStudents();

    }

    //sort ascending by gpa
    public void printStudentListAscByGpa() {
        if (list.isEmpty()) {
            System.out.println("The list of students is empty!!!");
        }
        Collections.sort(list, (o1, o2) -> Double.compare(o1.getGpa(), o2.getGpa()));
        showProfileOfAllStudents();
    }

    //ham phu tro
    private List<Student> getAllStudents(Filter<Student> filter) {
        List<Student> result = new ArrayList();
        for (var x : list) {
            if (filter.check(x)) {
                result.add(x);
            }
        }
        return result;
    }

    public void printStudentsGt3() {
        if (list.isEmpty()) {
            System.out.println("The list of students is empty!!!");
        }
        //dung` anonymus class
        Filter<Student> filter = new Filter<Student>() {
            @Override
            public boolean check(Student x) {
                return x.getGpa() >= 3.2;
            }
        };

        List<Student> result = new ArrayList();
        result = getAllStudents(filter); //DI denpency injection
        Collections.sort(result, (o1, o2) -> Double.compare(o1.getGpa(), o2.getGpa()));
        System.out.println("The list of students has GPA greater than or equal to 3.2");
       
        for (var x : result) {
            x.showProfile();
        }
    }
}
