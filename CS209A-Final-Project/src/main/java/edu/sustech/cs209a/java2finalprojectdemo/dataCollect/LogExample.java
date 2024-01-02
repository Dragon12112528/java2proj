package edu.sustech.cs209a.java2finalprojectdemo.dataCollect;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LogExample {
    private static final Logger LOGGER = Logger.getLogger(LogExample.class.getName());

    public static void main(String[] args) {
        // 记录信息级别的日志
        LOGGER.log(Level.INFO, "这是一条信息级别的日志");

        // 记录警告级别的日志
        LOGGER.warning("这是一条警告级别的日志");

        // 记录严重错误级别的日志
        LOGGER.severe("这是一条严重错误级别的日志");
    }
}
