package scripts;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;
import pages.UnitedAirlinesLandingPage;
import utilities.Driver;

public class Base {
    WebDriver driver;
    SoftAssert softAssert;
    UnitedAirlinesLandingPage unitedAirlinesLandingPage;



    @BeforeMethod
    public void setup(){
        driver = Driver.getDriver();
        softAssert = new SoftAssert();
        unitedAirlinesLandingPage = new UnitedAirlinesLandingPage();

    }


    @AfterMethod
    public void teardown(){
        softAssert.assertAll();
        Driver.quitDriver();
    }




}
