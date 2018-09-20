package com.uc.server.config;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.async.DeferredResult;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
    @SuppressWarnings("unchecked")
	@Bean
    public Docket version100Api() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .groupName("v1.0.0")
                .genericModelSubstitutes(DeferredResult.class)
                .useDefaultResponseMessages(false)
                .forCodeGeneration(true)
                .pathMapping("/")// base，最终调用接口后会和paths拼接在一起
                .select()
                .paths(Predicates.or(PathSelectors.regex(".*/valuation.*|.*/user/.*|.*/visit/.*|.*/fuser/.*|.*/admin/.*|.*/valuation/.*")))//过滤的接口
                .build()
                .apiInfo(apiInfo());
        return docket;
    }

    @SuppressWarnings("unchecked")
	@Bean
    public Docket platformApi() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .groupName("test")
                .genericModelSubstitutes(DeferredResult.class)
                .useDefaultResponseMessages(false)
                .forCodeGeneration(true)
                .pathMapping("/")// base，最终调用接口后会和paths拼接在一起
                .select()
                .paths(Predicates.or(PathSelectors.regex("/.*")))//过滤的接口
                .build()
                .apiInfo(apiInfo());
        return docket;
    }


    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("gaea-API").description("©2016 Copyright. Powered By ucredit.")
                .contact(new Contact("gaea", "", "fumingjun")).license("Apache License Version 2.0")
                .licenseUrl("https://github.com/springfox/springfox/blob/master/LICENSE").version("2.0").build();
    }

}