package com.uc.server.config;

import com.uc.server.util.MDCHolder;
import com.uc.server.util.RequestUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.UUID;

@Configuration
public class ConfigurationFilter {

    private static final Logger logger = LoggerFactory.getLogger(ConfigurationFilter.class);

	
	@Bean  
    public FilterRegistrationBean logFilter() {  
        FilterRegistrationBean logFilter = new FilterRegistrationBean();  
        logFilter.addUrlPatterns("/*");  
        logFilter.setFilter(new LogFilter());  
        return logFilter;  
    }  
	
	
	public class LogFilter implements Filter {
        @Override
        public void destroy() {
        	MDCHolder.clear();
        }

        @Override
        public void doFilter(ServletRequest srequest, ServletResponse sresponse, FilterChain
                filterChain)
                throws IOException, ServletException {
        	HttpServletRequest httpServletRequest = (HttpServletRequest)srequest;

            MDCHolder.putTraceId(UUID.randomUUID().toString());
            MDCHolder.putUserIp(RequestUtil.getIp(httpServletRequest));

            logger.info("---------------------------" + ((HttpServletRequest) srequest).getRequestURI());
            
            filterChain.doFilter(srequest, sresponse);
            
        }

        @Override
        public void init(FilterConfig arg0) throws ServletException {
        	
        }
    }
}
