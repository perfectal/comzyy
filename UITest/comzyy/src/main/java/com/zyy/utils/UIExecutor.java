package com.zyy.utils;

import org.openqa.selenium.WebElement;
import com.zyy.pageObject.Locator;
public interface UIExecutor {
    /**���*/
    public void click(Locator locator) ;
/**�����ı�*/
    public void sendKey(Locator locator,String value);
 /**��ȡԪ���ı�*/
    public String getText(Locator locator);
 /**��ȡԪ��*/
    public WebElement getElement(Locator locator) throws Exception;
 /**�ж�Ԫ���Ƿ���ʾ*/
    public boolean isElementDisplayed(Locator locator);
 /**�л�ҳ��*/
    public void switchWindow(String title);
 /**�л�frame*/
    public void switchFrame(Locator locator);
 /**���ܵȴ�*/
}
