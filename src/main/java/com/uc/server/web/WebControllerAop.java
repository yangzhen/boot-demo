package com.uc.server.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import java.lang.reflect.Method;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;

import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInvocation;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.aop.interceptor.ExposeInvocationInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerExecutionChain;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

/**
 * @author yangxinyan
 * @date 2019/9/25 17:27
 */
@Aspect
@Component("testaop")
@Slf4j
public class WebControllerAop {

  @Autowired
  private RequestMappingHandlerMapping handlerMapping;

  @Pointcut("@within(org.springframework.web.bind.annotation.RestController) or @within(org.springframework.web.bind.annotation.Controller)")
  public void shareCut() {

  }

  @AfterReturning(pointcut="shareCut()", returning = "retVal")
  public void around(JoinPoint jp, Object retVal) {

    MethodInvocation mi = ExposeInvocationInterceptor.currentInvocation();
    Method method = mi.getMethod();
    HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    try {
      HandlerExecutionChain chain = handlerMapping.getHandler(request);
      HandlerMethod handlerMethod = (HandlerMethod) chain.getHandler();
      boolean flag = handlerMethod.getMethod().equals(method);
      System.out.println("============>方法相同," + flag);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return ;
  }


  public static void main(String[] args) {
    System.out.println(isHandler(TestController.class));
  }

  protected static boolean isHandler(Class<?> beanType) {
    return (AnnotatedElementUtils.hasAnnotation(beanType, Controller.class) ||
            AnnotatedElementUtils.hasAnnotation(beanType, RequestMapping.class));
  }


}
