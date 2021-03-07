package com.qainfotech.examples.wypexample.google.uimodel;

import com.qainfotech.tap.boilerplates.wyp.YamlPage;
import com.qainfotech.tap.boilerplates.wyp.YamlWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import com.jcabi.aspects.Loggable;

@Loggable
public class Results extends YamlPage {
    
    public Results(WebDriver driver){
        super(driver);
    }

    public Result get(Integer index){
        return new Result(this.elements("results").get(index));
    }

    public class Result{
       
        YamlWebElement result;

        public Result(YamlWebElement element){
            this.result = element;
        }

        public String title(){
            return this.result.findElement(By.cssSelector("a h3")).getText();
        }

        public String description(){
            return this.result.findElement(By.cssSelector(".st")).getText();
        }
    }
}
