package edu.sustech.cs209a.java2finalprojectdemo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    public static void logOk( String action) {
        logger.info(action);
    }
    public static void logWarn(String action){
        logger.error(action);
    }
}
