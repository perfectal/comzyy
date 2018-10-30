package com.zyy.action;
import org.openqa.selenium.WebDriver;

import com.zyy.pageObject.BasePage;

public class baiduLogin {
    private WebDriver driver;
    private BasePage loginPage;

    public baiduLogin(WebDriver driver) {
        this.driver = driver;
    }

    // 登录操作
    public void login(String username, String pwd) throws Exception {
        loginPage = new BasePage(driver, "baidulogin");//这里的pageName要对应page.xml文件中的page标签值
        loginPage.sendKey("登录输入账号框", username);//登录输入账号框对应的是page.xml中设置的元素名称
        loginPage.sendKey("登录输入密码框", pwd);
        loginPage.click("登录");

    }
}
