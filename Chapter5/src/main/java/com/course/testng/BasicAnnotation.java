package com.course.testng;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BasicAnnotation {
    @Test
    public void testCase1(){
        System.out.println("用例1");
    }
    @Test
    public void testCase5(){
        System.out.println("用例2");
    }
    @BeforeMethod
    public void testCase2(){
        System.out.println("之前");
    }
    @AfterMethod
    public void testCase3(){
        System.out.println("之后");
    }
}
