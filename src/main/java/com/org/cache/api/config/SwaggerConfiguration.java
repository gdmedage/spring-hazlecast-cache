package com.org.cache.api.config;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * The Class SwaggerConfiguration.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

  /**
   * Api.
   *
   * @return the docket
   */
  @Bean
  public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2).select()
        .apis(RequestHandlerSelectors.basePackage("com.org.cache.api"))
        .paths(regex("/cache-api.*")).build();
  }
}
