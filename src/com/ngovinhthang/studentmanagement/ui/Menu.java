/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ngovinhthang.studentmanagement.ui;

import com.ngovinhthang.studentmanagement.util.ValidInput;
import java.util.ArrayList;

/**
 *
 * @author gnaht
 */
public class Menu {

    private String menuTitle;
    private ArrayList<String> optionList = new ArrayList();

    public Menu(String menuTitle) {
        this.menuTitle = menuTitle;
    }

    //tìm option và trả về vị trí 
    //hàm phụ trợ nên private
    //quy ước: >=0 là tìm thấy, <0 là k tìm thấy 
    private int searchOption(String option) {
        if (optionList.isEmpty()) {
            return -1;
        }
        for (int i = 0; i < optionList.size(); i++) {
            if (optionList.get(i).equalsIgnoreCase(option)) {
                return i;
            }
        }
        return -1;
    }

    public void addNewOption(String newOption) {
       
        optionList.add(newOption);
    }
    
    //in ra danh sách tính năng cho người dùng
    public void printMenu() {
        if(optionList.isEmpty())
            System.out.println("The menu is empty!!!");
        System.out.println("\n------------------------------------");
        System.out.println(menuTitle);
        for(var x : optionList){
            System.out.println(x);
        }
    }
    
    //có menu mới có lựa chọn. Hàm trả về con số người dùng chọn
    //ứng với chức năng mà người dùng muốn app thực thi
    public int getChoice() {
        int maxOption = optionList.size();
        //lựa chọn lớn nhất là số thứ tự ứng với số mục chọn
        String inputMsg = "Choose [1.." + maxOption + "]: ";
        String errorMsg = "You are required to choose the option 1.." + maxOption; 
        return ValidInput.getAnInteger(inputMsg, errorMsg, 1, maxOption);
        //in ra câu nhập: Choose[1..8]: , giả sử có 8 mục chọn trong
        //menu
    }

}
