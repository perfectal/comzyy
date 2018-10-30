package com.zyy.pageObject;


/**
 * 封装页面元素，每个元素都有相应的定位地址（xpath路径或css或id）,等待时间，定位方式，默认为By.xpath
 *

 *
 */
public class Locator {


    private String adress;//定位地址
    private int waitSec;//等待时间
    private ByType byType;//定位方式 xpath ,id
    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getAdress() {
        return adress;
    }

    public int getWaitSec() {
        return waitSec;
    }

    public void setWaitSec(int waitSec) {
        this.waitSec = waitSec;
    }

    public ByType getByType() {
        return byType;
    }

    public void setByType(ByType byType) {
        this.byType = byType;
    }


    /**
     * 定义枚举类型
     */
    public enum ByType{
        id,xpath,linkText,name,className;
    }


    public Locator(String adress, int i, ByType byType){

    }

    /**
     * Locator构造器，默认定位类型By.xpath,等待时长3s
     */
    public Locator(String adress){
        this.adress=adress;
        this.waitSec=3;
        this.byType=ByType.xpath;
    }

    public Locator(String adress,int sec){
        this.adress=adress;
        this.waitSec=sec;
        this.byType=ByType.xpath;
    }
    public Locator(String adress,ByType byType,int waitSec){
        this.adress=adress;
        this.waitSec=waitSec;
        this.byType=ByType.xpath;
    }





}
