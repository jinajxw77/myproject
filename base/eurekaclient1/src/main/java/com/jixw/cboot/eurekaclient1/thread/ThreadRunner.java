package com.jixw.cboot.eurekaclient1.thread;

import java.text.SimpleDateFormat;
import java.util.List;

public class ThreadRunner implements Runnable {

    private final SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss.SSS");

    /**
     * 线程私有属性，创建线程时创建
     */
    private List<String> num;

    public ThreadRunner(List<String> num) {
        this.num = num;
    }

    @Override
    public void run() {
        for(String midNum :  num){
            System.out.println(midNum);
        }
    }
}