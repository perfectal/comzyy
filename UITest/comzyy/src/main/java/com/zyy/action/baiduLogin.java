package com.zyy.action;
import org.openqa.selenium.WebDriver;

import com.zyy.pageObject.BasePage;

public class baiduLogin {
    private WebDriver driver;
    private BasePage loginPage;

    public baiduLogin(WebDriver driver) {
        this.driver = driver;
    }

    // ��¼����
    public void login(String username, String pwd) throws Exception {
        loginPage = new BasePage(driver, "baidulogin");//�����pageNameҪ��Ӧpage.xml�ļ��е�page��ǩֵ
        loginPage.sendKey("��¼�����˺ſ�", username);//��¼�����˺ſ��Ӧ����page.xml�����õ�Ԫ������
        loginPage.sendKey("��¼���������", pwd);
        loginPage.click("��¼");

    }
}
