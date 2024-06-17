/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ngovinhthang.studentmanagement.util;

/**
 *
 * @author gnaht
 * @param <T>
 */

//interface chi co 1 ham abstract duy nhat 
//ta co the su dung bang cach tao class khac implement ham abstract
//hoac su dung lambda expression
//hoac dung anonymus class de implement 
//generic class dc xem nhu la 1 data type 
@FunctionalInterface
public interface Filter<T> {
    public boolean check(T x);
}
