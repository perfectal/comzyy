package com.zyy.testcase;

import com.zyy.action.baiduLogin;
import com.zyy.pageObject.BasePage;
import com.zyy.utils.BrowserUtil;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginTest {

    private WebDriver driver;
    private baiduLogin login;

    @DataProvider(name = "loginParams")
    public Object[][] loginParams() {
        return new Object[][]{{"13661425605", "", "请您输入密码"}};
    }



    @BeforeClass
    @Parameters({"browserDriverUrl", "url"})
    public void beforeClass(String browserDriverUrl, String url) {
        driver = BrowserUtil.chrome(browserDriverUrl, 30);
        //在内存中运行，不用启用浏览器，使用该方法无法使用截图功能
        //driver = new HtmlUnitDriver();
        driver.get(url);
    }

    @Test(dataProvider = "loginParams", description = "异常用户信息登录")
    public void login02(String username, String pwd, String expectedTip) throws Exception {
        login.login(username, pwd);
        String tip = new BasePage(driver, "baiduloginpage").getText("异常提示");
        Assert.assertEquals(tip, expectedTip);
    }

    @AfterClass
    public void afterClass() {

    }

    @AfterTest
    public void afterTest() {
        driver.quit();


    }
}
