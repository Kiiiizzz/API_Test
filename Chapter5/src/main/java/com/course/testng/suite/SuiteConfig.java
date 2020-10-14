package com.course.testng.suite;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class SuiteConfig {

    @BeforeSuite
    public void aa(){
        System.out.println("BeforeSuite运行了");
    }

    @AfterSuite
    public void aaa(){
        System.out.println("AfterSuite运行了");
    }

    @BeforeTest
    public void  bbb(){
        System.out.println("BeforeTest运行了111111111111");
    }

    @AfterTest
    public void  bbb1(){
        System.out.println("AfterTest运行了111111111111");
    }
}
