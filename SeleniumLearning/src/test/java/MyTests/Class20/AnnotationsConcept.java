package MyTests.Class20;

import org.testng.annotations.*;

public class AnnotationsConcept {
    
    /*
     *  BS -- DBConnection
            BT -- createUser
            BC -- launchBrowser
            BM -- loginToApp
                Test2 -- accountInfoTest
            AM -- logout
            BC -- loginToApp
                Test1 -- userInfoTest
            AM -- logout
            AC -- Close browser
            AT -- deleteUser
        PASSED: MyTests.Class20.AnnotationsConcept.userInfoTest
        PASSED: MyTests.Class20.AnnotationsConcept.accountInfoTest
     */

    @BeforeSuite
    public void DBConnection(){
        System.out.println("BS -- DBConnection");
    }

    @BeforeTest
    public void createUser(){
        System.out.println("BT -- createUser");
    }

    @BeforeClass
    public void launchBrowser(){
        System.out.println("BC -- launchBrowser");
    }

    @BeforeMethod
    public void loginToApp(){
        System.out.println("BM -- loginToApp");
    }

    @Test
    public void userInfoTest(){
        System.out.println("Test1 -- userInfoTest");
    }

    @Test
    public void accountInfoTest(){
        System.out.println("Test2 -- accountInfoTest");
    }
    
    @Test
    public void profileTest(){
        System.out.println("Test3 -- ProfileTest");
    }

    @AfterMethod
    public void logout(){
        System.out.println("AM -- logout");
    }

    @AfterClass
    public void closeBrowser(){
        System.out.println("AC -- Close browser");
    }

    @AfterTest
    public void deleteUser(){
        System.out.println("AT -- deleteUser");
    }

    @AfterSuite
    public void disconnectDB(){
        System.out.println("AS -- disconnectDB");
    }
}
