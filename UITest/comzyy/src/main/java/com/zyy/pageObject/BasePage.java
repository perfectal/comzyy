package com.zyy.pageObject;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.zyy.utils.UIExecutorImpl;
import com.zyy.utils.XMLUtil;


public class BasePage extends UIExecutorImpl {
    protected WebDriver driver;
    protected String pageName;// ҳ������
    protected String xmlPath;// ҳ��Ԫ�������ļ�·��
    protected HashMap<String, Locator> locatorMap;//�洢ҳ��Ԫ����Ϣ
    //public LogUtil log;

    public BasePage(WebDriver driver, String pageName) throws Exception {
        super(driver);
        this.driver = driver;
        this.pageName = pageName;
        // ��ȡpage.xml·����page.xml��ͬ��Ŀ¼
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
     * ����locatorName���ض�Ӧ��locator
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
