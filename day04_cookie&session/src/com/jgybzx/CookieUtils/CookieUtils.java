package com.jgybzx.CookieUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * @author: guojy
 * @date: 2019/11/28 11:43
 * @Description: 编写cookie工具类
 * @version:
 */
public class CookieUtils {
    /**
     * 未使用 URL编码
     *
     * @param request  请求，设置cookie路径时使用 request.getContextPath()
     * @param response 响应，添加cookie给浏览器
     * @param name     cookieName
     * @param value    cookieValue
     */
    public static void addCookie(HttpServletRequest request, HttpServletResponse response, String name, String value) {
        Cookie cookie = new Cookie(name, value);
        //设置时间
        cookie.setMaxAge(7 * 24 * 60 * 60);//一周
        //设置访问哪个资源是可以携带这个cookie，项目路径
        cookie.setPath(request.getContextPath());
        //添加
        response.addCookie(cookie);
        System.out.println("添加成功");
    }

    /**
     * @param request 请求
     * @param name    cookieName
     * @return cookieValue
     */
    public static String getCookie(HttpServletRequest request, String name) {
        Cookie[] cookies = request.getCookies();
        String value = null;
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                String cookieName = cookie.getName();
                if (cookieName.equals(name)) {
                    value= cookie.getValue();
                    break;
                }
            }
        }
        return value;
    }

    /**
     * @param request  请求，设置cookie路径时使用 request.getContextPath()
     * @param response 响应，添加cookie给浏览器
     * @param name     cookieName
     * @param value    cookieValue
     * @param charset  URL编码
     */
    public static void addCookie(HttpServletRequest request, HttpServletResponse response, String name, String value, String charset) {
        //设置之前先进行 编码
        try {
            value = URLEncoder.encode(value, charset);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        Cookie cookie = new Cookie(name, value);
        //设置时间
        cookie.setMaxAge(7 * 24 * 60 * 60);//一周
        //设置访问哪个资源是可以携带这个cookie，项目路径
        cookie.setPath(request.getContextPath());
        //添加
        response.addCookie(cookie);
        System.out.println("添加成功");
    }

    /**
     *
     * @param request 请求
     * @param name    cookieName
     * @param charset URL解码
     * @return cookieValue
     */
    public static String getCookie(HttpServletRequest request, String name, String charset) {
        Cookie[] cookies = request.getCookies();
        String value = null;
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                String cookieName = cookie.getName();
                if (cookieName.equals(name) && name != null) {
                    value = cookie.getValue();
                    try {
                        value= URLDecoder.decode(value,charset);
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return value;
    }
}
