
package com.zyy.utils;




import java.io.File;
import java.util.HashMap;
import java.util.Iterator;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.zyy.pageObject.Locator;
import com.zyy.pageObject.Locator.ByType;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class XMLUtil {

    /**
     * ��ȡҳ�������ļ�
     *
     * @author ljl
     * @param xmlUrl
     *            ҳ�������ļ�·��
     * @param pageName
     *            ҳ������
     */
    public static HashMap<String, Locator> readXMLDocument(String xmlUrl, String pageName) throws Exception {
        Logger log = LogManager.getLogger(XMLUtil.class);
       // LogUtil log = new LogUtil(XMLUtil.class);
        HashMap<String, Locator> locatorMap = new HashMap<>();
        File file = new File(xmlUrl);
        if (!file.exists()) {
            log.error("can't find " + xmlUrl);
        } else {
            // ����SAXReader����
            SAXReader sr = new SAXReader();
            // ��ȡxml�ļ�ת��ΪDocument
            Document document = sr.read(file);
            // ��ȡ���и��ڵ�Ԫ�ض���
            Element root = document.getRootElement();
            Iterator<?> rootIte = root.elementIterator();
            Locator locator = null;
            // �������ڵ�
            while (rootIte.hasNext()) {
                Element page = (Element) rootIte.next();
                if (log.isInfoEnabled()){
                    log.info("pageName is " + pageName);}

                // ���Դ�Сд�Ƚ�
                if (page.attribute(0).getValue().equalsIgnoreCase(pageName)) {
                    Iterator<?> pageIte = page.elementIterator();
                    // �ҵ�pageName�������page�ڸ����ڵ�
                    while (pageIte.hasNext()) {
                        String type = "";
                        String timeOut = "3";
                        String value = "";
                        String locatorName = "";
                        Element locatorEle = (Element) pageIte.next();
                        Iterator<?> locatorIte = locatorEle.attributeIterator();
                        // ����������ǩ�ڵ�Ԫ��
                        while (locatorIte.hasNext()) {
                            Attribute attribute = (Attribute) locatorIte.next();
                            String attributeName = attribute.getName();
                            if (attributeName.equals("type")) {
                                type = attribute.getValue();
                            } else if (attributeName.equals("timeOut")) {
                                timeOut = attribute.getValue();
                            } else {
                                value = attribute.getValue();
                            }
                        }
                        locator = new Locator(value, Integer.parseInt(timeOut), getByType(type));
                        locatorName = locatorEle.getText();
                        locatorMap.put(locatorName, locator);

                    }
                    break;
                }
            }
        }
        return locatorMap;
    }

    /**
     * ת��Ԫ�ض�λ����
     *
     * @author ljl
     */
    public static ByType getByType(String type) {
        ByType byType = ByType.xpath;
        if (type == null || type.equalsIgnoreCase("xpath")) {
            byType = ByType.xpath;
        } else if (type.equalsIgnoreCase("id")) {
            byType = ByType.id;
        } else if (type.equalsIgnoreCase("name")) {
            byType = ByType.name;
        } else if (type.equalsIgnoreCase("className")) {
            byType = ByType.className;
        }
        return byType;
    }}
