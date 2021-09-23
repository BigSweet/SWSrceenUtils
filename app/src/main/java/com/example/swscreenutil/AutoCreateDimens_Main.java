package com.example.swscreenutil;

import org.xml.sax.SAXException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

/**
 * 根据一个已知的dimens文件生成各sw文件
 */
public class AutoCreateDimens_Main {

    public static void main(String[] args) throws IOException {
        int wudthDp = 1080; // 已知的文件的宽度dp
        DimensParser parser = new DimensParser();
        FileInputStream fileInputStream = new FileInputStream(Config.path + File.separator + "dimens1.xml");
        //定义你想要多少种类的像素
        FileOutputStream fileOutputStream = new FileOutputStream(Config.path + File.separator + "dimens1.xml");
//        for (int i = 0; i < 1920; i++) {
//            String content = "<dimen name=\"dp" + i + "\">" + i + "dp</dimen>\n";
//            fileOutputStream.write(content.getBytes());
//        }
        //这里结束
        try {
            //文件目录 项目的dimens目录下
            List<DimenValues> list = parser.parse(
                    new FileInputStream(Config.path + File.separator + "dimens.xml"));
            DimensCreator creator = new DimensCreator(Config.path, list, wudthDp);
            creator.createAll();
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}
