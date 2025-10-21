package com.banksystem.application.utills;

import com.banksystem.application.entity.AdminInfo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ConvertUtils {
    public static Instant toInstant(String time){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date;
        try {
            date = sdf.parse(time);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return date.toInstant();
    }
    public static String getCookie(int num) {
        String string = "abcdefjhijkmlnopqrstuvwxyz";
        StringBuffer sb = new StringBuffer();
        Random random = new Random();
        for (int i = 0; i < num; i++) {
            int index = random.nextInt(string.length());
            sb.append(string.charAt(index));
        }
        return sb.toString();
    }

    /**
     *管理员登录map
     */
    public static Map<String, AdminInfo> ADMIN_LOGIN_MAP = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(getCookie(12));
    }
}
