package com.qainfotech.examples.wypexample.google.uimodel;

import com.qainfotech.tap.boilerplates.wyp.YamlPage;
import org.openqa.selenium.WebDriver;

public class LandingPage extends YamlPage {

    public LandingPage(WebDriver driver){
        super(driver);
    }

    public Results searchFor(String keyword){
        this.element("searchBox").sendKeys(keyword);
        this.element("searchBox").submit();
        return new Results(this.driver);
    }
}
