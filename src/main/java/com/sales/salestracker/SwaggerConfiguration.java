package com.sales.salestracker;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration extends WebMvcConfigurationSupport {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("business").apiInfo(apiInfo()).select()
				.apis(RequestHandlerSelectors.basePackage("com.filestore.store.controller"))
				.paths(PathSelectors.ant("/**")).build().useDefaultResponseMessages(false)
				.globalResponseMessage(RequestMethod.GET, getGlobalDefaults())
				.globalResponseMessage(RequestMethod.PUT, getGlobalDefaults())
				.globalResponseMessage(RequestMethod.DELETE, getGlobalDefaults());
	}

	private List<ResponseMessage> getGlobalDefaults() {
		return Arrays.asList(new ResponseMessageBuilder().code(404).message("Not Found").build());
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("FileStore API")
				.description("FileStore API")
				.contact(new Contact("Okey Mama", "", "chandanchaubey@hotmail.com")).license("License")
				.licenseUrl("License Url").version("0.1").build();
	}

	@Override
	protected void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
	}

}
