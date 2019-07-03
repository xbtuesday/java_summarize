package com.lpan.java_summarize.base.io;

import org.junit.jupiter.api.Test;

import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;

/**
 * @Description:
 * @author: shipan
 * @Date: 2019/6/19 22:45
 * @ClassName: InputStremTest
 * @Version 1.0
 */
public class InputStremTest {

    /**读取一个本地文件*/
    public static void  readtest(){
            File file = new File("D:\\aa\\rs_production.merchantInfoCpcnPay.properties");
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            byte []  bytes = new byte[2048];
            int i = 0;
            while((i=fileInputStream.read(bytes))>0){
                String s = new String(bytes,"UTF-8");
                System.out.println(s);
            }
            int read = fileInputStream.read();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        readtest();
    }


}
