package MyCollections;

import org.junit.Assert;
import org.junit.Test;

public class TestUnit2 {

    public static int sum(int a,int b){
        return a+b;
    }

    @Test
    public void testSum(){
        Assert.assertEquals(sum(1,2),6);
    }

    @Test
    public void test2(){
        Assert.assertEquals(sum(1,2),3);
    }
}
