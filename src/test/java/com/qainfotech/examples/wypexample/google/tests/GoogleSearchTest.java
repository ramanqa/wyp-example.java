package com.qainfotech.examples.wypexample.google.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;
import org.testng.Reporter;
import static org.assertj.core.api.Assertions.*;

import java.util.Map;
import java.util.HashMap;
import java.net.URL;
import com.qainfotech.tap.boilerplates.wyp.TestSession;
import com.qainfotech.examples.wypexample.google.uimodel.LandingPage;
import com.qainfotech.examples.wypexample.google.uimodel.Results.Result;

public class GoogleSearchTest {

    WebDriver driver;
    TestSession testSession;

    @BeforeClass
    public void setUpBrowserInstance() throws Exception {
        ChromeOptions chromeOptions = new ChromeOptions();
        this.driver = new RemoteWebDriver(new URL("http://10.0.0.12:4444/wd/hub"), chromeOptions);
        Map<String, Object> config = new HashMap<>();
        config.put("timeout", 60);
        this.testSession = new TestSession(this.driver, config);
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
        
        Result firstResult = new LandingPage(this.testSession)
            .searchFor("QAInfoTech")
            .get(0);

        assertThat(firstResult.title()).contains("QA InfoTech");
    }
}
