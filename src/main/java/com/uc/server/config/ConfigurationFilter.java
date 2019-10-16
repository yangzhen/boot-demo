package com.uc.server.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.uc.server.util.MDCHolder;
import com.uc.server.util.RequestUtil;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.UUID;
import org.springframework.http.MediaType;

@Configuration
public class ConfigurationFilter {

    private static final Logger logger = LoggerFactory.getLogger(ConfigurationFilter.class);

    @Bean
    public HttpMessageConverters fastJsonConfigure() {
        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
        //日期格式化
        fastJsonConfig.setDateFormat("yyyy-MM-dd HH:mm:ss");
        converter.setFastJsonConfig(fastJsonConfig);

        List<MediaType> jsonMediaTypes = new ArrayList<>();
        jsonMediaTypes.add(MediaType.APPLICATION_JSON);
        jsonMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);

        converter.setSupportedMediaTypes(jsonMediaTypes);

        return new HttpMessageConverters(converter);
    }
	
	@Bean
    public FilterRegistrationBean logFilter() {
        FilterRegistrationBean logFilter = new FilterRegistrationBean();
        logFilter.addUrlPatterns("/*");
        logFilter.setFilter(new com.yxy.common.config.TraceFilter());
        return logFilter;
    }
	
	
//	public class LogFilter implements Filter {
//        @Override
//        public void destroy() {
//        	MDCHolder.clear();
//        }
//
//        @Override
//        public void doFilter(ServletRequest srequest, ServletResponse sresponse, FilterChain
//                filterChain)
//                throws IOException, ServletException {
//        	HttpServletRequest httpServletRequest = (HttpServletRequest)srequest;
//
//            MDCHolder.putTraceId(UUID.randomUUID().toString());
//            MDCHolder.putUserIp(RequestUtil.getIp(httpServletRequest));
//
//            logger.info("--------------------> in " + ((HttpServletRequest) srequest).getRequestURI());
//
//            try {
//                filterChain.doFilter(srequest, sresponse);
//            } finally {
//                MDCHolder.clear();
//            }
//            logger.info("--------------------> out " + ((HttpServletRequest) srequest).getRequestURI());
//
//        }
//
//        @Override
//        public void init(FilterConfig arg0) throws ServletException {
//
//        }
//    }
}
