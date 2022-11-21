package MyTests.Class22;

import org.testng.annotations.Test;

public class InvocationCountTest {

    @Test(invocationCount = 100)
    public void getUserInfoTest(){
        System.out.println("Simple test");
    }
}
