package com.lpan.java_summarize.base.io;

import java.io.File;

/**
 * ClassName: FileTest
 * Description: TODO
 * Author: lpan
 * Date 02/07/19 下午 05:49
 * Version: 1.0
 */
public class FileTest {


    public static void main(String[] args) {
        direach();

    }

    public static void  direach(){
        File
                file = new File("/home/lpan/Documents"),
                dfile = new File("/home/lpam/Download/");
        file.renameTo(dfile);
        dfile.list();
        String[] list = file.list(new DirFileFilter(".+(.xlsx|.xls|.pdf|.jpg|.deb)$"));
        for (String filename:list) {
            System.out.println(filename);
        }
    }



}