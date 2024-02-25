package com.xunmaw.dormitory.config;

import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {
	
	public Docket customDocket() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
					   .apis(RequestHandlerSelectors.basePackage("com.xunmaw.dormitory.controller")).build();
	}
	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
					   //文档说明
					   .title("宿舍管理系统")
					   //文档版本说明
					   .version("1.0.0")
					   .description("管理学生宿舍")
					   .license("Apache 2.0")
					   .build();
	}
}
