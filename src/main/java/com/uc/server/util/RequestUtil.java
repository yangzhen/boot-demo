package com.uc.server.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class RequestUtil {


    private static final Logger logger = LoggerFactory.getLogger(RequestUtil.class);

    private static String getClientIp(HttpServletRequest request) {
        String ip = request.getHeader("NS-Client-IP");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("x-forwarded-for");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }

        return ip;
    }

    public static String getIp(HttpServletRequest request) {
        String ip = getClientIp(request);

		/* 注册ip长度限制为15 */
        if (ip != null && ip.length() > 15) {
            //**.***.***.***".length() = 15
            if (ip.indexOf(",") > 0) {
                ip = ip.substring(0, ip.indexOf(","));
            }
        }

//        logger.info("ip+++++++++++++"+ip);
        return ip;
    }

    public static Map<String, String> getHttpParamter(HttpServletRequest request) {
        Map<String, String[]> map = request.getParameterMap();
        Map<String, String> paramMap = new HashMap<String, String>();
        for (Entry<String, String[]> entry : map.entrySet()) {
            String name = entry.getKey();
            String value[] = entry.getValue();
            if (value.length > 1) {
                logger.warn("http request param has too many value,name:{},value:{}",
                        name, Arrays.asList(value));
                continue;
            }
            paramMap.put(name, value[0]);
        }
        return paramMap;
    }
    
    
}