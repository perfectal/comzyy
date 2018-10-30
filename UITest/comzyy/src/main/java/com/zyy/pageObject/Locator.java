package com.zyy.pageObject;


/**
 * ��װҳ��Ԫ�أ�ÿ��Ԫ�ض�����Ӧ�Ķ�λ��ַ��xpath·����css��id��,�ȴ�ʱ�䣬��λ��ʽ��Ĭ��ΪBy.xpath
 *

 *
 */
public class Locator {


    private String adress;//��λ��ַ
    private int waitSec;//�ȴ�ʱ��
    private ByType byType;//��λ��ʽ xpath ,id
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
     * ����ö������
     */
    public enum ByType{
        id,xpath,linkText,name,className;
    }


    public Locator(String adress, int i, ByType byType){

    }

    /**
     * Locator��������Ĭ�϶�λ����By.xpath,�ȴ�ʱ��3s
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
