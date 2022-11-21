package MyTests.Class21;

import org.testng.annotations.Test;

public class DependsOnMethodConcept {

    @Test()
    public void createUserTest(){
        System.out.println("Create user test");
        int i = 9/0;
    }
    @Test()
    public void loginTest(){
        System.out.println("Login to app");
    }

    @Test(dependsOnMethods = {"loginTest","createUserTest"}, priority = 1)
    public void homePageTest(){
        System.out.println("Home page test");
    }

    @Test(dependsOnMethods = "loginTest", priority = 2)
    public void searchTest(){
        System.out.println("Search test");
    }
}
