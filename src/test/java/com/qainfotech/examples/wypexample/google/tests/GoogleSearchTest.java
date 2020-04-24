package com.qainfotech.examples.wypexample.google.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.testng.Reporter;
import static org.assertj.core.api.Assertions.*;

import com.qainfotech.examples.wypexample.google.uimodel.LandingPage;
import com.qainfotech.examples.wypexample.google.uimodel.Results.Result;

public class GoogleSearchTest {

    WebDriver driver;

    @BeforeClass
    public void setUpiBrowserInstance(){
        this.driver = new ChromeDriver();
    }

    @AfterClass
    public void tearDownBrowserInstance(){
        this.driver.quit();
    }

    @BeforeMethod
    public void resetAUTBaseState(){
        this.driver.get("http://www.google.com");
    }

    @Test
    public void testBasicKeywordSearch(){
        
        Result firstResult = new LandingPage(this.driver)
            .searchFor("QAInfoTech")
            .get(0);

        assertThat(firstResult.title()).contains("QA InfoTech");
    }
}
