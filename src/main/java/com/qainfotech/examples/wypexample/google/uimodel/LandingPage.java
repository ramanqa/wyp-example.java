package com.qainfotech.examples.wypexample.google.uimodel;

import com.qainfotech.tap.boilerplates.wyp.YamlPage;
import org.openqa.selenium.WebDriver;
import com.qainfotech.tap.boilerplates.wyp.TestSession;
import com.jcabi.aspects.Loggable;

@Loggable
public class LandingPage extends YamlPage {

    public LandingPage(TestSession session){
        super(session);
    }

    public Results searchFor(String keyword){
        this.element("searchBox").sendKeys(keyword);
        this.element("searchBox").submit();
        return new Results(this.testSession);
    }
}
