package test;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class test1 {

    @Test
    public void test01(){
        Assert.assertEquals(1, 1);
    }

    @Test
    public void test02(){
        Assert.assertEquals("aaa", "aaa");
    }

    @Test
    public void test03(){
        Reporter.log("日之日止");
        throw new RuntimeException("运行时异常");
    }
}
