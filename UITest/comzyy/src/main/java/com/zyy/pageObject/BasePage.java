package com.zyy.pageObject;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.zyy.utils.UIExecutorImpl;
import com.zyy.utils.XMLUtil;


public class BasePage extends UIExecutorImpl {
    protected WebDriver driver;
    protected String pageName;// 页面名称
    protected String xmlPath;// 页面元素配置文件路径
    protected HashMap<String, Locator> locatorMap;//存储页面元素信息
    //public LogUtil log;

    public BasePage(WebDriver driver, String pageName) throws Exception {
        super(driver);
        this.driver = driver;
        this.pageName = pageName;
        // 获取page.xml路径，page.xml在同级目录
        xmlPath = this.getClass().getResource("").getPath() + "page.xml";
        locatorMap = XMLUtil.readXMLDocument(xmlPath, pageName);
    }

    public void click(String locatorName) {
        super.click(getLocator(locatorName));
    }

    public void sendKey(String locatorName, String value) {
        super.sendKey(getLocator(locatorName), value);
    }

    public String getText(String locatorName) {
        return super.getText(getLocator(locatorName));
    }

    public WebElement getElement(String locatorName) throws Exception{
        return super.getElement(getLocator(locatorName));
    }

    public boolean isElementDisplayed(String locatorName) {
        return super.isElementDisplayed(getLocator(locatorName));
    }

    public void switchWindow(String title) {
        super.switchWindow(title);
    }

    public void switchFrame(String locatorName) {
        super.switchFrame(getLocator(locatorName));
    }

    /**
     * 根据locatorName返回对应的locator
     *
     * @author ljl
     */
    public Locator getLocator(String locatorName) {
        Locator locator = null;
        if (locatorMap != null) {
            locator = locatorMap.get(locatorName);
        }
        return locator;
    }
}
