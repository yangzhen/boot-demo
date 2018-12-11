package com.uc.server.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Slf4j
@Component
public class MyBeanFactory implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        //log.info("---------------------dsafsadf---- " + configurableListableBeanFactory);
        String[] names = configurableListableBeanFactory.getBeanDefinitionNames();
        //Arrays.stream(names).forEach(t ->  System.out.println("---sadfsdfsdf------------" + t));
    }
}
