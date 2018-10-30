package com.zyy.utils;

import com.zyy.pageObject.Locator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.Set;


public class UIExecutorImpl implements UIExecutor{
    Logger log = LogManager.getLogger(UIExecutorImpl.class);
    private WebDriver driver;
    public UIExecutorImpl(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;}




    public WebElement getElement(Locator locator) throws Exception {
        WebElement element=null;
        String address=locator.getAdress();
        switch (locator.getByType()) {
            case xpath:
                element = driver.findElement(By.xpath(address));
                break;
            case id:
                element = driver.findElement(By.id(address));
                break;
            case className:
                element = driver.findElement(By.className(address));
                break;
            case linkText:
                element = driver.findElement(By.linkText(address));
                break;
            default:
                break;
        }
        return element;

    }

    @Override
    public void click(Locator locator)   {


        WebElement element= null;
        try {
            element = getElement(locator);
        } catch (Exception e) {
            log.warn("定位不到"+element);


        }

        element.click();

    }

    public void sendKey(Locator locator, String value) {

        WebElement element= null;
        try {
            element = getElement(locator);
        } catch (Exception e) {
            log.warn("定位不到"+element);
        }
        element.clear();
        element.sendKeys(value);

    }

    public String getText(Locator locator) {
        WebElement element=null;
        try {
            element=getElement(locator);
        } catch (Exception e) {
            log.warn("定位不到"+element);
        }
        if (element.getText()!=null)
        {
            return element.getText();}
        else {
            return null;

        }


    }



    public boolean isElementDisplayed(Locator locator) {
        WebElement element=null;
        boolean flag=false;
        try {
            element=getElement(locator);
        } catch (Exception e) {
            log.warn("定位不到"+element);
        }
       flag=element.isDisplayed();
        return flag;

    }

    public void switchWindow(String title) {
        Set<String> handles=driver.getWindowHandles();
        for (String handle:handles){
            if (handle.equals(driver.getWindowHandle())){
                continue;
            }else {
                driver.switchTo().window(handle);
                if (title.contains(driver.getTitle())){
                    break;
                }else {
                    continue;
                }
            }
        }


    }

    public void switchFrame(Locator locator) {
        driver.switchTo().frame(locator.getAdress());

    }
}
