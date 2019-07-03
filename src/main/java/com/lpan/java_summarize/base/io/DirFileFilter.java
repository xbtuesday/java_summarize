package com.lpan.java_summarize.base.io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

/**
 * ClassName: DirFileFilter
 * Description: TODO
 * Author: lpan
 * Date 02/07/19 下午 06:05
 * Version: 1.0
 */
public class DirFileFilter implements FilenameFilter {

    private Pattern pattern;

    public DirFileFilter(String regex){
        pattern = Pattern.compile(regex);
    }


    @Override
    public boolean accept(File dir, String name) {
        boolean matches = pattern.matcher(name).matches();
        return matches;
    }
}
