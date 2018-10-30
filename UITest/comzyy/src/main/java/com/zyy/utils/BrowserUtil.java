package com.zyy.utils;

import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeUnit;

        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.chrome.ChromeDriver;
        import org.openqa.selenium.firefox.FirefoxDriver;
        import org.openqa.selenium.ie.InternetExplorerDriver;
        import org.openqa.selenium.remote.DesiredCapabilities;

public class BrowserUtil {
    private static WebDriver driver;

    /**
     * ����ie�����
     *
     * @param browserDriverUrl
     *            ���������url
     * @param sec
     *            ����ҳ������ĵȴ���ʱʱ�����˴�Ϊ��ʽ�ȴ�����ʱ���Ҳ���Ԫ�����׳��쳣NoSuchElementException
     * @author ljl
     */
    public static WebDriver ie(String browserDriverUrl, long sec) {
        System.setProperty("webdriver.ie.driver", browserDriverUrl);
        // �ر�IE����ģʽ
        DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
        ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
        driver = new InternetExplorerDriver(ieCapabilities);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
        return driver;
    }

    /**
     * ����chrome�����
     *
     * @param browserDriverUrl
     *            ���������url
     * @param sec
     *            ����ҳ������ĵȴ���ʱʱ��
     * @author ljl
     */
    public static WebDriver chrome(String browserDriverUrl, long sec) {
        System.setProperty("webdriver.chrome.driver", browserDriverUrl);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
        return driver;
    }

    /**
     * ����fireFox�����
     *
     * @param browserDriverUrl
     *            ���������url
     * @param sec
     *            ����ҳ������ĵȴ���ʱʱ��
     * @author ljl
     */
    public static WebDriver fireFox(String browserDriverUrl, long sec) {
        System.setProperty("webdriver.firefox.bin", browserDriverUrl);
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
        return driver;
    }

    /**
     * ����htmlUnitDriver,�����ʵ���������������ٶȿ� ����ҳ���и���jsʱ���ᶨλ����Ԫ�أ�������ʹ��
     *
     * @author ljl
     *   public static WebDriver htmlUnitDriver(long sec) {
    driver = new HtmlUnitDriver();
    driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
    return driver;
    }
     */

}
